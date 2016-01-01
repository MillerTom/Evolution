/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDFldnumEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDFldnumEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DILFDFldnumService",
portName="DILFDFldnumServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDFldnumEndpoint")
public class DILFDFldnumEndpointImpl extends SpringBeanAutowiringSupport
		implements DILFDFldnumEndpoint {

    private static final String RPCCALL = "DDR SOA FIELD NUMBER RETRIEVER";

    @Autowired
    private DILFDResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default Bean Constructor
     */
    public DILFDFldnumEndpointImpl() {
        super();
    }

    /**
     * Bean Constructor initializes object
     * @param context
     * @param factory
     */
    public DILFDFldnumEndpointImpl(final IVistaLinkContext context,
            final DILFDResponseFactory factory) {

        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }


	/** (non-Javadoc)
	 * @throws VistaWebServiceFault
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDFldnumEndpoint#fldnum(gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumRequest)
	 */
	@Override
	public DILFDFldnumResponse fldnum(final DILFDFldnumRequest request) throws VistaWebServiceFault {

	    /*
		List<String> params = new ArrayList<String>();

	    params.add(request.getFile());
	    params.add(request.getFieldName());
		*/
		
	    List<Object> params = new LinkedList<Object>();
	    Map<String, Object> parameterMap = new HashMap<String, Object>(2);

	    parameterMap.put("FILE", request.getFile());
	    parameterMap.put("FIELD NAME", request.getFieldName());

	    params.add(parameterMap);

		return this.responseFactory
		        .createFldnumResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
	}

}
