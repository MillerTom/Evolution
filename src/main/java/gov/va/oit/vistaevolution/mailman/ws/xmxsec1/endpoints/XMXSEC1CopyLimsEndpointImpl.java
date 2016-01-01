package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyLimsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(serviceName = "XMXSEC1CopyLimsService", portName = "XMXSEC1CopyLimsServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyLimsEndpoint")
public class XMXSEC1CopyLimsEndpointImpl implements XMXSEC1CopyLimsEndpoint{ 

	public XMXSEC1CopyLimsEndpointImpl() { 
		super();
	}
	public XMXSEC1CopyLimsEndpointImpl(
			XMXSEC1ResponseFactory xmxsec1ResponseFactory2,
			IVistaLinkContext vistaLinkContext2) {
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory2;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXSEC1CopyLimsEndpointImpl.class);
	private final String RPC = "XMWSOA GET COPY LIMITS";
	private int errCount = 0;
	private List<String> errMsgs;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC1ResponseFactory xmxsec1ResponseFactory;

	public XMXSEC1CopyLimsResponse CopyLims(XMXSEC1CopyLimsRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXSEC1CopyLimsResponse("0", errMsgs);
	}else { 
		return xmxsec1ResponseFactory.createCopyLimsResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}

	private LinkedList<Object> getParameters(XMXSEC1CopyLimsRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();

		if(request == null) {
			LOGGER.error("REQUEST IS NULL");
			this.errMsgs.add("REQUEST IS NULL");
			errCount++;
		}

		return parameters;
	}

	
	// getter and setters
	public int getErrCount() {
		return errCount;
	}

	public void setErrCount(int errCount) {
		this.errCount = errCount;
	}

	public List<String> getErrMsgs() {
		return errMsgs;
	}

	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMXSEC1ResponseFactory getXmxsec1ResponseFactory() {
		return xmxsec1ResponseFactory;
	}

	public void setXmxsec1ResponseFactory(
			XMXSEC1ResponseFactory xmxsec1ResponseFactory) {
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory;
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
