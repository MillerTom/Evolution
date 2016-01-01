/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFiltrMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgResponse;
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
@WebService(serviceName = "XMXAPIFiltrMsgService", portName = "XMXAPIFiltrMsgPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFiltrMsgEndpoint")
public class XMXAPIFiltrMsgEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPIFiltrMsgEndpoint {

	@Autowired
	private XMXAPIResponseFactory xmxapiResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXAPIFiltrMsgEndpointImpl.class);
	
	public XMXAPIFiltrMsgEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxapiResponseFactory(xmxapiResponseFactory);
	}
	
	public XMXAPIFiltrMsgEndpointImpl(IVistaLinkContext context,
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
	 * gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFiltrMsgEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgRequest)
	 */
	@Override
	public XMXAPIFiltrMsgResponse filtrMsg(XMXAPIFiltrMsgRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxapiResponseFactory.createXMXAPIFiltrMsgResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA EN1"), params));
	}
	
	private ArrayList<Object> getParameterArray(XMXAPIFiltrMsgRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getDuz());
		params.add(request.getXmDuz());
		params.add(request.getXmkzas());
		
		
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
