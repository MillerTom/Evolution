
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints;

import gov.va.med.exception.FoundationsException;
import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.med.vistalink.rpc.RpcRequestFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.DIALOGResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGBldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *  (non-Javadoc)
 * @see gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGBldEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DIALOGBldService",
portName="DIALOGBldServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGBldEndpoint")
public class DIALOGBldEndpointImpl extends SpringBeanAutowiringSupport implements DIALOGBldEndpoint {

    private static final String RPCCALL = "DDR SOA BUILD DIALOG";
    
    private static final Logger LOGGER = Logger.getLogger(DIALOGBldEndpointImpl.class);
    
    @Autowired
    private DIALOGResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default Bean Constructor
     */
    public DIALOGBldEndpointImpl() {
        super();
    }

    /**
     * Constructor initializes the member variables
     * @param context
     * @param factory
     */
    public DIALOGBldEndpointImpl(final IVistaLinkContext context,
            final DIALOGResponseFactory factory) {

        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

	/** (non-Javadoc)
	 * @throws VistaWebServiceFault 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGBldEndpoint#bld(gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldRequest)
	 */
	@Override
	public DIALOGBldResponse bld(final DIALOGBldRequest request) throws VistaWebServiceFault {    
	    
		try {
			List<Object> params = new ArrayList<Object>();
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("DIALOG", request.getDialogNum());
			if (request.getTextParam() != null && request.getTextParam().size() > 1) {
				int idx = 1;
				for (int i = 0; i < request.getTextParam().size(); i++) {
					paramsMap.put(RpcRequest.buildMultipleMSubscriptKey("\"TEXT\"," + idx),request.getTextParam().get(i));
					idx++;
				}
			} else if (request.getTextParam() != null && request.getTextParam().size() > 0) {
				paramsMap.put("TEXT", request.getTextParam().get(0));
			} else {
				paramsMap.put("TEXT", "");
			}
			paramsMap.put("FLAGS", request.getFlags());

			params.add(paramsMap);

			return this.responseFactory
					.createBldFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));   
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
