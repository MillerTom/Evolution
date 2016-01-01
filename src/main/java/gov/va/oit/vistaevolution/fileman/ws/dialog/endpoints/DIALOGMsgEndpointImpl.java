
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dialog.DIALOGResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGMsgEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @see gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGMsgEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DIALOGMsgService",
portName="DIALOGMsgServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGMsgEndpoint")
public class DIALOGMsgEndpointImpl implements DIALOGMsgEndpoint {
    
    private static final String RPCCALL = "";

    @Autowired
    private DIALOGResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default bean constructor
     */
    public DIALOGMsgEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes object
     * @param context
     * @param factory
     */
    public DIALOGMsgEndpointImpl(IVistaLinkContext context, 
            DIALOGResponseFactory factory) {
        
        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
    
	/** (non-Javadoc)
	 * @throws VistaWebServiceFault 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGMsgEndpoint#msg(gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgRequest)
	 */
	@Override
	public DIALOGMsgResponse msg(DIALOGMsgRequest request) throws VistaWebServiceFault {
	    
	    
	    List<Object> params = new ArrayList<Object>(5);
	    
	    params.add(0, request.getFlags());
	    params.add(1, null);
	    params.add(2, request.getTextWidth());
	    params.add(3, request.getLeftMargin());
	    params.add(4, request.getInputRoot());
	    
	    return this.responseFactory
	            .createMsgFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));  //  TODO: Need proper call.
	}

}
