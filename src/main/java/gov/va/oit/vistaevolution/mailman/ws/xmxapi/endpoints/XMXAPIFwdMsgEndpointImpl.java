/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFwdMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgResponse;
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
@WebService(serviceName = "XMXAPIFwdMsgService", portName = "XMXAPIFwdMsgPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFwdMsgEndpoint")
public class XMXAPIFwdMsgEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPIFwdMsgEndpoint {

	@Autowired
	private XMXAPIResponseFactory xmxapiResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXAPIFwdMsgEndpointImpl.class);
	
	public XMXAPIFwdMsgEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxapiResponseFactory(xmxapiResponseFactory);
	}
	
	public XMXAPIFwdMsgEndpointImpl(IVistaLinkContext context,
			XMXAPIResponseFactory xmxapiResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmxapiResponseFactory = xmxapiResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFwdMsgEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgRequest)
	 */
	@Override
	public XMXAPIFwdMsgResponse fwdMsg(XMXAPIFwdMsgRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxapiResponseFactory.createXMXAPIFwdMsgResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA FWDMSGM"), params));
	}
	
	private ArrayList<Object> getParameterArray(XMXAPIFwdMsgRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getDuz());
		params.add(request.getXmDuz());
		params.add(request.getXmkzas());
		params.add(request.getXmtos());
		params.add(request.getXminstrs());
		
		return params;
	}

	public XMXAPIResponseFactory getXmxapiResponseFactory() {
		return xmxapiResponseFactory;
	}
	
	public void setXmxapiResponseFactory(XMXAPIResponseFactory xmxapiResponseFactory) {
		this.xmxapiResponseFactory = xmxapiResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
