/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class XMXAPIBResponseFactory extends AbstractResponseFactory {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBResponseFactory.class);

    /**
     * No Arguments Constructor.
     */
    public XMXAPIBResponseFactory() {
	super();
    }

    /**
     * creating XMXAPIBNamebsktResponse from RPC response
     * 
     * @param rawResponse
     * 
     * @return XMXAPIBNamebsktResponse
     * 
     * @throws VistaWebServiceFault
     */
    public XMXAPIBNamebsktResponse createNamebsktResponseFromString(
	    String rawResponse) {
	try {
	    XMXAPIBNamebsktResponse response;
	    String method = this.getClass()
		    + ".createNamebsktResponseFromString";
	    LOGGER.info(method
		    + ": Preparing XMXAPIBNamebsktResponse to be Returned, RPC RETURNS : "
		    + rawResponse);
	    if (rawResponse != null) {
		if (rawResponse.startsWith("ERROR,")) {
		    LOGGER.warn(VistaConstants.ERR_MSG_INPUT);
		    String[] errorMessages = rawResponse.split("\\^");
		    ArrayList<String> lines = new ArrayList<String>();
		    for (String entry : errorMessages) {
			lines.add(entry);
		    }
		    response = new XMXAPIBNamebsktResponse(null, lines);
		} else {
		    LOGGER.info(VistaConstants.DATA_FOUND);
		    String[] data = rawResponse.split("\n");
		    ArrayList<String> lines = new ArrayList<String>();
		    for (String entry : data) {
			lines.add(entry);
		    }
		    response = new XMXAPIBNamebsktResponse(lines, null);
		}
	    } else {
		VistaWebServiceFault fault = new VistaWebServiceFault(
			VistaConstants.ERR_MSG_ABNORMAL);
		LOGGER.error(fault);
		throw fault;
	    }
	    return response;
	} catch (Exception e) {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    VistaConstants.ERR_MSG_ABNORMAL);
	    LOGGER.error(fault);
	    throw fault;
	}
    }

    public XMXAPIBCre8BsktResponse createCre8BsktResponse(String rawResponse) {
	XMXAPIBCre8BsktResponse response = null;
	String[] responseArray = rawResponse.split("\\^");
	if (rawResponse.startsWith("0") && responseArray.length == 2) {
	    response = new XMXAPIBCre8BsktResponse(responseArray[0],
		    responseArray[1]);
	} else if (rawResponse.startsWith("-1") && responseArray.length >= 2) {
	    response = new XMXAPIBCre8BsktResponse(responseArray[0],
		    generateErrorsArray(rawResponse));
	} else {
	    throwErrorForUnrecognizedResponse(rawResponse);
	}
	return response;
    }

    public XMXAPIBCre8MBoxResponse createCre8MBoxResponse(String rawResponse) {
	XMXAPIBCre8MBoxResponse response = null;
	String[] responseArray = rawResponse.split("\\^");
	if (rawResponse.startsWith("0") && responseArray.length == 2) {
	    response = new XMXAPIBCre8MBoxResponse(responseArray[0],
		    responseArray[1]);
	} else if (rawResponse.startsWith("-1") && responseArray.length >= 2) {
	    response = new XMXAPIBCre8MBoxResponse(responseArray[0],
		    generateErrorsArray(rawResponse));
	} else {
	    throwErrorForUnrecognizedResponse(rawResponse);
	}
	return response;
    }

    public XMXAPIBQBsktResponse createQBsktResponse(String rawResponse) {
	XMXAPIBQBsktResponse response = new XMXAPIBQBsktResponse();
	String[] responseArray = rawResponse.split("\\^");
	if (!rawResponse.startsWith("-1") && responseArray.length >= 4) {
	    response.setIen(responseArray[0]);
	    response.setName(responseArray[1]);
	    response.setNumOfMsgs(responseArray[2]);
	    response.setNumOfNewMsgs(responseArray[3]);
	} else if (rawResponse.startsWith("-1")) {
	    response.setStatus(responseArray[0]);
	    response.setErrors(generateErrorsArray(rawResponse));
	} else {
	    throwErrorForUnrecognizedResponse(rawResponse);
	}
	return response;
    }

    public XMXAPIBQMBoxResponse createQMBoxResponse(String rawResponse) {
	XMXAPIBQMBoxResponse response = new XMXAPIBQMBoxResponse();
	String[] responseArray = rawResponse.split("\\^");
	if (!rawResponse.startsWith("-1") && responseArray.length >= 7) {
	    response.setNumOfNewMsgs(responseArray[0]);
	    response.setNewPriorityMail(responseArray[1]);
	    response.setNumOfNewMsgsForINBskt(responseArray[2]);
	    response.setDateLastMsgRecieved(responseArray[3]);
	    response.setNewMessagesSinceLastChecked(responseArray[4]);
	    response.setBasketIen(responseArray[6]);
	    response.setBasketName(responseArray[7]);
	} else if (rawResponse.startsWith("-1")) {
	    response.setStatus(responseArray[0]);
	    response.setErrors(generateErrorsArray(rawResponse));
	} else {
	    throwErrorForUnrecognizedResponse(rawResponse);
	}
	return response;
    }

    /**
     * Builds, logs, and throws and error for an unrecognized response.
     * 
     * @param rawResponse
     */
    public void throwErrorForUnrecognizedResponse(String rawResponse) {
	VistaWebServiceFault fault = new VistaWebServiceFault(
		"Response format from source system not recognized: "
			+ rawResponse);
	LOGGER.error(fault);
	throw fault;
    }
    
    public XMXAPIBListBsktResponse createListBsktResponseFromString(String rawResponse) {
		String method = this.getClass() + ".createListBsktResponseFromString: ";
		LOGGER.info(method + "Preparing XMXAPIBListBsktResponse to be Returned!");	
		XMXAPIBListBsktResponse response = new XMXAPIBListBsktResponse();
		response.setRawResponse(rawResponse);
			
			if (StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processLines(rawResponse);

				if (rawLines.size() != 0) {
					if(rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) { 
						response.getErrors().add(rawLines.get(0));
					}else { 
						response.setBasketList(listBsktResponseHelper(rawLines, response));
					}
				} else {
					LOGGER.warn(method + VistaConstants.NO_DATA_FOUND);
					String msg = VistaConstants.UNEXPECTED_LINE_COUNT.replace(VistaConstants.NR, rawLines.size() + "");
					msg = msg.replace(VistaConstants.NEXP, VistaConstants.MIN_LINES_EXPECTED);
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
	
	
	private List<XMXAPIBListBsktEntry> listBsktResponseHelper(List<String> listToProcess, XMXAPIBListBsktResponse response) { 
		String method = this.getClass() + ".listBsktResponseHelper: ";
		final int basketIen =  0;
		final int basketName =  1;
		final int numMsgs =  2;
		final int numNewMsgs =  3;
		
		ArrayList<XMXAPIBListBsktEntry> responseLst = new ArrayList<XMXAPIBListBsktEntry>();
		for(int i = 0; i < listToProcess.size(); i++) { 
			// start at 1, because that is what the SDD says
			String lstEntry  = listToProcess.get(i);
			
			XMXAPIBListBsktEntry entry = new XMXAPIBListBsktEntry();
			String[] arr = lstEntry.split("\\^");
			try { 
				if(arr.length == 4) { 
					// we are good.. 
					entry.setBasketIen(arr[basketIen]);
					entry.setBasketName(arr[basketName]);
					entry.setNumMessagesInBasket(arr[numMsgs]);
					entry.setNumNewMessagesInBasket(arr[numNewMsgs]);
					responseLst.add(entry);
				}else { 
					String error = method + "Error at return list index " + i + ", expected 4 items, entry has " + arr.length + " items. Returned entry is: " + lstEntry;  
					response.getErrors().add(error);
				}
			}catch(IndexOutOfBoundsException oob) { 
				System.out.println(oob.getMessage());
			}
			
		}
		return responseLst;
		
		
	}

    public XMXAPIBRseqbsktResponse createRseqbsktFromString(String rawResponse) {
    	String method = this.getClass() + ".createRseqbsktFromString";
    	LOGGER.info(method + ": Preparing XMXAPIBRseqbsktResponse to be Returned!");
    	LOGGER.debug("Returned Data : " + rawResponse);
    	try {
    		List<String> rawLines = processLines(rawResponse);
    		String response = rawLines.get(0);
    		return new XMXAPIBRseqbsktResponse(response);
    	} catch (Exception ex) {
    		LOGGER.error("ABNORMAL RESPONSE FOR RESEQUENCE BASKET: " + ex);
    		return new XMXAPIBRseqbsktResponse("-1");
    	}
    }
    
	public XMXAPIBListMsgsResponse createListMsgsResponseFromString(String rawResponse, XMXAPIBListMsgsRequest request) {
		
		String method = this.getClass() + ".createListMsgsResponseFromString: ";
		LOGGER.info(method + "Preparing XMXAPIBListMsgsResponse to be Returned!");	
		XMXAPIBListMsgsResponse response = new XMXAPIBListMsgsResponse();
		response.setRawResponse(rawResponse);
		System.out.println(rawResponse);
		return response;
	}

}
