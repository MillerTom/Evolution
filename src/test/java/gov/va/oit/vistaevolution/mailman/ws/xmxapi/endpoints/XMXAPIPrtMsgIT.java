package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPrtMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class XMXAPIPrtMsgIT extends EvolutionIT<XMXAPIPrtMsgEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXAPIPrtMsgIT.class);

    private XMXAPIPrtMsgRequest request;
    private String newMailMessageIEN;

    @Override
    protected Class<XMXAPIPrtMsgEndpoint> getType() {
	return XMXAPIPrtMsgEndpoint.class;
    }

    @Before
    public void setUp() {
	XMDEndpoint service2 = null;
	try {
	    service2 = getEndpointImpl(XMDEndpoint.class);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	if (service != null) {
	    // private class variable
	    this.newMailMessageIEN = MailUtils.createMailMessage(service2,
		    null, null, null);
	    LOGGER.info("XMXUtil2ZReadIT new ien = " + this.newMailMessageIEN);
	} else {
	    LOGGER.error("Service was null");
	}

	request = new XMXAPIPrtMsgRequest();

	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(newMailMessageIEN,
		"")));
	request.setXmPrtTo("NLA0:");
    }

    /**
     * <em>Send a single message to the printer</em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=.5,XMDUZ=.5,XMKZA=468949,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="1 message sent to printer.^402”
     * 
     * </pre>
     */
    @Test
    public void testSendMessageToPrinter() throws VistaWebServiceFault {
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertNotNull(response.getTaskNumber());
    }

    /**
     * <em> API sending back an error message</em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=.5,XMDUZ=.5,XMKZA=99999999,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="-1^Message ‘99999999’ does not exist."
     * </pre>
     */
    @Test
    public void testSendMessageToPrinterWithBadXMKZA()
	    throws VistaWebServiceFault {
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("99999999", "")));

	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);

	assertEquals("-1", response.getStatus());
    }

    /**
     * <em> DUZ is NULL </em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=””,XMDUZ=.5,XMKZA=468949,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     */
    @Test
    public void testSendMessageToPrinterWithEmptyDUZ()
	    throws VistaWebServiceFault {
	request.setDuz("");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * <em> XMDUZ is NULL </em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=.5,XMDUZ=””,XMKZA=468949,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageToPrinterWithXMDUZ() throws Exception {
	request.setXmDuz("");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * <em> No message ID sent</em>
     * 
     * <pre>
     * Input Data:
     * >S U="^",DUZ=.5,XMDUZ=.5,XMKZA=””,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call:
     * >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output:
     * > ZW RETURN
     * RETURN="0 messages sent to printer.^"
     * </pre>
     */
    @Test
    public void testSendMessageToPrinterWithEmptyXMKZA() throws Exception {
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("", "")));
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertNotNull(response.getStatus());
    }

    /**
     * Inactive user.
     * 
     * Input Data: >S
     * U="^",DUZ=120,XMDUZ=120,XMKZA=468949,XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call: >D PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^User '120' not found."
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageToPrinterWithBadDUZandXMDUZ() throws Exception {
	request.setDuz("120");
	request.setXmDuz("120");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * All parameters in use.
     * 
     * Input Data: > S
     * U="^",DUZ=.5,XMDUZ=.5,XMKZA=468949,XMPRTTO="NLA0:",XMINSTR
     * ="HDR",XMSUBJ="TEST PRINT REPORT FOR ",XMTO=".6",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGM^XMWSOA03(.RETURN,DUZ,XMDUZ,XMKZA,XMPRTTO,XMINSTR,XMSUBJ,XMTO)
     * 
     * Expected Output: > ZW RETURN RETURN="1 message sent to printer.^403"
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageToPrinterWithAllParams() throws Exception {
	request.setXmInstr("HDR");
	request.setXmSubj("TEST PRINT REPORT FOR ");
	request.setXmTo(Arrays.asList(new XMXAPIArrayEntry(".6", "")));
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertNotNull(response.getTaskNumber());
    }

    /**
     * Print a message using a basket/sequence
     * 
     * Input Data: >S
     * U="^",DUZ=.5,XMDUZ=.5,XMK=1048,XMKZA(“62539,62541”)="",XMPRTTO
     * ="NLA0:",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN RETURN="2 message sent to printer.^405"
     * 
     * @throws Exception
     */
    @Test
    public void testSendMulitpleMessagesToPrinter() throws Exception {

	XMDEndpoint service2 = null;
	String ien = null;
	try {
	    service2 = getEndpointImpl(XMDEndpoint.class);
	    ien = MailUtils.createMailMessage(service2, null, null, null);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(request.getXmkza()
		.get(0).getIndex()
		+ "," + ien, "")));
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertNotNull(response.getTaskNumber());
    }

    /**
     * Error message returned from API
     * 
     * Input Data: >S
     * U="^",DUZ=.5,XMDUZ=.5,XMK=1048,XMKZA(“36”)="",XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN
     * RETURN="-1^Message '36' in basket '1105' does not exist."
     */
    @Test
    public void testSendMessageToPrinterWithWrongBasket() throws Exception {
	request.setXmk("1048");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("777777777", "")));
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * No DUZ sent
     * 
     * Input Data: >S
     * U="^",DUZ=””,XMDUZ=.5,XMK=1048,XMKZA(“1,3”)="",XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     */
    @Test
    public void testSendMessageToPrinterWithXMKandNoDUZ() throws Exception {
	request.setXmk("1048");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("1,3", "")));
	request.setDuz("");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * No XMDUZ sent
     * 
     * Input Data: >S
     * U="^",DUZ=.5,XMDUZ=””,XMK=1048,XMKZA(“1,3”)="",XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     */
    @Test
    public void testSendMessageToPrinterWithXMKandNoXMDUZ() throws Exception {
	request.setXmk("1048");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("1,3", "")));
	request.setXmDuz("");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * No XMK sent
     * 
     * Input Data: >S
     * U="^",DUZ=.5,XMDUZ=.5,XMK=””,XMKZA(“1,3”)="",XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     */
    @Test
    public void testSendMessageToPrinterWithEmptyXMK() throws Exception {
	request.setXmk("");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * No XMKZA sent
     * 
     * Input Data: >S
     * U="^",DUZ=.5,XMDUZ=.5,XMK=1048,XMKZA="",XMPRTTO="NLA0:",RETURN=””
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO)
     * 
     * Expected Output: >ZW RETURN RETURN="0 messages sent to printer.^"
     */
    @Test
    public void testSendMessageToPrinterWithXMKandEmptyXMKZA() throws Exception {
	request.setXmk("1");
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry("", "")));
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertNotNull(response.getStatus());
    }

    /**
     * No Print device sent
     * 
     * Input Data: >S
     * U="^",DUZ=.5,XMDUZ=.5,XMK=1048,XMKZA(“1,3”)="",XMPRTTO="",RETURN=””
     * 
     * Procedure Call: >D PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     */
    @Test
    @Ignore
    public void testSendMessageToPrinterWithEmptyPrtTo() throws Exception {
	request.setXmPrtTo("");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * Input Data: >S
     * U="^",DUZ=120,XMDUZ=120,XMK=1048,XMKZA(“1,3”)="",XMPRTTO="NLA0:"
     * ,RETURN=””
     * 
     * Procedure Call: >D PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA)
     * 
     * Expected Output: >ZW RETURN
     * RETURN="-1^User '120' not found.^Basket '1048' not found."
     */
    @Test
    public void testSendMessageThatGeneratesMultipleErrors() throws Exception {
	request.setDuz("120");
	request.setXmDuz("120");
	request.setXmk("1048");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertEquals("-1", response.getStatus());
    }

    /**
     * Test all parameters
     * 
     * Input Data: > S
     * RETURN="",DUZ=.5,XMDUZ=.5,XMK=1048,XMKZA("1,3")="",XMPRTTO
     * ="NLA0:",XMINSTR="RESPS",XMSUBJ="TEST PRINT OF BASKET FOR",XMTO(.6)=""
     * 
     * Procedure Call: >D
     * PRTMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,.XMK,.XMKZA,XMPRTTO,
     * XMINSTR,XMSUBJ,.XMTO)
     * 
     * Expected Output: > ZW RETURN RETURN="2 messages sent to printer.^409"
     */
    @Test
    public void testSendMessageToPrinterWithXMKandAllParams() throws Exception {
	XMDEndpoint service2 = null;
	String ien = null;
	try {
	    service2 = getEndpointImpl(XMDEndpoint.class);
	    ien = MailUtils.createMailMessage(service2, null, null, null);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	request.setXmInstr("RESPS");
	request.setXmSubj("TEST PRINT REPORT FOR ");
	request.setXmTo(Arrays.asList(new XMXAPIArrayEntry(".6", "")));
	request.setXmkza(Arrays.asList(new XMXAPIArrayEntry(request.getXmkza()
		.get(0).getIndex()
		+ "," + ien, "")));
	// request.setXmk("1");
	LOGGER.debug(request);
	XMXAPIPrtMsgResponse response = service.prtMsg(request);
	LOGGER.debug(response);
	assertNotNull(response.getTaskNumber());
    }
}
