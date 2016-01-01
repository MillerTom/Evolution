/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MmdtEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Leisa Martella
 * 
 */

/*
 * XMWSOA FM2MM DT
 * 
 * This RPC takes a VA FileMan Date/Time input string and returns it as a
 * reformatted string:
 *     mm/dd/yy@hh:mm
 *     
 * If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDT		(Required) VA FileMan Date/Time input string.
 * 
 * Response:
 * 		Returns a reformatted VA FileMan Date/Time string:
 * 			mm/dd/yy@hh:mm
 * 		Example
 * 			XMDT=2940629.105744
 * 			Return:  06/29/94@10:57
 * 
 */

@Component
@WebService(serviceName = "XMXUTIL1MmdtService", portName = "XMXUTIL1MmdtPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MmdtEndpoint")
public class XMXUTIL1MmdtEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTIL1MmdtEndpoint {

	@Autowired
	private XMXUTIL1ResponseFactory xmxutil1ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL1MmdtEndpointImpl.class);
	
	public XMXUTIL1MmdtEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxutil1ResponseFactory(xmxutil1ResponseFactory);
	}
	
	public XMXUTIL1MmdtEndpointImpl(IVistaLinkContext context,
			XMXUTIL1ResponseFactory xmxutil1ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmutil1.endpoints.interfaces.XMXUTIL1MmdtEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmutil1.model.XMXUTIL1MmdtRequest)
	 */
	@Override
	public XMXUTIL1MmdtResponse mmdt(XMXUTIL1MmdtRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxutil1ResponseFactory.createXMXUTIL1MmdtResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA FM2MM DT"), params));
	}             
	
	private ArrayList<Object> getParameterArray(XMXUTIL1MmdtRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getXmDt());
		
		return params;
	}

	public XMXUTIL1ResponseFactory getXmxutil1ResponseFactory() {
		return xmxutil1ResponseFactory;
	}
	
	public void setXmxutil1ResponseFactory(XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
