/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Response;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 * 
 */
public class XMXUTIL2Inmsg2IT extends VistaLinkContextITParent {

    @Autowired
    private XMXUTIL2Inmsg2Endpoint service;

    @Autowired
    private XMXAPIAddrNSndEndpoint msgService;

    @Test
    public void inmsg001() {

	XMXUTIL2Inmsg2Request request = new XMXUTIL2Inmsg2Request();

	request.setXmduz("");
	request.setXmz("77378");

	XMXUTIL2Inmsg2Response response = this.service.inmsg2(request);

	assertNotNull(response);
	assertEquals("-1", response.getStatus());
	assertEquals("Error in required input", response.getMessage());
	System.out.println(response);
    }

    @Test
    public void inmsg002() {

	XMXUTIL2Inmsg2Request request = new XMXUTIL2Inmsg2Request();

	request.setXmduz(".6");
	request.setXmz(this.createMessage().getMsgIen());

	XMXUTIL2Inmsg2Response response = this.service.inmsg2(request);

	assertNotNull(response);
	System.out.println(response);
    }

    @Test
    public void inmsg003() {

	XMXUTIL2Inmsg2Request request = new XMXUTIL2Inmsg2Request();

	request.setXmduz(".6");
	request.setXmz(this.createMessage().getMsgIen());
	request.setXmzrec("^XMB(3.9,\"_XMZ_\",0)");

	XMXUTIL2Inmsg2Response response = this.service.inmsg2(request);

	assertNotNull(response);
	System.out.println(response);
    }

    protected XMXAPIAddrNSndResponse createMessage() {

	XMXAPIAddrNSndRequest msgRequest = new XMXAPIAddrNSndRequest();

	ArrayList<String> msg = new ArrayList<String>();
	msg.add("LINE 1");
	msg.add("LINE 2");

	ArrayList<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry(".6", ""));

	String duz = "1";
	String xmDuz = "1";
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

	return msgService.addrNSnd(msgRequest);
    }
}
