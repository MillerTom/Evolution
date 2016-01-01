/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITDeliverEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverResponse;
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
public class XMXEDITDeliverIT extends VistaLinkContextITParent {

    @Autowired
    private XMXEDITDeliverEndpoint service;

    @Autowired
    private XMXAPIAddrNSndEndpoint msgService;

    @Test
    public void deliverTest001() {

	XMXEDITDeliverRequest request = new XMXEDITDeliverRequest();

	request.setXmz(this.createMessage().getMsgIen());
	request.setXmdbkst("COLTRAIN");

	XMXEDITDeliverResponse response = this.service.deliver(request);

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
	String xmSubj = "DELIVER BASKET ALL";
	String xmStrip = "";

	List<XMXAPIArrayEntry> xmInstr = Arrays.asList(new XMXAPIArrayEntry(
		"ADDR FLAGS", "S"));
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
