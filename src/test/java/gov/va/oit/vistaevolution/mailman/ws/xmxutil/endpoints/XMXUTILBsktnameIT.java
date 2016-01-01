/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 * 
 */
public class XMXUTILBsktnameIT extends VistaLinkContextITParent {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUTILBsktnameIT.class);

    @Autowired
    private XMXUTILBsktnameEndpoint service;

    @Autowired
    private XMXAPIAddrNSndEndpoint msgService;

    private static XMXUTILBsktnameRequest request;

    private static XMXAPIAddrNSndRequest msgRequest;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	request = new XMXUTILBsktnameRequest();
	msgRequest = new XMXAPIAddrNSndRequest();
	createMsgRequest();
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	request = null;
	msgRequest = null;
    }

    /**
     * Test Case #1: Get basket information with option input
     * 
     */
    @Test
    public void testBsktname001() throws VistaWebServiceFault {
	XMXAPIAddrNSndResponse msgResponse = msgService.addrNSnd(msgRequest);

	request.setXmduz(".6");
	// request.setXmz("73994");
	LOGGER.debug("msg ien: " + msgResponse.getMsgIen());
	request.setXmz(msgResponse.getMsgIen());
	request.setXmname("1");

	XMXUTILBsktnameResponse response = service.bsktname(request);

	assertNotNull(response);
	LOGGER.debug("response: " + response.getBsktIEN() + " "
		+ response.getBsktName());

	// assertTrue(response.getBsktName().equals("IN"));
	assertTrue(response.getBsktIEN().equals("0"));
    }

    /**
     * Test Case #2: Get basket information with required input only
     * 
     * >S XMDUZ=.5,XMK=1 D BSKTNAME^XMWSOA06(.OUT,XMDUZ,XMK) >ZW OUT
     * OUT=â€�INâ€�
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testBsktname002() throws VistaWebServiceFault {

	XMXAPIAddrNSndResponse msgResponse = msgService.addrNSnd(msgRequest);

	request.setXmduz(".6");
	// request.setXmz("73994");
	LOGGER.debug("msg ien: " + msgResponse.getMsgIen());
	request.setXmz(msgResponse.getMsgIen());

	XMXUTILBsktnameResponse response = service.bsktname(request);

	assertNotNull(response);
	LOGGER.debug("response: " + response.getBsktIEN() + " "
		+ response.getBsktName());

	// assertTrue(response.getBsktIEN().equals("1"));
	assertTrue(response.getBsktIEN().equals("0"));
    }

    private static void createMsgRequest() {
	ArrayList<String> msg = new ArrayList<String>();
	msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
	msg.add("ZZ BASE Test case for API XMXAPI-ADDRNSND");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("POSTMASTER", ""));

	String duz = ".5";
	String xmDuz = ".5";
	String xmSubj = "ZZ VISTA API EXPOSURE XMXAPI-ADDRNSND";
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
    }

}
