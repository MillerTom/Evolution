/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqaldata.XQALDATAResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetPatEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatResponse;
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
@WebService(serviceName = "XQALDATAGetPatService", portName = "XQALDATAGetPatPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetPatEndpoint")
public class XQALDATAGetPatEndpointImpl extends SpringBeanAutowiringSupport implements XQALDATAGetPatEndpoint {

	@Autowired
	private XQALDATAResponseFactory xqaldataResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XQALDATAGetPatEndpointImpl.class);
	
	public XQALDATAGetPatEndpointImpl()
	{
		super();
	}
	
	public XQALDATAGetPatEndpointImpl(XQALDATAResponseFactory xqaldataResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xqaldataResponseFactory = xqaldataResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces.XQALDATAGetPatEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatRequest)
	 */
	@Override
	public XQALDATAGetPatResponse getPat(XQALDATAGetPatRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<String> parameterList = getParameterList(request);
		return xqaldataResponseFactory.createXQALDATAGetPatResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA GETPAT"), parameterList));
	}
	
	private ArrayList<String> getParameterList(XQALDATAGetPatRequest request) {

		ArrayList<String> parameterList = new ArrayList<String>();
		
		parameterList.add(request.getIen());
		parameterList.add(request.getStartDate());
		parameterList.add(request.getEndDate());
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
