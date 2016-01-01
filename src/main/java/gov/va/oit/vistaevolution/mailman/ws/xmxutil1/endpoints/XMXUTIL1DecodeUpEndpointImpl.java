package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1DecodeUpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.utils.XMXUTIL1Constants;
import gov.va.oit.vistaevolution.util.StrUtils;
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
@WebService(serviceName = "XMXUTIL1DecodeUpService", portName = "XMXUTIL1DecodeUpServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1DecodeUpEndpoint")
public class XMXUTIL1DecodeUpEndpointImpl implements XMXUTIL1DecodeUpEndpoint{ 

	public XMXUTIL1DecodeUpEndpointImpl() { 
		super();
	}

	public XMXUTIL1DecodeUpEndpointImpl(XMXUTIL1ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxutil1ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXUTIL1DecodeUpEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUTIL1ResponseFactory xmxutil1ResponseFactory;

	public XMXUTIL1DecodeUpResponse DecodeUp(XMXUTIL1DecodeUpRequest request) throws VistaWebServiceFault{ 
		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();
		LinkedList<Object> params = getParameters(request);
		if(this.errCount > 0) { 
			return new XMXUTIL1DecodeUpResponse("0", errMsgs);
		}else { 
			return xmxutil1ResponseFactory.createDecodeUpResponseFromString(
					getVistaLinkContext().makeRPCCall(new RPCIdentifier(XMXUTIL1Constants.RPC_DECODEUP), params));
		}
	}

	private LinkedList<Object> getParameters(XMXUTIL1DecodeUpRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();

		if(request == null) {
			LOGGER.error("REQUEST IS NULL");
			this.errMsgs.add("REQUEST IS NULL");
			errCount++;
		}
		if(StrUtils.hasAValue(request.getInput())) { 
			parameters.add(request.getInput());
		}else { 
			LOGGER.error("REQUEST INPUT IS NULL");
			this.errMsgs.add("REQUEST INPUT IS NULL");
			errCount++;
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

	public XMXUTIL1ResponseFactory getXmxutil1ResponseFactory() {
		return xmxutil1ResponseFactory;
	}

	public void setXmxutil1ResponseFactory(
			XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
