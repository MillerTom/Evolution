/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma03.XMA03ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;
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
@Component
@WebService(serviceName = "XMA03RenService", portName = "XMA03RenPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint")
public class XMA03RenEndpointImpl extends SpringBeanAutowiringSupport implements XMA03RenEndpoint {

	@Autowired
	private XMA03ResponseFactory xma03ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMA03RenEndpointImpl.class);
	
	public XMA03RenEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXma03ResponseFactory(xma03ResponseFactory);
	}
	
	public XMA03RenEndpointImpl(IVistaLinkContext context, XMA03ResponseFactory xma03ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xma03ResponseFactory = xma03ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest)
	 */
	@Override
	public XMA03RenResponse ren(XMA03RenRequest request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = getParameterArray(request);
		return xma03ResponseFactory.createXMA03RenResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA REN"), params));
	}
	
	private ArrayList<String> getParameterArray(XMA03RenRequest request) {
		ArrayList<String> renParams = new ArrayList <String>();

		renParams.add(request.getXmDuz());
		renParams.add(request.getXmk());
		
		return renParams;
	}

	public XMA03ResponseFactory getXma03ResponseFactory() {
		return xma03ResponseFactory;
	}

	public void setXma03ResponseFactory(XMA03ResponseFactory xma03ResponseFactory) {
		this.xma03ResponseFactory = xma03ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public String toString() {
		return "XMA03RenEndpointImpl [toString()=" + super.toString() + "]";
	}
	
	
}
