/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuser.XUSERResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces.XUSERDiv4Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Response;
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
@WebService(serviceName = "XUSERDiv4Service", portName = "XUSERDiv4Port", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces.XUSERDiv4Endpoint")
public class XUSERDiv4EndpointImpl extends SpringBeanAutowiringSupport implements XUSERDiv4Endpoint {

	@Autowired
	private XUSERResponseFactory xuserResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSERDiv4EndpointImpl.class);
	
	public XUSERDiv4EndpointImpl()
	{
		super();
	}
	
	public XUSERDiv4EndpointImpl(IVistaLinkContext context, XUSERResponseFactory xuserResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xuserResponseFactory = xuserResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces.XUSERDiv4Endpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Request)
	 */
	@Override
	public XUSERDiv4Response div4(XUSERDiv4Request request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = getParameterList(request);
		return xuserResponseFactory.createXUSERDiv4ResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA DIV4"), params));
	}
	
	private ArrayList<String> getParameterList(XUSERDiv4Request request) {

		ArrayList<String> params = new ArrayList<String>();
		
		if (request.getField() != null) {
			params.add(request.getField());
		}
		
		if (request.getIens() != null) {
			params.add(request.getField());
		}
		return params;
	}

	public XUSERResponseFactory getXuserResponseFactory() {
		return xuserResponseFactory;
	}

	public void setXuserResponseFactory(XUSERResponseFactory xuserResponseFactory) {
		this.xuserResponseFactory = xuserResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
