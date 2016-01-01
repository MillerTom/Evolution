/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDRootEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDRootEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DILFDRootService",
portName="DILFDRootServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDRootEndpoint")
public class DILFDRootEndpointImpl extends SpringBeanAutowiringSupport
		implements DILFDRootEndpoint {

    private static final String RPCCALL = "DDR SOA FILE ROOT RESOLVER";

    @Autowired
    private DILFDResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default Bean Constructor
     */
    public DILFDRootEndpointImpl() {
        super();
    }

    /**
     * Construtor Initializes the Class
     * @param context
     * @param factory
     */
    public DILFDRootEndpointImpl(final IVistaLinkContext context,
            final DILFDResponseFactory factory) {

        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }


	/** (non-Javadoc)
	 * @throws VistaWebServiceFault
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDRootEndpoint#root(gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootRequest)
	 */
	@Override
	public DILFDRootResponse root(final DILFDRootRequest request) throws VistaWebServiceFault {

	    /*
		List<String> params = new ArrayList<String>(4);

	    params.add(0, request.getFile());
	    params.add(1, request.getIens());
	    params.add(2, request.getFlags());
	    params.add(3, request.getErrorFlag());
	    */
		
		List<Object> params = new ArrayList<Object>();
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("FILE", request.getFile());
		paramsMap.put("IENS", request.getIens());
		paramsMap.put("FLAGS", request.getFlags());
		paramsMap.put("ERROR_FLAG", request.getErrorFlag());
		
		params.add(paramsMap);
		
		return this.responseFactory
		        .createRootResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
	}

}
