package gov.va.oit.vistaevolution.mailman.ws.xmxapi;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class XMXAPIResponseFactory extends AbstractResponseFactory {
    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIResponseFactory.class);

    public XMXAPIResponseFactory() {
	super();
    }

    public XMXAPIAddrNSndResponse createAddrNSendResponseFromString(
	    String rawResponse) {

	String method = this.getClass() + ".createAddrNSendResponseFromString";
	LOGGER.info(method
		+ ": Preparing XMXAPIAddrNSndResponse  to be Returned!");

	String[] responseArray = rawResponse.split("\\^");
	XMXAPIAddrNSndResponse response = new XMXAPIAddrNSndResponse();
	if (responseArray.length > 1) {
	    if (!rawResponse.startsWith("-1^")) {
		response.setStatus(responseArray[0]);
		response.setMsgIen(responseArray[1]);
	    } else {
		response.setStatus(responseArray[0]);
		response.setErrors(generateErrorsArray(rawResponse));
	    }
	    return response;
	} else {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    "There an abnormality detected in the response from the source system.");
	    LOGGER.error(fault);
	    throw fault;
	}

    }

    public XMXAPICre8XMZResponse createCre8XMZResponse(String rawResponse) {
	XMXAPICre8XMZResponse response;
	if (!rawResponse.startsWith("-1")) {
	    response = new XMXAPICre8XMZResponse(rawResponse);
	} else {
	    String[] responseArray = rawResponse.split("\\^");
	    response = new XMXAPICre8XMZResponse(responseArray[0],
		    generateErrorsArray(rawResponse));
	}
	return response;
    }

    public XMXAPISendMsgResponse createSendMsgResponse(String rawResponse) {
	XMXAPISendMsgResponse response;
	if (!rawResponse.startsWith("-1")) {
	    response = new XMXAPISendMsgResponse(rawResponse);
	} else {
	    String[] responseArray = rawResponse.split("\\^");
	    response = new XMXAPISendMsgResponse(responseArray[0],
		    generateErrorsArray(rawResponse));
	}
	return response;
    }

    public XMXAPIPrtMsgResponse createPrtMsgResponse(String rawResponse) {
	XMXAPIPrtMsgResponse response;
	String[] responseArray = rawResponse.split("\\^");
	try {
	    if (!rawResponse.startsWith("-1") && responseArray.length >= 2) {
		response = new XMXAPIPrtMsgResponse(responseArray[0],
			responseArray[1]);
	    } else if (!rawResponse.startsWith("-1")
		    && responseArray.length < 2) {
		response = new XMXAPIPrtMsgResponse();
		response.setStatus(responseArray[0]);
		response.setTaskNumber("");
	    } else {

		response = new XMXAPIPrtMsgResponse(responseArray[0],
			generateErrorsArray(rawResponse));
	    }
	} catch (Exception e) {
	    LOGGER.debug(e);
	    throw new VistaWebServiceFault(e);
	}
	return response;
    }

    /**
     * 
     * @param rawResponse
     * @return
     */
    public XMXAPIVSubjResponse createXMXAPIVSubjResponse(String rawResponse) {

	String[] responseArray = rawResponse.split("\\^");
	try {
	    if (!rawResponse.startsWith("-1")) {
		return new XMXAPIVSubjResponse(responseArray[0],
			responseArray[1]);
	    } else {
		return new XMXAPIVSubjResponse(responseArray[0],
			Arrays.asList(responseArray[1]));
	    }
	} catch (Exception e) {
	    LOGGER.debug(e);
	    throw new VistaWebServiceFault(e);
	}
    }

    public XMXAPITermMsgResponse createTermMsgResponse(String rawResponse) {
	XMXAPITermMsgResponse response = new XMXAPITermMsgResponse();
	String[] responseArray = rawResponse.split("\\^");
	try {
	    if (rawResponse.startsWith("0")) {
		response.setStatus(responseArray[0]);
		response.setMessage(responseArray[1]);
	    } else if (rawResponse.startsWith("-1")) {
		response.setStatus(responseArray[0]);
		response.setErrors(Arrays.asList(responseArray[1]));
	    }
	} catch (Exception e) {
	    LOGGER.debug(e);
	    throw new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse, e);
	}
	return response;
    }

    public XMXAPIReplyMsgResponse createReplyMsgResponse(String rawResponse) {
	XMXAPIReplyMsgResponse response = new XMXAPIReplyMsgResponse();
	try {
	    if (!rawResponse.startsWith("-1")) {
		response.setXmz(rawResponse);

	    } else {
		String[] responseArray = rawResponse.split("\\^");
		response.setStatus(responseArray[0]);
		response.setErrors(generateErrorsArray(rawResponse));
	    }
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse, e);
	}
	return response;
    }

    /**
     * creating XMXAPIMovemsgResponse from RPC response
     * 
     * @param rawResponse
     * 
     * @return XMXAPIMovemsgResponse
     * 
     * @throws VistaWebServiceFault
     */
    public XMXAPIMovemsgResponse createXMXAPIMovemsgResponseFromString(
	    String rawResponse) throws VistaWebServiceFault {
	try {
	    XMXAPIMovemsgResponse response;
	    if (LOGGER.isDebugEnabled()) {
		LOGGER.debug("rawResponse=" + rawResponse);
	    }
	    if (rawResponse != null) {
		response = new XMXAPIMovemsgResponse(rawResponse);
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug("response=" + response);
		}
		return response;
	    } else {
		VistaWebServiceFault fault = new VistaWebServiceFault(
			VistaConstants.ERR_MSG_ABNORMAL
				+ " : [ RPC returned NULL rawResponse ]");
		if (LOGGER.isEnabledFor(Level.ERROR)) {
		    LOGGER.error(fault);
		}
		throw fault;
	    }
	} catch (Exception e) {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
			    + " ]");
	    if (LOGGER.isEnabledFor(Level.ERROR)) {
		LOGGER.error(fault);
	    }
	    throw fault;
	}
    }

    /**
     * creating XMXAPIMovemsgsResponse from RPC response
     * 
     * @param rawResponse
     * 
     * @return XMXAPIMovemsgsResponse
     * 
     * @throws VistaWebServiceFault
     */
    public XMXAPIMovemsgsResponse createXMXAPIMovemsgsResponseFromString(
	    String rawResponse) throws VistaWebServiceFault {
	try {
	    XMXAPIMovemsgsResponse response;
	    if (LOGGER.isDebugEnabled()) {
		LOGGER.debug("rawResponse=" + rawResponse);
	    }
	    if (rawResponse != null) {
		response = new XMXAPIMovemsgsResponse(rawResponse);
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug("response=" + response);
		}
		return response;
	    } else {
		VistaWebServiceFault fault = new VistaWebServiceFault(
			VistaConstants.ERR_MSG_ABNORMAL
				+ " : [ RPC returned NULL rawResponse ]");
		if (LOGGER.isEnabledFor(Level.ERROR)) {
		    LOGGER.error(fault);
		}
		throw fault;
	    }
	} catch (Exception e) {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
			    + " ]");
	    if (LOGGER.isEnabledFor(Level.ERROR)) {
		LOGGER.error(fault);
	    }
	    throw fault;
	}
    }

    public XMXAPIVaporMsgResponse createVaporMsgResponse(String rawResponse) {
	XMXAPIVaporMsgResponse response = new XMXAPIVaporMsgResponse();
	String[] responseArray = rawResponse.split("\\^");
	try {
	    if (rawResponse.startsWith("0")) {
		response.setStatus(responseArray[0]);
		response.setMessage(responseArray[1]);
	    } else if (rawResponse.startsWith("-1")) {
		response.setStatus(responseArray[0]);
		response.setErrors(Arrays.asList(responseArray[1]));
	    }
	} catch (Exception e) {
	    LOGGER.debug(e);
	    throw new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse, e);
	}
	return response;
    }

    /**
     * 
     * @param rawResponse
     * @return
     */
    public XMXAPIPutServResponse createXMXAPIPutServResponse(String rawResponse) {
	XMXAPIPutServResponse response = new XMXAPIPutServResponse();
	try {
	    String[] responseArray = rawResponse.split("\\^");

	    response.setStatus(responseArray[0]);

	    if (!rawResponse.startsWith("-1")) {
		response.setResult(responseArray[1]);
	    } else {
		ArrayList<String> errors = new ArrayList<String>();
		for (int i = 1; i < responseArray.length; i++) {
		    errors.add(responseArray[i]);
		}
		response.setErrors(errors);
	    }
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse, e);
	}
	return response;
    }

    /**
     * 
     * @param rawResponse
     * @return
     */
	public XMXAPITaskBullResponse createXMXAPITaskBullResponse(String rawResponse) {
		XMXAPITaskBullResponse response = new XMXAPITaskBullResponse();
		try {
			String[] responseArray = rawResponse.split("\\^");
			if (responseArray.length == 1) {
				response.setResult(rawResponse);
			} else {
				response.setStatus(responseArray[0]);

				if (!rawResponse.startsWith("-1")) {
					response.setResult(responseArray[1]);
				} else {
					ArrayList<String> errors = new ArrayList<String>();
					for (int i = 1; i < responseArray.length; i++) {
						errors.add(responseArray[i]);
					}
					response.setErrors(errors);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault("Response from source system not recognized: " + rawResponse, e);
		}
		return response;
	}

    public XMXAPISendBullResponse createXMXAPISendBullResponse(
	    String rawResponse) {
	XMXAPISendBullResponse response = new XMXAPISendBullResponse();
	try {
	    String[] responseArray = rawResponse.split("\\^");

	    if (rawResponse.startsWith("-1") && responseArray.length >= 2) {
		response.setStatus(responseArray[0]);
		response.setErrors(generateErrorsArray(rawResponse));
	    } else {
		response.setXmz(rawResponse);
	    }

	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse, e);
	}
	return response;
    }

    public XMXAPILateMsgsResponse createLateMsgsResponseFromString(
    		String rawResponse) {

    	String method = this.getClass() + ".createLateMsgsResponseFromString";
    	LOGGER.info(method
    			+ ": Preparing XMXAPILateMsgsResponse  to be Returned!");

    	XMXAPILateMsgsResponse response = new XMXAPILateMsgsResponse();
    	response.setRawResponse(rawResponse);

    	if (StrUtils.hasAValue(rawResponse)) {
    		List<String> rawLines = processLines(rawResponse);
    		if (rawLines.size() != 0) {
    			if(rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) { 
    				response.getErrors().add(rawLines.get(0));
    			}else { 
    				response.setMoveResults(rawLines.get(0));
    			}
    		} else {
    			LOGGER.warn(method + VistaConstants.NO_DATA_FOUND);
    			String msg = VistaConstants.UNEXPECTED_LINE_COUNT.replace(
    					VistaConstants.NR, rawLines.size() + "");
    			msg = msg.replace(VistaConstants.NEXP,
    					VistaConstants.MIN_LINES_EXPECTED);
    			response.getErrors().add(msg);
    			response.getErrors().add("Raw Response: " + rawResponse);
    			msg += "\nRaw Response: " + rawResponse;
    			LOGGER.warn(msg);
    		}
    	} else {
    		LOGGER.warn(method + VistaConstants.NO_DATA_FOUND);
    		LOGGER.warn(VistaConstants.UNEXPECTED_NULL_RETURN);
    		response.getErrors().add(VistaConstants.UNEXPECTED_NULL_RETURN);
    	}
    	System.out.println(response.toString());
    	return response;
    }
    
    
    public XMXAPIFiltrMsgResponse createXMXAPIFiltrMsgResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
			//This method returns a single string
			return new XMXAPIFiltrMsgResponse(rawResponse);
	}

    public XMXAPIFwdMsgResponse createXMXAPIFwdMsgResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
			//This method returns a single string
			return new XMXAPIFwdMsgResponse(rawResponse);
	}

}
