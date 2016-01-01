package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECBcastEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastResponse;
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
@WebService(serviceName = "XMXSECBcastService", portName = "XMXSECBcastServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECBcastEndpoint")
public class XMXSECBcastEndpointImpl implements XMXSECBcastEndpoint{ 

	public XMXSECBcastEndpointImpl() { 
		super();
	}
	public XMXSECBcastEndpointImpl(
			XMXSECResponseFactory xmxsecResponseFactory2,
			IVistaLinkContext vistaLinkContext2) {
		super();
		this.xmxsecResponseFactory = xmxsecResponseFactory2;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXSECBcastEndpointImpl.class);
	private final String RPC = "XMWSOA MSG WAS BCAST";
	private int errCount = 0;
	private List<String> errMsgs;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSECResponseFactory xmxsecResponseFactory;

	public XMXSECBcastResponse Bcast(XMXSECBcastRequest request) throws VistaWebServiceFault{ 
		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();
		LinkedList<Object> params = getParameters(request);
		if(this.errCount > 0) { 
				return new XMXSECBcastResponse("0", errMsgs);
		}else { 
			return xmxsecResponseFactory.createBcastResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
			}
		}

	
	private LinkedList<Object> getParameters(XMXSECBcastRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();

		if(request == null) {
			LOGGER.error("REQUEST IS NULL" );
			this.errMsgs.add("REQUEST IS NULL");
			errCount++;
		}

		if(StrUtils.hasNoValue(request.getMsgId())) {
			LOGGER.error(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
			this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
			errCount++;
		}else { 
			parameters.add(request.getMsgId());
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

	public XMXSECResponseFactory getXmxsecResponseFactory() {
		return xmxsecResponseFactory;
	}

	public void setXmxsecResponseFactory(XMXSECResponseFactory xmxsecResponseFactory) {
		this.xmxsecResponseFactory = xmxsecResponseFactory;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}