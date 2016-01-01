package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIReplyMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPITermMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPITermMsgIT extends EvolutionIT<XMXAPITermMsgEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPITermMsgIT.class);

    private XMXAPITermMsgRequest request;
    private String newMailMessageIEN;
    private XMDEndpoint service2;
    private XMXAPIReplyMsgEndpoint service3;
    private XMA03RenEndpoint service4;

    @Override
    protected Class<XMXAPITermMsgEndpoint> getType() {
	return XMXAPITermMsgEndpoint.class;
    }

    @Before
    public void setUp() {
	newMailMessageIEN = sendMessage();

	request = new XMXAPITermMsgRequest();

	request.setDuz(".5");
	request.setXmDuz(".6");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(newMailMessageIEN,
		"")));
    }

    public String replyToMessage(String duz, String xmDuz, String xmk,
	    String xmkz) {
	try {
	    if (service3 == null)
		service3 = getEndpointImpl(XMXAPIReplyMsgEndpoint.class);

	    LOGGER.info("XMXUtil2ZReadIT new ien = " + this.newMailMessageIEN);
	    return MailUtils.replyToMailMessage(service3, duz, xmDuz, xmk,
		    xmkz);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}
    }

    public String resequenceBasket(String xmDuz, String xmk) {
	try {
	    if (service4 == null)
		service4 = getEndpointImpl(XMA03RenEndpoint.class);
	    return MailUtils.resequenceBasket(service4, xmDuz, xmk);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    public String sendMessage() {
	try {
	    if (service2 == null)
		service2 = getEndpointImpl(XMDEndpoint.class);

	    LOGGER.info("XMXUtil2ZReadIT new ien = " + this.newMailMessageIEN);
	    return MailUtils.createMailMessage(service2, null, null, null);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    /**
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * RETURN RETURN=285893
     * 
     * >S ARR=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT RESULT="-1^Error in required input"
     * 
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testTerminateMessageWithBadXMKZA() throws VistaWebServiceFault {

	String expectedOutput = "-1^Error in required input";
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("", "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * RETURN RETURN=285893
     * 
     * >S ARR(285893)=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT RESULT="0^1 message terminated."
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testTerminateMessage() throws VistaWebServiceFault {

	String expectedOutput = "0^1 message terminated.";

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }

    /**
     * <em>try to terminate a message that does not exist</em>
     * 
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * 
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * 
     * RETURN RETURN=285890
     * 
     * Set array value higher then the message IEN that was just created >S
     * ARR(286000)=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT RESULT="-1^Message '286000' does not exist."
     */
    @Test
    public void testTerminateNonExistingMessage() throws Exception {

	// Get the mail ID and add to it.
	Long id = Long.parseLong(request.getXmkza().get(0).getIndex());
	id += 1000;

	// Set up my expected output.
	String expectedOutput = "-1^Message '" + Long.toString(id)
		+ "' does not exist.";

	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(Long.toString(id),
		"")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * delete a range of messages
     * 
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * RETURN RETURN=285898
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM 1",.MSG,.TO) >ZW
     * RETURN RETURN=285899
     * 
     * >S ARR(“285898-285899”)=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT
     * RESULT="-1^XMZ message ranges are not allowed."
     */
    @Test
    public void testTerminateMessages() throws Exception {

	// Set up my expected output.
	String expectedOutput = "-1^XMZ message ranges are not allowed.";

	String testMessageID = sendMessage();

	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(request.getXmkza()
		.get(0).getIndex()
		+ "-" + testMessageID, "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * try to delete a replied message Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2A",.MSG,.TO) >ZW
     * RETURN RETURN=285893
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 25."
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY" >S FLG("ADDR FLAGS")="IR"
     * 
     * > D RPLYMSGS^XMWSOA03(.RESULT,.5,.6,"IN",25,.RPLY,.FLG)
     * 
     * > ZW RESULT RESULT=285894
     * 
     * >S ARR(285894)=""
     * 
     * Procedure Call: > D TERMMSGM^XMWSOA08(.RESULT,.5,.6,.ARR)
     * 
     * Expected Output: > ZW RESULT
     * RESULT="-1^Message 285894 is a response to message 285893."
     */
    @Test
    public void testTerminateReply() throws Exception {
	String firstMessage = request.getXmkza().get(0).getIndex();
	// resequenceBasket(".6", "1");
	String replyMessage = replyToMessage(".5", ".6", null, firstMessage);

	// Set up my expected output.
	String expectedOutput = "-1^Message " + replyMessage
		+ " is a response to message " + firstMessage + ".";

	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(replyMessage, "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * create and delete a range of messages Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)=""
     * 
     * >D XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285918
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)=""
     * 
     * >D XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC TERM",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285919
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 26."
     * 
     * >S ARR("24-26")=""
     * 
     * Procedure Call: >D TERMMSGS^XMWSOA08(.RESULT,.6,.6,1,.ARR)
     * 
     * Expected Output: >ZW RESULT RESULT="0^3 messages terminated."
     */
    @Test
    public void testTerminateRangeOfMessages() throws Exception {
	sendMessage();
	resequenceBasket(".6", "1");

	// Set up my expected output.
	String expectedOutput = "0^3 messages terminated.";

	request.setDuz(".6");
	request.setXmDuz(".6");
	request.setXmk("1");
	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("24-26", "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }

    /**
     * try to terminate a range of messages that does not exist
     * 
     * Input Data:
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 23."
     * 
     * > S ARR("124-126")=""
     * 
     * Procedure Call: >D TERMMSGS^XMWSOA08(.RESULT,.6,.6,1,.ARR)
     * 
     * Expected Output: >ZW RESULT RESULT="0^0 messages terminated."
     */
    @Test
    public void testTerminateRangeOfNonExistentMessages() throws Exception {

	String firstMessage = request.getXmkza().get(0).getIndex();
	// Set up my expected output.
	String expectedOutput = "0^0 messages terminated.";

	request.setDuz(".6");
	request.setXmDuz(".6");
	request.setXmk("1");
	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(Long.toString(Long
		.parseLong(firstMessage) + 1)
		+ "-"
		+ Long.toString(Long.parseLong(firstMessage) + 100), "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }

    /**
     * try to terminate messages from a basket that does not exist
     * 
     * Input Data:
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 23."
     * 
     * > S ARR("12-14")=""
     * 
     * Procedure Call: >D TERMMSGS^XMWSOA08(.RESULT,.6,.6,”ASDF”,.ARR)
     * 
     * Expected Output: >ZW RESULT RESULT="-1^Basket 'ASDF' not found."
     */
    @Test
    public void testTerminateMessagesInBadBasket() throws Exception {
	sendMessage();
	resequenceBasket(".6", "1");

	String expectedOutput = "-1^Basket 'ASDF' not found.";

	request.setDuz(".6");
	request.setXmDuz(".6");
	request.setXmk("ASDF");
	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("12-14", "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * missing input call
     * 
     * Input Data:
     * 
     * Procedure Call: > D TERMMSGS^XMWSOA08(.RESULT,.6,,999,.ARR)
     * 
     * Expected Output: >ZW RESULT RESULT="-1^Error in required input"
     */
    @Test
    public void testTerminateMessageWithXMKMissingXMDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setDuz(".6");
	request.setXmDuz("");
	request.setXmk("999");
	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("124-125", "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * terminate a couple messages
     * 
     * Input Data:
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 23."
     * 
     * >S ARR("20,22")=""
     * 
     * Procedure Call: > D TERMMSGS^XMWSOA08(.RESULT,.6,.6,1,.ARR)
     * 
     * Expected Output: >ZW RESULT RESULT="0^2 messages terminated."
     */
    @Test
    public void testTerminateTwoMessages() throws Exception {
	sendMessage();
	resequenceBasket(".6", "1");

	// Set up my expected output.
	String expectedOutput = "0^2 messages terminated.";

	request.setDuz(".6");
	request.setXmDuz(".6");
	request.setXmk("1");
	// Create new XMKZA array.
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("20,22", "")));

	LOGGER.debug(request);
	XMXAPITermMsgResponse response = service.termMsg(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getMessage());
    }
}
