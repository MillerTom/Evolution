package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2DateEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.utils.XMXUtil2Constants;
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
@WebService(serviceName = "XMXUtil2DateService", portName = "XMXUtil2DateServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2DateEndpoint")
public class XMXUtil2DateEndpointImpl implements XMXUtil2DateEndpoint{ 

	public XMXUtil2DateEndpointImpl() { 
		super();
	}

	public XMXUtil2DateEndpointImpl(XMXUtil2ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxutil2ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXUtil2DateEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUtil2ResponseFactory xmxutil2ResponseFactory;

	public XMXUtil2DateResponse Date(XMXUtil2DateRequest request) throws VistaWebServiceFault{ 
		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();
		LinkedList<Object> params = getParameters(request);
		if(this.errCount > 0) { 
			return new XMXUtil2DateResponse("0", errMsgs);
		}else { 
			return xmxutil2ResponseFactory.createDateResponseFromString(
					getVistaLinkContext().makeRPCCall(new RPCIdentifier(XMXUtil2Constants.RPC_DATE2), params));
		}
		
	}




	private LinkedList<Object> getParameters(XMXUtil2DateRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();

		if(request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}
		
		if(StrUtils.hasNoValue(request.getXmzRec())) {
			LOGGER.error(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
			this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
			errCount++;
		}else { 
			parameters.add(request.getXmzRec());
		}
		
		if(StrUtils.hasNoValue(request.getXmTime())) {
			String msg = "Error: input xmTime val was null, setting to 0";
			LOGGER.error(msg);
			parameters.add("0");
		}else { 
			parameters.add(request.getXmTime());
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

}