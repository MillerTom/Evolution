/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqaldata.XQALDATAResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetUser1Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Request;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Response;
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
@WebService(serviceName = "XQALDATAGetUser1Service", portName = "XQALDATAGetUser1Port", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetUser1Endpoint")
public class XQALDATAGetUser1EndpointImpl extends SpringBeanAutowiringSupport implements XQALDATAGetUser1Endpoint {

	@Autowired
	private XQALDATAResponseFactory xqaldataResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XQALDATAGetUser1EndpointImpl.class);
	
	public XQALDATAGetUser1EndpointImpl()
	{
		super();
	}
	
	public XQALDATAGetUser1EndpointImpl(XQALDATAResponseFactory xqaldataResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xqaldataResponseFactory = xqaldataResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetUser1Endpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Request)
	 */
	@Override
	public XQALDATAGetUser1Response getUser1(XQALDATAGetUser1Request request)
			throws VistaWebServiceFault {
		
		ArrayList<String> parameterList = getParameterList(request);
		return xqaldataResponseFactory.createXQALDATAGetUser1ResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA GETUSER"), parameterList));
	}
	
	private ArrayList<String> getParameterList(XQALDATAGetUser1Request request) {

		ArrayList<String> parameterList = new ArrayList<String>();
		
		parameterList.add(request.getIen());
		return parameterList;
	}

	public XQALDATAResponseFactory getXqaldataResponseFactory() {
		return xqaldataResponseFactory;
	}

	public void setXqaldataResponseFactory(XQALDATAResponseFactory xqaldataResponseFactory) {
		this.xqaldataResponseFactory = xqaldataResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
