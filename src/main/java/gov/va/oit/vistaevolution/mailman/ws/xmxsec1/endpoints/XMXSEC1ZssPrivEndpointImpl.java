package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1ZssPrivEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXSEC1ZssPrivService", portName = "XMXSEC1ZssPrivServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1ZssPrivEndpoint")
public class XMXSEC1ZssPrivEndpointImpl extends SpringBeanAutowiringSupport implements XMXSEC1ZssPrivEndpoint{ 

	public XMXSEC1ZssPrivEndpointImpl() { 
		super();
	}

	public XMXSEC1ZssPrivEndpointImpl(XMXSEC1ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxsec1ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXSEC1ZssPrivEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;
	private final String RPC = "REPLACE ME";
	public static final String MY_SERVICE = "XMXSEC1ZssPriv";

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC1ResponseFactory xmxsec1ResponseFactory;

	public XMXSEC1ZssPrivResponse ZssPriv(XMXSEC1ZssPrivRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXSEC1ZssPrivResponse("0", errMsgs);
	}else { 
		return xmxsec1ResponseFactory.createZssPrivResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}




	private LinkedList<Object> getParameters(XMXSEC1ZssPrivRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();
//		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, MY_SERVICE);


		if(request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}else {
//			if(StrUtils.hasAValue(request.get)) { 
//				parameters.add(request.get);
//			}else { 
//				LOGGER.error(msg.replace(VistaConstants.PARAM, ""));
//				this.errMsgs.add(msg.replace(VistaConstants.PARAM, ""));
//				errCount++;
//			}
		}
		return parameters;
	}

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

	public String getRPC() {
		return RPC;
	}

	public static String getMyService() {
		return MY_SERVICE;
	}

}
