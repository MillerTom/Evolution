package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPISendBullEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendBullEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class XMXAPISendBullTest extends VistaLinkContextTestParent {

    private XMXAPISendBullRequest request;

    @Before
    public void setUp() {
	request = new XMXAPISendBullRequest();
	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmbn("XUSSPKI SAN");
	request.setXmParm(Arrays.asList(new XMXAPIArrayEntry("1",
		"TEST SUBJECT"), new XMXAPIArrayEntry("2", "SHARED,MAIL")));
	request.setXmTo(Arrays.asList(new XMXAPIArrayEntry(".6", "")));
	request.setMsg(Arrays
		.asList("TEST INFORMATIONAL ADDITION TO BROADCAST"));
    }

    /**
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="XUSSPKI SAN",XMPARM(1)="TEST SUBJECT"
     * ,XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST",XMINSTR=""
     * 
     * Procedure Call: >D
     * SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,.MSG,.XMTO,.XMINSTR)
     * 
     * Expected Output: >ZW RESULT RESULT=286774
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSendBulletin() throws VistaWebServiceFault {

	String expectedOutput = "286774";

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPISendBullEndpoint service = new XMXAPISendBullEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPISendBullResponse response = service.sendBull(request);

	assertNotNull(response);
	assertEquals(expectedOutput, response.getXmz());

    }

    /**
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="VISTA EVO1",XMPARM(1)="TEST SUBJECT",
     * XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST"
     * ,XMINSTR("ADDR FLAGS")="IR",XINSTR("VAPOR")=3140324.1522
     * 
     * Procedure Call: >D
     * SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,.MSG,.XMTO,.XMINSTR)
     * 
     * Expected Output: >ZW RESULT RESULT="-1^Bulletin 'VISTA EVO1' not found."
     */
    @Test
    public void testSendBulletinWithBadName() {
	String expectedOutput = "-1^Bulletin 'VISTA EVO1' not found.";

	request.setXmbn("VISTA EVO1");

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPISendBullEndpoint service = new XMXAPISendBullEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPISendBullResponse response = service.sendBull(request);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

}
