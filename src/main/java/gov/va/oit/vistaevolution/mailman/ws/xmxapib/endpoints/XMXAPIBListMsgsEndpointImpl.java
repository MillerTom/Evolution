package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBListMsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsResponse;
import gov.va.oit.vistaevolution.util.RpcUtils;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPIBListMsgsService", portName = "XMXAPIBListMsgsServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBListMsgsEndpoint")
public class XMXAPIBListMsgsEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPIBListMsgsEndpoint{ 

	public XMXAPIBListMsgsEndpointImpl() { 
		super();
	}

	public XMXAPIBListMsgsEndpointImpl(XMXAPIBResponseFactory responseFactory, IVistaLinkContext vistaLinkContext2) { 
		super();
		this.xmxapibResponseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext2;
	}
	private static final Logger LOGGER = Logger.getLogger(XMXAPIBListMsgsEndpointImpl.class);
	private int errCount = 0;
	private List<String> errMsgs;
	private final String RPC = "XMWSOA LISTMSGS";
	public static final String MY_SERVICE = "XMXAPIBListMsgs";

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXAPIBResponseFactory xmxapibResponseFactory;

	public XMXAPIBListMsgsResponse ListMsgs(XMXAPIBListMsgsRequest request) throws VistaWebServiceFault{ 
	this.errCount = 0;
	this.errMsgs = new ArrayList<String>();
	LinkedList<Object> params = getParameters(request);
	if(this.errCount > 0) { 
			return new XMXAPIBListMsgsResponse("0", errMsgs);
	}else { 
		return xmxapibResponseFactory.createListMsgsResponseFromString(
			getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPC), params), request);
		}
	}




	private LinkedList<Object> getParameters(XMXAPIBListMsgsRequest request) { 
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
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "DUZ"));
				errCount++;
			}
			
			if(StrUtils.hasAValue(request.getXmDuz())) { 
				parameters.add(request.getXmDuz());
			}else { 
				LOGGER.error(msg.replace(VistaConstants.PARAM, "XMDUZ"));
				this.errMsgs.add(msg.replace(VistaConstants.PARAM, "XMDUZ"));
				errCount++;
			}
			
			if(StrUtils.hasAValue(request.getXmk()) ) {  
				parameters.add(request.getXmk());

			} else { 
				parameters.add("");
			}
			
			if(StrUtils.hasAValue(request.getXmFlds()) ) { 
				parameters.add(request.getXmFlds());
			}else { 
				parameters.add("");
			}
			
			if(StrUtils.hasAValue(request.getXmFlags()) ) {  
				if(StrUtils.equalsOneOfThese(request.getXmFlags(), Arrays.asList("N","B", "C", "P")) ) {
					parameters.add(request.getXmFlags());
				}else { 
					msg = "-1^Invalid value for xmFlags, should be one of the following, N, B, C or P, or a combination of those charaters, example: NB, value was: " + request.getXmFlags();
					LOGGER.error(msg);
					this.errMsgs.add(msg);
					errCount++;
				}
			} else { 
				parameters.add("");
			}
			
			
			if(StrUtils.hasAValue(request.getXmAmt()) ) {  
				parameters.add(request.getXmAmt());

			} else { 
				parameters.add("");
			}
			
			if(request.getXmStart() != null && !request.getXmStart().isEmpty() ) {  
				parameters.add(request.getXmStart());

			} else { 
				parameters.add(new ArrayList<String>());
			}
			if(request.getXmCrit() != null && !request.getXmCrit().isEmpty() ) {  
				parameters.add(RpcUtils.getMapFromVistaKeyArrayEntryList(request.getXmCrit())); 
			} else { 
				parameters.add(new ArrayList<Object>());
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

	public XMXAPIBResponseFactory getXmxapibResponseFactory() {
		return xmxapibResponseFactory;
	}

	public void setXmxapibResponseFactory(
			XMXAPIBResponseFactory xmxapibResponseFactory) {
		this.xmxapibResponseFactory = xmxapibResponseFactory;
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
