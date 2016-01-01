package gov.va.oit.vistaevolution.utils;

import gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.XMDIT;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIReplyMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktResponse;
import gov.va.oit.vistaevolution.util.StrUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

public class MailUtils {
    private static final String ZZ = "ZZ ";
    private static final String SUBJECT = ZZ + "Test subject";
    private static final String DUZ = ".5";
    private static final Logger LOGGER = Logger.getLogger(XMDIT.class);

    /*
     * Initialize the request with default values.. These can be overridden by
     * users if needed
     */
    private static XMDRequest initXMDRequest() {
	String method = MailUtils.class + "init(): ";
	ArrayList<String> message = new ArrayList<String>();
	message = new ArrayList<String>();
	message.add(ZZ + "THIS IS A 2 LINE TEST MESSAGE");
	message.add(ZZ
		+ "THIS IS THE SECOND LINE ~&% with some text to be stripped.");

	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry(".6", ""));

	XMDRequest request = new XMDRequest();
	;
	request.setDuz(DUZ);
	request.setXmDuz(DUZ);
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);
	LOGGER.info(method + "Creating default message: " + request.toString());
	return request;
    }

    /**
     * <em>createMailMessage</em> input: (all input is optional except the
     * service, default values are supplied) instance of XMD service subj:- the
     * message subject, should start with ZZ mailTo: a semicolon separated list
     * of people to send msg to msgText: Lines of text for the msg body
     * 
     * 
     * 
     * New Message IEN example: 73986 <-- Your returned IEN will be a different
     * value or Error Message from XMDEndpoint Service
     * 
     * </pre>
     */

    public static String createMailMessage(XMDEndpoint msgService, String subj,
	    String mailTo, ArrayList<String> msgText) {
	String method = MailUtils.class + "createMailMessage(): ";
	XMDResponse msgResponse = null;
	XMDRequest msgRequest = initXMDRequest();

	msgRequest = checkForUserOverrideOfDefaultValues(msgRequest, subj,
		mailTo, msgText);

	msgResponse = msgService.xmd(msgRequest);
	if (msgResponse != null
		&& StrUtils.hasAValue(msgResponse.getResponse())
		&& msgResponse.getResponse().matches("^\\d+$")
		&& Integer.parseInt(msgResponse.getResponse()) > 0) {

	    LOGGER.info(msgResponse);
	    return msgResponse.getResponse();
	} else {
	    LOGGER.error(method + "failed to create new message ==> "
		    + msgResponse.getRawResponse());
	    return msgResponse.getRawResponse();
	}

    }

    public static String createMailMessageWithFrom(XMDEndpoint msgService,
	    String from, String subj, String mailTo, ArrayList<String> msgText) {
	String method = MailUtils.class + "createMailMessage(): ";
	XMDResponse msgResponse = null;
	XMDRequest msgRequest = initXMDRequest();

	msgRequest = checkForUserOverrideOfDefaultValues(msgRequest, subj,
		mailTo, msgText);
	msgRequest.setDuz(from);

	msgResponse = msgService.xmd(msgRequest);
	if (msgResponse != null
		&& StrUtils.hasAValue(msgResponse.getResponse())
		&& msgResponse.getResponse().matches("^\\d+$")
		&& Integer.parseInt(msgResponse.getResponse()) > 0) {

	    LOGGER.info(msgResponse);
	    return msgResponse.getResponse();
	} else {
	    LOGGER.error(method + "failed to create new message ==> "
		    + msgResponse.getRawResponse());
	    return msgResponse.getRawResponse();
	}

    }

    /*
     * User can override default values, override will be logged.
     */
    private static XMDRequest checkForUserOverrideOfDefaultValues(
	    XMDRequest msgRequest, String subj, String mailTo,
	    ArrayList<String> msgText) {
	String method = MailUtils.class
		+ "checkForUserOverrideOfDefaultValues(): ";
	if (StrUtils.hasAValue(mailTo)) {
	    LOGGER.info(method + "User added user in mailTo: " + mailTo);
	    msgRequest.getxMY().addAll(addMailToEntriesToMailList(mailTo));
	}

	if (StrUtils.hasAValue(subj)) {
	    LOGGER.info(method + "User overrode default subject: " + subj);
	    msgRequest.setXmSub(subj);
	}
	if (msgText != null && !msgText.isEmpty()) {
	    LOGGER.info(method + "User overrode default msg body: "
		    + StrUtils.listToString(msgText));
	    msgRequest.setMessage(msgText);
	}

	return msgRequest;

    }

    private static ArrayList<XMYEntry> addMailToEntriesToMailList(String mailTo) {
	ArrayList<XMYEntry> arrList = new ArrayList<XMYEntry>();
	if (StrUtils.hasAValue(mailTo)) {
	    String[] arr = mailTo.split(";");
	    if (arr.length > 0) {
		for (String s : arr) {
		    arrList.add(new XMYEntry(s, ""));
		}
	    }
	}
	return arrList;
    }

    public static String replyToMailMessage(XMXAPIReplyMsgEndpoint service,
	    String duz, String xmDuz, String xmk, String xmkz) {
	XMXAPIReplyMsgRequest request = new XMXAPIReplyMsgRequest();

	List<String> msg = new LinkedList<String>();
	msg.add("TEST MESSAGE LINE 1e");
	msg.add("");
	msg.add("");
	msg.add("THE END");

	List<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("53467", ""));

	request.setDuz(duz);
	request.setXmDuz(xmDuz);
	request.setXmk(xmk);
	request.setXmkz(xmkz);
	request.setXmBody(msg);

	XMXAPIReplyMsgResponse response = service.replyMsg(request);

	return response.getXmz();
    }

    public static String resequenceBasket(XMA03RenEndpoint service3,
	    String xmDuz, String xmk) {

	XMA03RenRequest request = new XMA03RenRequest(xmk, xmDuz);
	LOGGER.debug(request);
	XMA03RenResponse response = service3.ren(request);
	LOGGER.debug(response);
	return response.getResults();
    }

    public static String getRandNumString() {
	Double d = Math.random() * 1000000;
	String s = String.valueOf(d);
	String[] sarr = s.split("\\.");
	return sarr[0];
    }

    public static String createMailBasket(String name,
	    XMXAPIBCre8BsktEndpoint service) {
	String method = MailUtils.class + "createMailBasket(): ";
	name = name + getRandNumString();
	LOGGER.info(method
		+ "Adding random number to name for uniqueness, name is now:  "
		+ name);
	LOGGER.debug(method + "Creating basket with Name: " + name);
	LOGGER.debug(method + "Checking for ZZ prefix...");
	if (!name.startsWith("ZZ")) {
	    LOGGER.info(method + "Adding prefix of ZZ to basket name..");
	    name = "ZZ_" + name;
	    LOGGER.info(method + "Basket name will now be: " + name);
	} else {
	    LOGGER.info(method + "Name:  " + name + " is OK....");
	}

	String ien = "";

	XMXAPIBCre8BsktRequest request = new XMXAPIBCre8BsktRequest();
	request.setDuz("1");
	request.setXmDuz("1");
	request.setXmkn(name);
	XMXAPIBCre8BsktResponse response = service.cre8Bskt(request);
	if (StrUtils.hasAValue(response.getIen())) {
	    LOGGER.info(method + "Basket with name:  " + name
		    + " successfully created. IEN = " + response.getIen());
	    ien = response.getIen();
	} else {
	    LOGGER.error(method + "Failed to create basket with name:  " + name
		    + "\nError is: "
		    + StrUtils.listToString(response.getErrors()));
	}
	return ien;
    }

    public static String moveMessageToABasket(XMA1BS2Endpoint service,
	    String xmDuz, String basketIen, String msgIen) {
	String method = MailUtils.class + "moveMessageToABasket(): ";

	LOGGER.info(method + "Moving mesage:  " + msgIen + " to basket: "
		+ basketIen);
	// set up request
	XMA1BS2Request request = new XMA1BS2Request();
	request.setXmduz(StrUtils.hasAValue(xmDuz) ? xmDuz : "1");
	request.setXmkm(basketIen);
	request.setXmz(msgIen);

	XMA1BS2Response response = service.s2(request);
	if (StrUtils.hasAValue(response.getResponse())
		&& response.getResponse().startsWith("0")) {
	    LOGGER.info(method + "Successfully moved message:  " + msgIen
		    + " to basket: " + basketIen);
	    LOGGER.info(method + "Result: " + response.getResponse());
	} else {
	    LOGGER.info(method + "Failed to move message:  " + msgIen
		    + " to basket: " + basketIen);
	    LOGGER.info(method + "Result: " + response.getResponse());
	}

	return response.getResponse();
    }

}
