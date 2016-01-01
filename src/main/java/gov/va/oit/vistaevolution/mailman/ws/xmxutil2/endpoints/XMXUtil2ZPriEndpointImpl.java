package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZPriEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriResponse;
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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXUtil2ZPriService", portName = "XMXUtil2ZPriServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZPriEndpoint")
public class XMXUtil2ZPriEndpointImpl extends SpringBeanAutowiringSupport 
		implements XMXUtil2ZPriEndpoint{ 

	public XMXUtil2ZPriEndpointImpl() { 
		super();
	}

	public XMXUtil2ZPriEndpointImpl(XMXUtil2ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxutil2ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXUtil2ZPriEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;
	private final String RPC = "XMWSOA GET MSG PRIORITY";
	private final String MY_SERVICE = "XMXUtil2ZPri";

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUtil2ResponseFactory xmxutil2ResponseFactory;

	public XMXUtil2ZPriResponse ZPri(XMXUtil2ZPriRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXUtil2ZPriResponse("0", errMsgs);
	}else { 
		return xmxutil2ResponseFactory.createZPriResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}




	private LinkedList<Object> getParameters(XMXUtil2ZPriRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();
		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, MY_SERVICE);


		if(request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}else {
			if(StrUtils.hasAValue(request.getXmz())) { 
				parameters.add(request.getXmz());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMZ"));
				errCount++;
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

}
