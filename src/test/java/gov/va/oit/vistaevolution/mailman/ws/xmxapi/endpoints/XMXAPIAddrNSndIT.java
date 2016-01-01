package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class XMXAPIAddrNSndIT extends EvolutionIT<XMXAPIAddrNSndEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIAddrNSndIT.class);

    private XMXAPIAddrNSndRequest request;

    @Override
    protected Class<XMXAPIAddrNSndEndpoint> getType() {
	return XMXAPIAddrNSndEndpoint.class;
    }

    @Before
    public void setUp() {
	ArrayList<String> msg = new ArrayList<String>();
	msg.add("Hello, Line 1 of message");
	msg.add("Line 2 of message");
	msg.add("Line 3 of message");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry(".6", ""));

	String duz = "1";
	String xmDuz = "1";
	String xmSubj = "Test Subject 1 for ADDRNSND";
	String xmStrip = "";

	request = new XMXAPIAddrNSndRequest();
	request.setDuz(duz);
	request.setXmDuz(xmDuz);
	request.setXmSubj(xmSubj);
	request.setMsg(msg);
	request.setXmStrip(xmStrip);
	request.setXmTo(xmto);
    }

    /**
     * <em>Send an e-mail to the specified User.</em>
     * 
     * <pre>
     * Input Data: 
     * >Set U=”^”
     * >Set XMDUZ=1
     * >Set XMSUBJ=”Test Subject 1 for ADDRNSND”
     * >Set MSG(1)=”Hello, Line 1 of message”
     * >Set MSG(2)=”Line 2 of message” 
     * >Set MSG(3)=”Line 3 of message” 
     * >Set XMSTRIP=””
     * >Set XMTO(7)=””
     * >Set XMINSTR=””
     * 
     * Procedure Call:
     * 
     * > D
     * ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN RETURN="0^74844”
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSentEmailToUser() throws VistaWebServiceFault {

	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertNotNull(response.getMsgIen());
    }

    /**
     * <em>Generate an error with a subject that is shorter than 3 characters.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=1,XMSUBJ=”ZZ”
     * >Set MSG(1)=”Hello, Line 1 of message”,MSG(2)=”Line 2 of message”
     * >Set MSG(3)=”Line 3 of message”
     * >Set XMSTRIP=””,XMTO(7)=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="-1^Subject must be from 3 to 65 characters long."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendEmailWithShortSubject() throws Exception {
	request.setXmSubj("ZZ");
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertNotNull(response.getErrors());
    }

    /**
     * <em>Send e-mail to specified user with an empty subject.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=1,XMSUBJ=””
     * >Set MSG(1)=”Hello, Line 1 of message”,MSG(2)=”Line 2 of message”
     * >Set MSG(3)=”Line 3 of message”
     * >Set XMSTRIP=””,XMTO(7)=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="0^74845"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendEmailWithEmptySubject() throws Exception {
	request.setXmSubj("");
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertEquals("0", response.getStatus());
	assertNotNull(response.getMsgIen());
    }

    /**
     * <em> Generate an error with a subject that is greater than 65 characters.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=1,XMSUBJ=””,$P(XMSUBJ,”A”,66)=”B”
     * >Set MSG(1)=”Hello, Line 1 of message”,MSG(2)=”Line 2 of message”
     * >Set MSG(3)=”Line 3 of message”
     * >Set XMSTRIP=””,XMTO(7)=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="-1^Subject must be from 3 to 65 characters long."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendEmailWithLongSubject() throws Exception {
	request.setXmSubj("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBB");
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertNotNull(response.getErrors());
	assertEquals("Subject must be from 3 to 65 characters long.", response
		.getErrors().get(0));
    }

    /**
     * <em>Generate an error with missing XMDUZ parameter.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=””,XMSUBJ=”ADDRNSND Test no XMDUZ”
     * >Set MSG(1)=”Hello, Line 1 of message”,MSG(2)=”Line 2 of message”
     * >Set MSG(3)=”Line 3 of message”
     * >Set XMSTRIP=””,XMTO(7)=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendEmailWithNoXMDUZ() throws Exception {
	request.setXmDuz("");
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertEquals("Error in required input", response.getErrors().get(0));
    }

    /**
     * <em>Generate an error with missing body of message array.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=1,XMSUBJ=”ADDRNSND Test no message body”
     * >K MSG Set MSG=””
     * >Set XMSTRIP=””,XMTO(7)=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendEmailWithNoMessageBody() throws Exception {
	request.setMsg(null);
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertEquals("Error in required input", response.getErrors().get(0));
    }

    /**
     * <em>Generate an error with missing recipient array.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=1,XMSUBJ=”ADDRNSND Test no recipients”
     * >Set MSG(1)=”Hello, Line 1 of message”,MSG(2)=”Line 2 of message”
     * >Set MSG(3)=”Line 3 of message”
     * >K XMTO Set XMSTRIP=””,XMTO=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendEmailWithMissingRecipientList() throws Exception {
	request.setXmTo(null);
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertEquals("Error in required input", response.getErrors().get(0));
    }

    /**
     * <em>Generate an error with a non-existent recipient.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^” Set XMDUZ=1,XMSUBJ=”ADDRNSND Test bad recipients”
     * >Set MSG(1)=”Hello, Line 1 of message”,MSG(2)=”Line 2 of message”
     * >Set MSG(3)=”Line 3 of message”
     * >K XMTO Set XMSTRIP=””,XMTO(8)=””,XMINSTR=””
     * 
     * 
     * Procedure Call:
     * 
     * > D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RETURN
     * RETURN="-1^Addressee not found.^No addressees.  Message not sent."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testSendWithInvalidRecipient() throws Exception {
	request.setXmTo(Arrays.asList(new XMXAPIArrayEntry("500", "")));
	LOGGER.debug(request);
	XMXAPIAddrNSndResponse response = service.addrNSnd(request);
	LOGGER.debug(response);
	assertNotNull(response.getErrors());
    }

}
