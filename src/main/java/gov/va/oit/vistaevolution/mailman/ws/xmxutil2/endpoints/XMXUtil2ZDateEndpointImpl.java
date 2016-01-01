package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZDateEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.util.StrUtils;
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

@Component
@WebService(serviceName = "XMXUtil2ZDateService", portName = "XMXUtil2ZDateServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZDateEndpoint")
public class XMXUtil2ZDateEndpointImpl implements XMXUtil2ZDateEndpoint{ 

	public XMXUtil2ZDateEndpointImpl() { 
		super();
	}

	public XMXUtil2ZDateEndpointImpl(XMXUtil2ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxutil2ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXUtil2ZDateEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;
	private final String RPC = "XMWSOA MSG SEND DATE";
	public final static String MY_SERVICE = "XMXUtil2ZDate";

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUtil2ResponseFactory xmxutil2ResponseFactory;

	public XMXUtil2DateResponse ZDate(XMXUtil2DateRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXUtil2DateResponse("0", errMsgs);
	}else { 
		return xmxutil2ResponseFactory.createZDateResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}




	private LinkedList<Object> getParameters(XMXUtil2DateRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();
		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, MY_SERVICE);


		if(request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}else {
			if(StrUtils.hasAValue(request.getXmzRec())) { 
				parameters.add(request.getXmzRec());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMZ"));
				errCount++;
			}
			if(StrUtils.hasAValue(request.getXmTime())) { 
				parameters.add(request.getXmTime());
			}else { 
				parameters.add("");
			}
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

	public XMXUtil2ResponseFactory getXmxutil2ResponseFactory() {
		return xmxutil2ResponseFactory;
	}

	public void setXmxutil2ResponseFactory(
			XMXUtil2ResponseFactory xmxutil2ResponseFactory) {
		this.xmxutil2ResponseFactory = xmxutil2ResponseFactory;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public String getRPC() {
		return RPC;
	}

	public String getMY_SERVICE() {
		return MY_SERVICE;
	}

	public static String getMyService() {
		return MY_SERVICE;
	}

}
