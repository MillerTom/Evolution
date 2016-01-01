package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPILateMsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsResponse;
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
@WebService(serviceName = "XMXAPILateMsgsService", portName = "XMXAPILateMsgsServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPILateMsgsEndpoint")
public class XMXAPILateMsgsEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPILateMsgsEndpoint{ 

	public XMXAPILateMsgsEndpointImpl() { 
		super();
	}

	public XMXAPILateMsgsEndpointImpl(XMXAPIResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxapiResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXAPILateMsgsEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;
	private final String RPC = "XMWSOA LATEMSGS";
	public static final String MY_SERVICE = "XMXAPILateMsgs";

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXAPIResponseFactory xmxapiResponseFactory;

	public XMXAPILateMsgsResponse LateMsgs(XMXAPILateMsgsRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXAPILateMsgsResponse("0", errMsgs);
	}else { 
		return xmxapiResponseFactory.createLateMsgsResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}




	private LinkedList<Object> getParameters(XMXAPILateMsgsRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();
		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, MY_SERVICE);


		if(request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}else {
			if(StrUtils.hasAValue(request.getDuz())) { 
				parameters.add(request.getDuz());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "DUZ"));
				this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
				errCount++;
			}
			
			if(StrUtils.hasAValue(request.getXmDuz())) { 
				parameters.add(request.getXmDuz());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMDUZ"));
				this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
				errCount++;
			}
			
			if(StrUtils.hasAValue(request.getXmk())) { 
				parameters.add(request.getXmk());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMK"));
				this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
				errCount++;
			}
			
			if(request.getXmkza() != null && !request.getXmkza().isEmpty() ) { 
				parameters.add(request.getXmkza());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMKZA"));
				this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
				errCount++;
			}
			
			if(request.getXmInstr() != null && !request.getXmInstr().isEmpty() ) { 
				parameters.add(request.getXmInstr().get(0));
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMINSTR"));
				this.errMsgs.add(VistaConstants.ERR_MSG_IN_REQD_INPUT2);
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

	public XMXAPIResponseFactory getXmxapiResponseFactory() {
		return xmxapiResponseFactory;
	}

	public void setXmxapiResponseFactory(XMXAPIResponseFactory xmxapiResponseFactory) {
		this.xmxapiResponseFactory = xmxapiResponseFactory;
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
