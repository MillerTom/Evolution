package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.DIALOGResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGEzBldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldResponse;
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
 *
 * @see gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGEzBldEndpoint
 *
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DIALOGEzBldService",
portName="DIALOGEzBldServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGEzBldEndpoint")
public class DIALOGEzBldEndpointImpl extends SpringBeanAutowiringSupport 
    implements DIALOGEzBldEndpoint {
    
    private static final String RPCCALL = "DDR SOA DIALOG EXTRACTOR";

    @Autowired
    private DIALOGResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    private static final Logger LOG = Logger
            .getLogger(DIALOGEzBldEndpointImpl.class);    

    /**
     * Default Bean Constructor
     */
    public DIALOGEzBldEndpointImpl() {
        super();
        
    }

    /**
     * Bean Constructor initializes object
     * @param context
     * @param factory
     */
    public DIALOGEzBldEndpointImpl(final IVistaLinkContext context,
            final DIALOGResponseFactory factory) {

        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

	/** (non-Javadoc)
	 * @throws VistaWebServiceFault
	 * @see gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGEzBldEndpoint#ezbld(gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldRequest)
	 */
	@Override
	public DIALOGEzBldResponse ezbld(final DIALOGEzBldRequest request) 
	        throws VistaWebServiceFault {

	    List<Object> params = new ArrayList<Object>(2);
	    Map<String, Object> paramsMap = new HashMap<String, Object>(4);
	       
	    paramsMap.put("DIALOG", request.getDialog());	 
	    
	    if (null != request.getText() && !request.getText().isEmpty()) {
	        paramsMap.put("TEXT", request.getText());
	    }
	    else if ((null != request.getFile() && !request.getFile().isEmpty()) ||
	             (null != request.getField() && !request.getField().isEmpty())) {	        

	        paramsMap.put(RpcRequest.buildMultipleMSubscriptKey("\"TEXT\",\"FILE\""), request.getFile());
	        paramsMap.put(RpcRequest.buildMultipleMSubscriptKey("\"TEXT\",\"FIELD\""), request.getField());
	    }
	    
	    params.add(paramsMap);
	    	    
	    try {
	        
            return this.responseFactory
                    .createEzBldFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier("EVOLUTION",RPCCALL), params));
        }
        catch(Exception ex) {

            LOG.error("ABNORMAL ERROR OCCURRED in DIALOGEzBldEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
	}

}
