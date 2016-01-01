package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MeldEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldResponse;
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
 * XMWSOA MELD STRING
 * This RPC combines a string and a number to form a new string of a given
 * length. The string will be right justified; the number left-justified,
 * with at least two spaces separating the string and number. The string will
 * be truncated, if necessary.  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 		XMSTRING	(Required) The input string.
 * 		XMNUMBER	(Optional) The number.
 * 		XMLEN		(Required) The length of the new string to be formed.
 * 
 * Response:
 * 		Returns the newly formed string.
 * 
 * 			Example 1
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=10
 * 				Lotus 123
 * 			
 * 			Example 2
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=15
 * 				Lotus blos 123
 * 
 */

@Component
@WebService(serviceName = "XMXUTIL1MeldService", portName = "XMXUTIL1MeldPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MeldEndpoint")
public class XMXUTIL1MeldEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTIL1MeldEndpoint {

	@Autowired
	private XMXUTIL1ResponseFactory xmxutil1ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL1MeldEndpointImpl.class);
	
	public XMXUTIL1MeldEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxutil1ResponseFactory(xmxutil1ResponseFactory);
	}
	
	public XMXUTIL1MeldEndpointImpl(IVistaLinkContext context,
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
	 * gov.va.oit.vistaevolution.mailman.ws.xmutil1.endpoints.interfaces.XMXUTIL1MeldEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmutil1.model.XMXUTIL1MeldRequest)
	 */
	@Override
	public XMXUTIL1MeldResponse meld(XMXUTIL1MeldRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxutil1ResponseFactory.createXMXUTIL1MeldResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA MELD STRING"), params));
	}             
	
	private ArrayList<Object> getParameterArray(XMXUTIL1MeldRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getXmString());
		params.add(request.getXmNumber());
		params.add(request.getXmLen());
		
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
