/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLAlertDatEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatResponse;
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
@WebService(serviceName = "XQALBUTLAlertDatService", portName = "XQALBUTLAlertDatPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLAlertDatEndpoint")
public class XQALBUTLAlertDatEndpointImpl extends SpringBeanAutowiringSupport implements XQALBUTLAlertDatEndpoint {

	@Autowired
	private XQALBUTLResponseFactory xqalbutlResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XQALBUTLAlertDatEndpointImpl.class);
	
	public XQALBUTLAlertDatEndpointImpl()
	{
		super();
		this.setXqalbutlResponseFactory(xqalbutlResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XQALBUTLAlertDatEndpointImpl(IVistaLinkContext context, XQALBUTLResponseFactory xqalbutlResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xqalbutlResponseFactory = xqalbutlResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLAlertDatEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatRequest)
	 */
	@Override
	public XQALBUTLAlertDatResponse alertDat(XQALBUTLAlertDatRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = getParameterList(request);
		return xqalbutlResponseFactory.createXQALBUTLAlertDatResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA ALERT"), params));
	}
	
	private ArrayList<String> getParameterList(XQALBUTLAlertDatRequest request) {

		ArrayList<String> params = new ArrayList<String>();
		
		if (request.getXuaID() != null) {
			params.add(request.getXuaID());
		}
		
		return params;
	}

	public XQALBUTLResponseFactory getXqoalbutlResponseFactory() {
		return xqalbutlResponseFactory;
	}

	public void setXqalbutlResponseFactory(XQALBUTLResponseFactory xqalbutlResponseFactory) {
		this.xqalbutlResponseFactory = xqalbutlResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
