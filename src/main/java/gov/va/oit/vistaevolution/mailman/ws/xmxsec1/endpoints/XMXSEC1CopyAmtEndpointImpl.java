package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyAmtEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.utils.XMXSEC1Constants;
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
@WebService(serviceName = "XMXSEC1CopyAmtService", portName = "XMXSEC1CopyAmtServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1CopyAmtEndpoint")
public class XMXSEC1CopyAmtEndpointImpl implements XMXSEC1CopyAmtEndpoint{ 
	public final String RPC = "XMWSOA CHECK COPY AMOUNT";
	public XMXSEC1CopyAmtEndpointImpl() { 
		super();
	}
	public XMXSEC1CopyAmtEndpointImpl(
			XMXSEC1ResponseFactory xmxsec1ResponseFactory2,
			IVistaLinkContext vistaLinkContext2) {
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory2;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXSEC1CopyAmtEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC1ResponseFactory xmxsec1ResponseFactory;

	public XMXSEC1CopyAmtResponse CopyAmt(XMXSEC1CopyAmtRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXSEC1CopyAmtResponse("0", errMsgs);
	}else { 
		return xmxsec1ResponseFactory.createCopyAmtResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params));
		}
	}
	
	private LinkedList<Object> getParameters(XMXSEC1CopyAmtRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();

		if(request == null) {
			LOGGER.error(XMXSEC1Constants.ERR_MSG_REQ_IS_NULL);
			this.errMsgs.add(XMXSEC1Constants.ERR_MSG_REQ_IS_NULL);
			errCount++;
		}else { 
			if(StrUtils.hasAValue(request.getXmzMsg())) { 
				parameters.add(request.getXmzMsg());
			}else { 
				LOGGER.error(XMXSEC1Constants.ERR_MSG_START
						+ " XMZ - required. "
						+ XMXSEC1Constants.ERR_MSG_REQD_INPUT.replace(
								XMXSEC1Constants.SRVNM, XMXSEC1Constants.COPYAMT));
			}
			parameters.add(request.getXmWhich());			
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
}
