/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITSubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 * 
 */
public class XMXEDITSubjIT extends EvolutionIT<XMXEDITSubjEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXEDITSubjIT.class);

    /**
     * Test Case #1: valid input
     */
    @Test
    public void testSubj001() throws VistaWebServiceFault, Exception {

	XMXAPIAddrNSndEndpoint service2 = this
		.getEndpointImpl(XMXAPIAddrNSndEndpoint.class);

	XMXAPIAddrNSndRequest msgRequest = new XMXAPIAddrNSndRequest();

	ArrayList<String> msg = new ArrayList<String>();
	msg.add("LINE 1");
	msg.add("LINE 2");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("POSTMASTER", ""));
	String duz = ".6";
	String xmDuz = ".6";
	String xmSubj = "INFO TOGGLE TEST";
	String xmStrip = "";
	List<XMXAPIArrayEntry> xmInstr = Arrays.asList(new XMXAPIArrayEntry(
		"ADDR FLAGS", "I"));
	msgRequest = new XMXAPIAddrNSndRequest();
	msgRequest.setDuz(duz);
	msgRequest.setXmDuz(xmDuz);
	msgRequest.setXmSubj(xmSubj);
	msgRequest.setMsg(msg);
	msgRequest.setXmStrip(xmStrip);
	msgRequest.setXmTo(xmto);
	msgRequest.setXmInstr(xmInstr);

	XMXAPIAddrNSndResponse msgResponse = service2.addrNSnd(msgRequest);

	XMXEDITSubjRequest request = new XMXEDITSubjRequest(
		msgResponse.getMsgIen(), "XMWSOA SUBJ TESTING");

	XMXEDITSubjResponse response = service.subj(request);

	assertNotNull(response);

	LOGGER.debug("response xmim: " + response.getXmim());

	assertTrue(response.getXmim().equals("0^Successful"));

    }

    /**
     * Test Case #2: Error in required input
     */
    @Test
    public void testSubj002() throws VistaWebServiceFault {
	XMXEDITSubjRequest request = new XMXEDITSubjRequest("0",
		"XMWSOA SUBJ TESTING");

	XMXEDITSubjResponse response = service.subj(request);

	assertNotNull(response);

	LOGGER.debug("response xmim: " + response.getXmim());

	assertTrue(response.getXmim().equals("-1^Error in required input"));
    }

    /**
     * Test Case #3: Message not found
     */
    @Test
    public void testSubj003() throws VistaWebServiceFault {
	XMXEDITSubjRequest request = new XMXEDITSubjRequest("-9999",
		"XMWSOA SUBJ TESTING");

	XMXEDITSubjResponse response = service.subj(request);

	assertNotNull(response);

	LOGGER.debug("response xmim: " + response.getXmim());

	assertTrue(response.getXmim().equals("-1^Message not found"));
    }

    /**
     * Test Case #4: Incorrect subject length
     */
    @Test
    public void testSubj004() throws VistaWebServiceFault {
	XMXEDITSubjRequest request = new XMXEDITSubjRequest("74457", "X");

	XMXEDITSubjResponse response = service.subj(request);

	assertNotNull(response);

	LOGGER.debug("response xmim: " + response.getXmim());

	assertTrue(response.getXmim().equals("-1^Incorrect subject length"));
    }

    @Override
    protected Class<XMXEDITSubjEndpoint> getType() {
	return XMXEDITSubjEndpoint.class;
    }

}
