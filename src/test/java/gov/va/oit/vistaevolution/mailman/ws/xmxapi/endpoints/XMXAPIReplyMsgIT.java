package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIReplyMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPIReplyMsgIT extends EvolutionIT<XMXAPIReplyMsgEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIReplyMsgIT.class);

    private XMXAPIReplyMsgRequest request;
    private XMDEndpoint service2;
    private String newMailMessageIEN;
    private XMA03RenEndpoint service3;

    @Override
    protected Class<XMXAPIReplyMsgEndpoint> getType() {
	return XMXAPIReplyMsgEndpoint.class;
    }

    public String resequenceBasket(String xmDuz, String xmk) {
	try {
	    if (service3 == null)
		service3 = getEndpointImpl(XMA03RenEndpoint.class);
	    return MailUtils.resequenceBasket(service3, xmDuz, xmk);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    public String sendMessage(String to) {
	try {
	    if (service2 == null)
		service2 = getEndpointImpl(XMDEndpoint.class);

	    return MailUtils.createMailMessage(service2, null, to, null);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    @Before
    public void setUp() {
	newMailMessageIEN = sendMessage(null);
	request = new XMXAPIReplyMsgRequest();

	List<String> msg = new LinkedList<String>();
	msg.add("TEST MESSAGE LINE 1e");
	msg.add("");
	msg.add("");
	msg.add("THE END");

	List<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("53467", ""));

	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmkz(newMailMessageIEN);
	request.setXmBody(msg);
    }

    /**
     * 
     * RPLYMSGM^XMWSOA03(RETURN,DUZ,XMDUZ,XMKZ,MSG,XMINSTR)
     * RPLYMSGS^XMWSOA03(RETURN,DUZ,XMDUZ,XMK,XMKZ,MSG,XMINSTR)
     * 
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285883
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY"
     * 
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.5,.5,RETURN,.RPLY)
     * 
     * Expected Output: >ZW RESULT RESULT=285884
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testReplyToMessage() throws VistaWebServiceFault {

	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertTrue(Long.parseLong(request.getXmkz()) < Long.parseLong(response
		.getXmz()));

    }

    /**
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285886
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY"
     * 
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.5,.6,RETURN,.RPLY)
     * 
     * Expected Output: >ZW RESULT RESULT=285887
     */
    @Test
    public void testReplyToMessageWithDifferentDUZandXMDUZ() throws Exception {

	request.setXmDuz(".6");
	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertTrue(Long.parseLong(request.getXmkz()) < Long.parseLong(response
		.getXmz()));

    }

    /**
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285888
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY"
     * 
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.6,.6,RETURN,.RPLY)
     * 
     * Expected Output: >ZW RESULT
     * RESULT="-1^SHARED,MAIL may not Reply to a message."
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testReplyToMessageWithSharedMail() throws VistaWebServiceFault {
	String expectedOutput = "-1^SHARED,MAIL may not Reply to a message.";

	request.setDuz(".6");
	request.setXmDuz(".6");

	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));

    }

    /**
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285890
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY"
     * 
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.6,.6,RETURN)
     * 
     * Expected Output: >ZW RESULT RESULT="-1^Error in required input"
     */
    @Test
    public void testReplyToMessageWithMissingXmBody() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setXmBody(null);

	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285890
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY" >S FLG("ADDR FLAGS")="R”
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.6,.6,RETURN,.FLG)
     * 
     * Expected Output: >ZW RESULT RESULT=285891
     */
    @Test
    public void testReplyToMessageWithAddrFlags() throws Exception {
	request.setXmInstr(Arrays
		.asList(new XMXAPIArrayEntry("ADDR FLAGS", "R")));

	XMXAPIReplyMsgResponse response = service.replyMsg(request);

	assertNotNull(response);
	assertTrue(Long.parseLong(request.getXmkz()) < Long.parseLong(response
		.getXmz()));
    }

    /**
     * Input Data:
     * 
     * >S MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2",.MSG,.TO)
     * 
     * >ZW RETURN RETURN=285890
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY" >S FLG("ADDR FLAGS")="R” >S RETURN=RETURN+100
     * 
     * Procedure Call: >D RPLYMSGM^XMWSOA03(.RESULT,.6,.6,RETURN,.FLG)
     * 
     * Expected Output: >ZW RESULT
     * RESULT="-1^XMZ message ranges are not allowed."
     */
    @Test
    public void testSendMessageWithBadIEN() throws Exception {
	String expectedOutput = "-1^XMZ message ranges are not allowed.";

	request.setXmkz(Long.toString(Long.parseLong(request.getXmkz()) + 100));

	request.setXmInstr(Arrays
		.asList(new XMXAPIArrayEntry("ADDR FLAGS", "R")));

	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * 
     * RPLYMSGS^XMWSOA03(RETURN,DUZ,XMDUZ,XMK,XMKZ,MSG,XMINSTR)
     * 
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * 
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
     * Procedure Call: > D RPLYMSGS^XMWSOA03(.RESULT,.5,.6,"IN",25,.RPLY,.FLG)
     * 
     * Expected Output: > ZW RESULT RESULT=285894
     */
    @Test
    public void testReplyToMessageWithXMK() throws Exception {
	resequenceBasket(".6", "1");

	request.setXmDuz(".6");
	request.setXmk("IN");
	request.setXmkz("25");

	request.setXmInstr(Arrays.asList(new XMXAPIArrayEntry("ADDR FLAGS",
		"IR")));

	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertTrue(Long.parseLong(request.getXmkz()) < Long.parseLong(response
		.getXmz()));
    }

    /**
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2A",.MSG,.TO) >ZW
     * RETURN RETURN=285895
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 25."
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY" >S FLG("ADDR FLAGS")="IR"
     * 
     * Procedure Call: > D RPLYMSGS^XMWSOA03(.RESULT,.5,.6,"EVO",25,.RPLY,.FLG)
     * 
     * Expected Output: > ZW RESULT RESULT=
     * "-1^Basket 'EVO' not found.^Message '25' in basket 'EVO' does not exist."
     */
    @Test
    public void testReplyToMessageWithBadXMK() throws Exception {

	String expectedOutput = "-1^Basket 'ASDF' not found.^Message '25' in basket 'ASDF' does not exist.";

	resequenceBasket(".6", "1");

	request.setXmDuz(".6");
	request.setXmk("ASDF");
	request.setXmkz("25");

	request.setXmInstr(Arrays.asList(new XMXAPIArrayEntry("ADDR FLAGS",
		"IR")));
	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
	assertEquals(expectedOutput.split("\\^")[2], response.getErrors()
		.get(1));
    }

    /**
     * Input Data: >S
     * MSG(1)="TEST MESSAGE LINE 1",MSG(2)="",MSG(3)="",MSG(4)="THE END" >S
     * TO(.6)="",TO(.5)="" >D
     * XMD^XMWSOA02(.RETURN,.5,.5,"TEST MESSAGE FOR RPC RPLY 2A",.MSG,.TO) >ZW
     * RETURN RETURN=285895
     * 
     * >D REN^XMWSOA01(.RES,.6,1)
     * 
     * >ZW RES RES="0^Resequenced from 1 to 25."
     * 
     * >S
     * RPLY(1)="MY REPLY",RPLY(2)="LINE 2 OF REPLY",RPLY(3)="LINE 3 OF REPLY",
     * RPLY(4)="END REPLY" >S FLG("ADDR FLAGS")="IR"
     * 
     * Procedure Call: Note 250 could be any number higher than returned from
     * the REN call above. Note same result if you use mail basket name of “IN”
     * > D RPLYMSGS^XMWSOA03(.RESULT,.5,.6,1,250,.RPLY,.FLG)
     * 
     * Expected Output: > ZW RESULT
     * RESULT="-1^Message '205' in basket '1' does not exist."
     */
    @Test
    public void testReplyToMessageWithXMKandBadXMKZ() throws Exception {

	resequenceBasket(".6", "1");

	request.setXmDuz(".6");
	request.setXmk("IN");
	request.setXmkz(Long.toString(Long.parseLong(request.getXmkz()) + 100));

	String expectedOutput = "-1^Message '" + request.getXmkz()
		+ "' in basket '1' does not exist.";

	request.setXmInstr(Arrays.asList(new XMXAPIArrayEntry("ADDR FLAGS",
		"IR")));

	LOGGER.debug(request);
	XMXAPIReplyMsgResponse response = service.replyMsg(request);
	LOGGER.debug(response);
	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
}
