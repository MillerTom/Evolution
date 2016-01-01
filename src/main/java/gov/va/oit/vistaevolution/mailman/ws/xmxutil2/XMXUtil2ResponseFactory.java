/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Response;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Response;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZReadResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
public class XMXUtil2ResponseFactory extends AbstractResponseFactory {
    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2ResponseFactory.class);

    public XMXUtil2DateResponse createDateResponseFromString(String rawResponse) {

	String method = this.getClass() + ".createDateResponseFromString: ";
	LOGGER.info(method + "Preparing XMXUtil2DateResponse to be Returned!");
	XMXUtil2DateResponse response = new XMXUtil2DateResponse();

	if (StrUtils.hasAValue(rawResponse)) {
	    List<String> rawLines = processLines(rawResponse);

	    if (rawLines.size() != 0) {
		if (rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) {
		    response.getErrors().add(rawLines.get(0));
		} else {
		    response.setMsgDate(rawLines.get(0));
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

    public XMXUTIL2BsktResponse createBsktFromString(String rawResponse) {
	String method = this.getClass() + ".createBsktnameFromString";
	LOGGER.info(method + ": Preparing XMXUTIL2BsktResponse to be Returned!");
	LOGGER.debug("Returned Data : " + rawResponse);
	try {
	    List<String> rawLines = processLines(rawResponse);
	    String response = rawLines.get(0);
	    /*
	     * if (!response.contains("^")) { return new
	     * XMXUTIL2BsktResponse(response); } else { LOG.debug("response: " +
	     * response); List<String> bsktList =
	     * StrUtils.stringtoList(response, "\\^");
	     * LOG.debug("size of basket list: " + bsktList.size()); return new
	     * XMXUTIL2BsktResponse(bsktList.get(0), bsktList.get(1)); }
	     */
	    return new XMXUTIL2BsktResponse(response);
	} catch (Exception ex) {
	    LOGGER.error("ABNORMAL RESPONSE FOR BASKET QUERY: " + ex);
	    return new XMXUTIL2BsktResponse("0");
	}
    }

    public XMXUTIL2QrespResponse createQrespFromString(String rawResponse) {
	String method = this.getClass() + ".createQrespFromString";
	LOGGER.info(method
		+ ": Preparing XMXUTIL2QrespResponse to be Returned!");
	LOGGER.debug("Returned Data : " + rawResponse);
	try {
	    List<String> rawLines = processLines(rawResponse);
	    String response = rawLines.get(0);
	    return new XMXUTIL2QrespResponse(response);
	} catch (Exception ex) {
	    LOGGER.error("ABNORMAL RESPONSE FOR BASKET QUERY: " + ex);
	    return new XMXUTIL2QrespResponse("0");
	}
    }

    public XMXUTIL2SubjResponse createSubjFromString(String rawResponse) {
	String method = this.getClass() + ".createSubjFromString";
	LOGGER.info(method + ": Preparing XMXUTIL2SubjResponse to be Returned!");
	LOGGER.debug("Returned Data : " + rawResponse);
	List<String> rawLines = processLines(rawResponse);
	String response = rawLines.get(0);
	return new XMXUTIL2SubjResponse(response);
    }

    public XMXUTIL2InrespResponse createInrespFromString(String rawResponse) {
	String method = this.getClass() + ".createInrespFromString";
	LOGGER.info(method
		+ ": Preparing XMXUTIL2InrespResponse to be Returned!");
	LOGGER.debug("Returned Data : " + rawResponse);
	List<String> rawLines = processLines(rawResponse);
	return new XMXUTIL2InrespResponse(rawLines);
    }

    public XMXUTIL2InmsgResponse createInmsgFromString(String rawResponse) {
	String method = this.getClass() + ".createInmsgFromString";
	LOGGER.info(method
		+ ": Preparing XMXUTIL2InmsgResponse to be Returned!");
	LOGGER.debug("Returned Data : " + rawResponse);
	List<String> rawLines = processLines(rawResponse);
	if (rawLines != null && !rawLines.isEmpty()) {
	    if (rawLines.get(0).startsWith("-1")) {
		return new XMXUTIL2InmsgResponse(rawLines.get(0), null, null,
			null);
	    } else {
		List<String> xmim = new ArrayList<String>();
		List<String> xminstr = new ArrayList<String>();
		List<String> xmiu = new ArrayList<String>();
		for (String rawLine : rawLines) {
		    if (rawLine.startsWith("XMIM")) {
			xmim.add(rawLine);
		    } else if (rawLine.startsWith("XMINSTR")) {
			xminstr.add(rawLine);
		    } else if (rawLine.startsWith("XMIU")) {
			xmiu.add(rawLine);
		    }
		}
		return new XMXUTIL2InmsgResponse(null, xmim, xminstr, xmiu);
	    }
	} else {
	    return new XMXUTIL2InmsgResponse();
	}
    }

    public XMXUTIL2NewResponse createXMXUTIL2NewResponseFromString(
	    String rawResponse) {
	LOGGER.debug("Returned Data : " + rawResponse);
	return new XMXUTIL2NewResponse(rawResponse);
    }

    public XMXUTIL2PriResponse createXMXUTIL2PriResponseFromString(
	    String rawResponse) {
	LOGGER.debug("Returned Data : " + rawResponse);
	return new XMXUTIL2PriResponse(rawResponse);
    }

    public XMXUtil2DateResponse createZDateResponseFromString(String rawResponse) {
	String method = this.getClass() + ".createZDateResponseFromString";
	LOGGER.info(method
		+ ": Preparing XMXUtil2ZDateResponse to be Returned!");
	XMXUtil2DateResponse response = new XMXUtil2DateResponse();

	if (StrUtils.hasAValue(rawResponse)) {
	    List<String> rawLines = processLines(rawResponse);

	    if (rawLines.size() != 0) {
		if (rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) {
		    response.setErrors(rawLines);
		} else {
		    response.setMsgDate(rawLines.get(0));
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

    /**
     * This method returns a structured XMXUTIL2RespResponse object based on the
     * raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMXUTIL2RespResponse
     */
    public XMXUTIL2RespResponse createRespFromString(String rawResponse) {

	LOGGER.debug("Returned Data : " + rawResponse);

	String[] lineSplit = rawResponse.split("\\^", 2);

	if (lineSplit.length == 1)
	    return new XMXUTIL2RespResponse(lineSplit[0].trim(), rawResponse);

	if (lineSplit.length == 2)
	    return new XMXUTIL2RespResponse(lineSplit[0].trim(),
		    lineSplit[1].trim(), rawResponse);

	return new XMXUTIL2RespResponse();
    }

    public XMXUtil2ZFromResponse createZFromResponseFromString(
	    String rawResponse) {
	String method = this.getClass() + ".createZFromResponseFromString";
	LOGGER.info(method
		+ ": Preparing XMXUtil2ZFromResponse to be Returned!");
	XMXUtil2ZFromResponse response = new XMXUtil2ZFromResponse();

	if (StrUtils.hasAValue(rawResponse)) {
	    List<String> rawLines = processLines(rawResponse);

	    if (rawLines.size() != 0) {
		if (rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) {
		    response.setErrors(rawLines);
		} else {
		    response.setZfromInfo(rawLines.get(0));
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

    public XMXUtil2ZNodeResponse createZNodeResponseFromString(
	    String rawResponse) {
	String method = this.getClass() + ".createZNodeResponseFromString: ";
	LOGGER.info(method
		+ ": Preparing XMXUtil2ZNodeResponse to be Returned!");
	XMXUtil2ZNodeResponse response = new XMXUtil2ZNodeResponse();

	if (StrUtils.hasAValue(rawResponse)) {
	    List<String> rawLines = processLines(rawResponse);

	    if (rawLines.size() != 0) {
		if (rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) {
		    response.setErrMsgs(rawLines);
		} else {
		    response.setZeroNode(rawLines.get(0));
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

    public XMXUtil2ZPriResponse createZPriResponseFromString(String rawResponse) {
	String method = this.getClass() + ".createZPriResponseFromString: ";
	LOGGER.info(method + ": Preparing XMXUtil2ZPriResponse to be Returned!");
	XMXUtil2ZPriResponse response = new XMXUtil2ZPriResponse(rawResponse);

	if (StrUtils.hasAValue(rawResponse)) {
	    List<String> rawLines = processLines(rawResponse);

	    if (rawLines.size() != 0) {
		if (rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) {
		    response.getErrors().add(rawLines.get(0));
		} else {
		    response.setMsgIsPriority(rawLines.get(0));
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

    public XMXUtil2ZReadResponse createZReadResponseFromString(
	    String rawResponse) {
	String method = this.getClass() + ".createZReadResponseFromString: ";
	LOGGER.info(method + "Preparing XMXUtil2ZReadResponse to be Returned!");
	XMXUtil2ZReadResponse response = new XMXUtil2ZReadResponse(rawResponse);

	/*
	 * RETURN PARAMETER DESCRIPTION: Null-User has not read the message at
	 * all 0-User has read the original message only Number-User has read
	 * through this response
	 */
	if (StrUtils.hasAValue(rawResponse)) {
	    List<String> rawLines = processLines(rawResponse);
	    if (rawLines.get(0).startsWith(VistaConstants.RPC_ERR_START)) {
		response.getErrors().add(rawLines.get(0));
	    } else {
		response.setNumResponsesRead(rawLines.get(0));
	    }
	} else {
	    response.setNumResponsesRead(null);
	}

	System.out.println(response.toString());
	return response;
    }

    public XMXUtil2LineResponse createLineResponse(String rawResponse) {
	try {
	    XMXUtil2LineResponse response;
	    // Check for error or success
	    if (!rawResponse.startsWith("-1^")) {
		response = new XMXUtil2LineResponse(rawResponse);
	    } else {
		String[] result = rawResponse.split("\\^");
		response = new XMXUtil2LineResponse(result[0],
			Arrays.asList(result[1]));
	    }
	    LOGGER.debug(response);
	    return response;
	} catch (Exception e) {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    "There an abnormality detected in the response from the source system.");
	    LOGGER.error(fault);
	    throw fault;
	}
    }

    public XMXUtil2ZSUBJResponse createZSUBJResponse(String rawResponse) {
	XMXUtil2ZSUBJResponse response;
	if (!rawResponse.startsWith("-1^")) {
	    response = new XMXUtil2ZSUBJResponse(rawResponse);

	} else {
	    String[] responseArray = rawResponse.split("\\^");
	    response = new XMXUtil2ZSUBJResponse(responseArray[0],
		    generateErrorsArray(rawResponse));
	}
	return response;
    }

    /**
     * This method returns a structured XMXUTIL2Inmsg1Response object based on
     * the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMXUTIL2Inmsg1Response
     */
    public XMXUTIL2Inmsg1Response createInmsg1FromString(String rawResponse) {

	if (LOGGER.isDebugEnabled())
	    LOGGER.debug("Returned Data : " + rawResponse);

	List<String> lines = this.processLines(rawResponse);

	if (lines.size() > 1)
	    return this.buildInmsg1ResponseFromList(lines, rawResponse);
	else
	    return this.buildInmsg1ResponseFromMessage(rawResponse);
    }

    /**
     * This method returns a structured XMXUTIL2Inmsg2Response object based on
     * the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMXUTIL2Inmsg2Response
     */
    public XMXUTIL2Inmsg2Response createInmsg2FromString(
	    final String rawResponse) {

	if (LOGGER.isDebugEnabled())
	    LOGGER.debug("Returned Data : " + rawResponse);

	List<String> lines = this.processLines(rawResponse);

	if (lines.size() > 1)
	    return this.buildInmsg2ResponseFromList(lines, rawResponse);
	else
	    return this.buildInmsg2ResponseFromMessage(rawResponse);

    }

    /**
     * This method returns a structured XMXUTIL2InrespsResponse object based on
     * the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMXUTIL2InrespsResponse
     */
    public XMXUTIL2InrespsResponse createInrespsFromString(
	    final String rawResponse) {

	if (LOGGER.isDebugEnabled())
	    LOGGER.debug("Returned Data : " + rawResponse);

	List<String> lines = this.processLines(rawResponse);

	if (lines.size() > 1)
	    return this.buildInrespsResponse(lines, rawResponse);
	else
	    return this.buildInrespsResponseFromMessage(rawResponse);
    }

    /**
     * This procedure processs the message response
     * 
     * @param rawResponse
     * @return XMXUTIL2Inmsg1Response
     */
    protected XMXUTIL2Inmsg1Response buildInmsg1ResponseFromMessage(
	    final String rawResponse) {

	String[] splitLines = rawResponse.split("\\^");

	if (2 == splitLines.length)
	    return new XMXUTIL2Inmsg1Response(splitLines[0].trim(),
		    splitLines[1].trim(), rawResponse);
	else
	    return new XMXUTIL2Inmsg1Response();
    }

    /**
     * This procedure processes the message response for the inmsg2 service
     * 
     * @param rawResponse
     * @return XMXUTIL2Inmsg2Response
     */
    protected XMXUTIL2Inmsg2Response buildInmsg2ResponseFromMessage(
	    final String rawResponse) {

	String[] splitLines = rawResponse.split("\\^");

	if (2 == splitLines.length)
	    return new XMXUTIL2Inmsg2Response(splitLines[0].trim(),
		    splitLines[1].trim(), rawResponse);
	else
	    return new XMXUTIL2Inmsg2Response();
    }

    /**
     * This procedure processes the message response for the inresps service
     * 
     * @param rawResponse
     * @return XMXUTIL2InrespsResponse
     */
    protected XMXUTIL2InrespsResponse buildInrespsResponseFromMessage(
	    final String rawResponse) {

	String[] splitLines = rawResponse.split("\\^");

	if (2 == splitLines.length)
	    return new XMXUTIL2InrespsResponse(splitLines[1].trim(),
		    rawResponse);
	else
	    return new XMXUTIL2InrespsResponse();
    }

    /**
     * This procedure processes the response lines and creates the Inmsg1
     * Respone object
     * 
     * @param reponseLines
     * @param rawResponse
     * @return XMXUTIL2Inmsg1Response
     */
    protected XMXUTIL2Inmsg1Response buildInmsg1ResponseFromList(
	    final List<String> reponseLines, final String rawResponse) {

	String createDt = null;
	String createDtMM = null;
	String sendDt = null;
	String sendDtMM = null;
	String from = null;
	String fromDuz = null;
	String fromName = null;
	String lines = null;
	String responses = null;
	String sender = null;
	String senderDuz = null;
	String senderName = null;
	String subject = null;
	String xmz = null;
	String ien = null;
	String resp = null;

	for (String s : reponseLines) {

	    String[] split = s.split("[=]");

	    if (2 == split.length) {

		if (split[0].indexOf("CRE8") > 0)
		    createDt = split[1].trim();

		if (split[0].indexOf("CRE8 MM") > 0)
		    createDtMM = split[1].trim();

		if (split[0].indexOf("DATE") > 0)
		    sendDt = split[1].trim();

		if (split[0].indexOf("DATE MM") > 0)
		    sendDtMM = split[1].trim();

		if (split[0].indexOf("FROM") > 0)
		    from = split[1].trim();

		if (split[0].indexOf("FROM DUZ") > 0)
		    fromDuz = split[1].trim();

		if (split[0].indexOf("FROM NAME") > 0)
		    fromName = split[1].trim();

		if (split[0].indexOf("LINES") > 0)
		    lines = split[1].trim();

		if (split[0].indexOf("RESPS") > 0)
		    responses = split[1].trim();

		if (split[0].indexOf("SENDR") > 0)
		    sender = split[1].trim();

		if (split[0].indexOf("SUBJ") > 0)
		    subject = split[1].trim();

		if (split[0].indexOf("XMZ") > 0)
		    xmz = split[1].trim();

		if (split[0].indexOf("IEN") > 0)
		    ien = split[1].trim();

		if (split[0].indexOf("RESP") > 0)
		    resp = split[1].trim();
	    }
	}

	return new XMXUTIL2Inmsg1Response(createDt, createDtMM, sendDt,
		sendDtMM, from, fromDuz, fromName, lines, responses, sender,
		senderDuz, senderName, subject, xmz, ien, resp, rawResponse);

    }

    /**
     * This procedure processes the response lines and creates the Inmsg2
     * Respone object
     * 
     * @param reponseLines
     * @param rawResponse
     * @return XMXUTIL2Inmsg2Response
     */
    protected XMXUTIL2Inmsg2Response buildInmsg2ResponseFromList(
	    final List<String> reponseLines, final String rawResponse) {

	String recipients = null;
	String flags = null;
	String type = null;
	String vaporize = null;
	String basket = null;
	String hint = null;
	String origin = null;
	String ien = null;
	String newMsg = null;

	for (String s : reponseLines) {

	    String[] split = s.split("[=]");

	    if (2 == split.length) {

		if (split[0].indexOf("RECIPS") > 0)
		    recipients = split[1].trim();

		if (split[0].indexOf("FLAGS") > 0)
		    flags = split[1].trim();

		if (split[0].indexOf("TYPE") > 0)
		    type = split[1].trim();

		if (split[0].indexOf("VAPOR") > 0)
		    vaporize = split[1].trim();

		if (split[0].indexOf("RCPT BSKT") > 0)
		    basket = split[1].trim();

		if (split[0].indexOf("SCR HINT") > 0)
		    hint = split[1].trim();

		if (split[0].indexOf("ORIGN8") > 0)
		    origin = split[1].trim();

		if (split[0].indexOf("IEN") > 0)
		    ien = split[1].trim();

		if (split[0].indexOf("NEW") > 0)
		    newMsg = split[1].trim();
	    }
	}

	return new XMXUTIL2Inmsg2Response(recipients, flags, type, vaporize,
		basket, hint, origin, ien, newMsg, rawResponse);

    }

    /**
     * This procedure processes the response lines and creates the Inresps
     * Respone object
     * 
     * @param responseLines
     * @param rawResponse
     * @return XMXUTIL2InrespsResponse
     */
    protected XMXUTIL2InrespsResponse buildInrespsResponse(
	    final List<String> responseLines, final String rawResponse) {

	String responses = null;
	String lastResponse = null;

	for (String s : responseLines) {

	    String[] split = s.split("[=]");

	    if (2 == split.length) {

		if (split[0].indexOf("RESPS") > 0)
		    responses = split[1].trim();

		if (split[0].indexOf("RESP") > 0)
		    lastResponse = split[1].trim();
	    }
	}

	return new XMXUTIL2InrespsResponse(responses, lastResponse, rawResponse);
    }

    /**
     * 
     * @param rawResponse
     * @return
     */
    public XMXUtil2KSeqNResponse getKSeqNResponse(String rawResponse) {
	XMXUtil2KSeqNResponse response = new XMXUtil2KSeqNResponse();
	try {
	    if (rawResponse.isEmpty()
		    || (!rawResponse.startsWith("-1") && (Long
			    .parseLong(rawResponse) >= 0))) {

		response.setSequenceNumber(rawResponse);

	    } else {
		String[] responseArray = rawResponse.split("\\^");
		response.setStatus(responseArray[0]);
		response.setErrors(generateErrorsArray(rawResponse));
	    }
	} catch (Exception e) {

	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse, e);
	    LOGGER.error(fault);
	    throw fault;
	}
	return response;
    }

    public XMXUtil2FromResponse createFromResponse(String rawResponse) {
	XMXUtil2FromResponse response = new XMXUtil2FromResponse();

	if (!rawResponse.startsWith("-1") && !rawResponse.contains("^")) {
	    response.setName(rawResponse);
	} else if (rawResponse.startsWith("-1") && rawResponse.contains("^")) {
	    String[] responseArray = rawResponse.split("\\^");
	    response.setStatus(responseArray[0]);
	    response.setErrors(generateErrorsArray(rawResponse));

	} else {
	    VistaWebServiceFault fault = new VistaWebServiceFault(
		    "Response from source system not recognized: "
			    + rawResponse);
	    LOGGER.error(fault);
	    throw fault;
	}
	return response;
    }

}
