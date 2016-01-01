package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.XMXSEC2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2EditEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditResponse;
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
@WebService(serviceName = "XMXSEC2EditService", portName = "XMXSEC2EditServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces.XMXSEC2EditEndpoint")
public class XMXSEC2EditEndpointImpl implements XMXSEC2EditEndpoint{ 

	public XMXSEC2EditEndpointImpl() { 
		super();
	}

	public XMXSEC2EditEndpointImpl(XMXSEC2ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxsec2ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXSEC2EditEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;
	private final String RPC = "XMWSOA CHECK USER EDIT MSG";
	private final String MY_SERVICE  = "XMXSEC2^Edit";
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC2ResponseFactory xmxsec2ResponseFactory;

	public XMXSEC2EditResponse Edit(XMXSEC2EditRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXSEC2EditResponse("0", errMsgs);
	}else { 
		return xmxsec2ResponseFactory.createEditResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}
	
	private LinkedList<Object> getParameters(XMXSEC2EditRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();
		String msg = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, MY_SERVICE);
				
		if(request == null) {
			LOGGER.error(VistaConstants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(VistaConstants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}else {  
			if(StrUtils.hasAValue(request.getXmDuz())) { 
				parameters.add(request.getXmDuz());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMDUZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMDUZ"));
				errCount++;
			}
			
			if(StrUtils.hasAValue(request.getXmz())) { 
				parameters.add(request.getXmz());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMZ"));
				errCount++;
			}
			
			if(StrUtils.hasAValue(request.getXmzRec())) { 
				parameters.add(request.getXmzRec());
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

	public XMXSEC2ResponseFactory getXmxsec2ResponseFactory() {
		return xmxsec2ResponseFactory;
	}

	public void setXmxsec2ResponseFactory(
			XMXSEC2ResponseFactory xmxsec2ResponseFactory) {
		this.xmxsec2ResponseFactory = xmxsec2ResponseFactory;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}

