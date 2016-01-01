package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIAddrNSndEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class XMXAPIAddrNSndTest extends VistaLinkContextTestParent {

    public XMXAPIAddrNSndTest() {
	// TODO Auto-generated constructor stub
    }

    /**
     * <em>Test Case #1  </em>
     * 
     * Error message “Error the required input: duz, is null".
     * 
     * <pre>
     * 	 Input Data:
     * 		>S DUZ=""
     * 		>S XMDUZ=1
     * 		>S XMSUBJ="VISTA API EXPOSURE ENT-XMA2R"
     * 		>S XMMSG(1)="BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios."
     * 		>S XMMSG(2)="BASE Test case for API $$ENT^XMA2R"
     * 		>S XMSTRIP=""
     * 		>S XMTO(1)=""
     * 		>S XMTO(.5)=""
     * 		>S XMINSTR("ADDR FLAGS")="I"
     * 		>ZW RETURN
     * 		
     * 		Procedure Call:
     * 		>D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.XMMSG,XMSTRIP,.XMTO,.XMINSTR) 
     * 		
     * 		Expected Output:
     * 		>ZW RETURN
     * 
     * RETURN="Error the required input: duz, is null"
     * 
     * </pre>
     */
    @Test
    public void jtestXMXAPIAddrNSnd001() throws VistaWebServiceFault {

	String expectedOutput = "0^74845";

	XMXAPIAddrNSndRequest request = new XMXAPIAddrNSndRequest();

	ArrayList<String> msg = new ArrayList<String>();
	msg.add("BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
	msg.add("BASE Test case for API $$ENT^XMA2R");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("CUNNINGHAM,ALLEN", ""));

	String duz = ""; // leave null
	String xmDuz = "1";
	String xmSubj = "VISTA API EXPOSURE ENT-XMA2R";
	String xmStrip = "";

	List<XMXAPIArrayEntry> xmInstr = Arrays.asList(new XMXAPIArrayEntry(
		"ADDR FLAGS", "I"));

	request.setDuz(duz);
	request.setXmDuz(xmDuz);
	request.setXmSubj(xmSubj);
	request.setMsg(msg);
	request.setXmStrip(xmStrip);
	request.setXmTo(xmto);
	request.setXmInstr(xmInstr);

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIAddrNSndEndpoint service = new XMXAPIAddrNSndEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	XMXAPIAddrNSndResponse response = service.addrNSnd(request);

	assertNotNull(response);

    }

    /**
     * <em>Test Case #1  </em>
     * 
     * Error message
     * "Error the subject must be between 3 and 65 characters long"
     * 
     * <pre>
     * 	 Input Data:
     * 		>S DUZ="1"
     * 		>S XMDUZ=1
     * 		>S XMSUBJ="VI"
     * 		>S XMMSG(1)="BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios."
     * 		>S XMMSG(2)="BASE Test case for API $$ENT^XMA2R"
     * 		>S XMSTRIP=""
     * 		>S XMTO(1)=""
     * 		>S XMTO(.5)=""
     * 		>S XMINSTR("ADDR FLAGS")="I"
     * 		>ZW RETURN
     * 		
     * 		Procedure Call:
     * 		>D ADDRNSND^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.XMMSG,XMSTRIP,.XMTO,.XMINSTR) 
     * 		
     * 		Expected Output:
     * 		>ZW RETURN
     * 
     * RETURN="Error the subject must be between 3 and 65 characters long"
     * 
     * </pre>
     */
    @Test
    public void jtestXMXAPIAddrNSnd002() throws VistaWebServiceFault {

	String expectedOutput = "-1^Error the subject must be between 3 and 65 characters long";

	XMXAPIAddrNSndRequest request = new XMXAPIAddrNSndRequest();

	ArrayList<String> msg = new ArrayList<String>();
	msg.add("BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
	msg.add("BASE Test case for API $$ENT^XMA2R");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("CUNNINGHAM,ALLEN", ""));

	List<XMXAPIArrayEntry> xmInstr = Arrays.asList(new XMXAPIArrayEntry(
		"ADDR FLAGS", "I"));
	String duz = "1";
	String xmDuz = "1";
	String xmSubj = "VI";
	String xmStrip = "";

	request.setDuz(duz);
	request.setXmDuz(xmDuz);
	request.setXmSubj(xmSubj);
	request.setMsg(msg);
	request.setXmStrip(xmStrip);
	request.setXmTo(xmto);
	request.setXmInstr(xmInstr);

	when(
		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
			null)).thenReturn(expectedOutput);

	XMXAPIAddrNSndEndpoint service = new XMXAPIAddrNSndEndpointImpl(
		new XMXAPIResponseFactory(), getVistaLinkContext());

	try {
	    service.addrNSnd(request);
	} catch (Exception e) {
	    assertEquals(
		    "Error the subject must be between 3 and 65 characters long",
		    e.getMessage());
	}

    }
    
    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIAddrNSndTest.class);

    @Test
    public void testName() throws Exception {
	XMXAPIAddrNSndRequest request = new XMXAPIAddrNSndRequest();

	ArrayList<String> msg = new ArrayList<String>();
	msg.add("BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
	msg.add("BASE Test case for API $$ENT^XMA2R");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry(".5", ""));

	List<XMXAPIArrayEntry> xmInstr = Arrays.asList(new XMXAPIArrayEntry(
		"ADDR FLAGS", "I"));
	String duz = "1";
	String xmDuz = "1";
	String xmSubj = "VI";
	String xmStrip = "stuff";

	request.setDuz(duz);
	request.setXmDuz(xmDuz);
	request.setXmSubj(xmSubj);
	request.setMsg(msg);
	request.setXmStrip(xmStrip);
	request.setXmTo(xmto);
	request.setXmInstr(xmInstr);
	LOGGER.debug(request);
    }

}
