package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ConvertEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertResponse;
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
@WebService(serviceName = "XMXUTIL1ConvertService", portName = "XMXUTIL1ConvertServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ConvertEndpoint")
public class XMXUTIL1ConvertEndpointImpl implements XMXUTIL1ConvertEndpoint{ 

	public XMXUTIL1ConvertEndpointImpl() { 
		super();
	}

	public XMXUTIL1ConvertEndpointImpl(XMXUTIL1ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxutil1ResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXUTIL1ConvertEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUTIL1ResponseFactory xmxutil1ResponseFactory;

	public XMXUTIL1ConvertResponse Convert(XMXUTIL1ConvertRequest request) throws VistaWebServiceFault{ 
		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();
		LinkedList<Object> params = getParameters(request);
		if(this.errCount > 0) { 
			return new XMXUTIL1ConvertResponse("-1", errMsgs);
		}else { 
			return xmxutil1ResponseFactory.createConvertResponseFromString(
						getVistaLinkContext().makeRPCCall(new RPCIdentifier(XMXUTIL1Constants.RPC_CONVERT), params));
			
		}

	}


	private LinkedList<Object> getParameters(XMXUTIL1ConvertRequest request) { 
		LinkedList<Object> parameters = new LinkedList<Object>();

		if(request == null) {
			LOGGER.error("REQUEST IS NULL");
			this.errMsgs.add("REQUEST IS NULL");
			errCount++;
		}
		
		if(StrUtils.hasNoValue(request.getInetDate())) {
			String msg = "Error: input date is null";
			LOGGER.error(msg);
			this.errMsgs.add(msg);
			errCount++;
		}else { 
			parameters.add(request.getInetDate());
		}
		
		if(StrUtils.hasAValue(request.getXmTime())) {  
				if( request.getXmTime().equalsIgnoreCase("0") || request.getXmTime().equalsIgnoreCase("1")) { 
					parameters.add(request.getXmTime());
				
				}else { 
					String msg = "Error: param XMTIME must be 0 or 1, current value is: " + request.getXmTime();
					LOGGER.error(msg);
					this.errMsgs.add(msg);
					errCount++;
				}
		}else { 
			LOGGER.error("Param XMTIME is null");
			this.errMsgs.add("Param XMTIME is null");
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
