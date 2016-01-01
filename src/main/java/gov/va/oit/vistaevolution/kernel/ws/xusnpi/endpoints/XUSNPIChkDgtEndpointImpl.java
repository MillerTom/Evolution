/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.XUSNPIResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIChkDgtEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtResponse;
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
@WebService(serviceName = "XUSNPIChkDgtService", portName = "XUSNPIChkDgtPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIChkDgtEndpoint")
public class XUSNPIChkDgtEndpointImpl extends SpringBeanAutowiringSupport implements XUSNPIChkDgtEndpoint {

	@Autowired
	private XUSNPIResponseFactory xusnpiResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSNPIChkDgtEndpointImpl.class);
	
	public XUSNPIChkDgtEndpointImpl()
	{
		super();
		this.setXusnpiResponseFactory(xusnpiResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XUSNPIChkDgtEndpointImpl(IVistaLinkContext context, XUSNPIResponseFactory xusnpiResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xusnpiResponseFactory = xusnpiResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIChkDgtEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtRequest)
	 */
	@Override
	public XUSNPIChkDgtResponse chkDgt(XUSNPIChkDgtRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = getParameterList(request);
		return xusnpiResponseFactory.createXUSNPIChkDgtResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA CHKDGT"), params));
	}
	
	private ArrayList<String> getParameterList(XUSNPIChkDgtRequest request) {

		ArrayList<String> params = new ArrayList<String>();
		
		if (request.getXusNpi() != null) {
			params.add(request.getXusNpi());
		}
		
		return params;
	}

	public XUSNPIResponseFactory getXqoalbutlResponseFactory() {
		return xusnpiResponseFactory;
	}

	public void setXusnpiResponseFactory(XUSNPIResponseFactory xusnpiResponseFactory) {
		this.xusnpiResponseFactory = xusnpiResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
