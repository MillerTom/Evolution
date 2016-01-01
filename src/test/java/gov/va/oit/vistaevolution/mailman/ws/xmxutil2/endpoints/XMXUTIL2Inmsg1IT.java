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
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Response;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 * 
 */
public class XMXUTIL2Inmsg1IT extends VistaLinkContextITParent {

    @Autowired
    private XMXUTIL2Inmsg1Endpoint service;

    @Autowired
    private XMXAPIAddrNSndEndpoint msgService;

    /**
     * <em>Test Case 1</em>
     * 
     * <pre>
     * 
     * Test Case 1 (RPC): -1 Error in required input
     * Create, address, and send message
     * >S XMDUZ=DUZ,XMSUBJ="INFO TOGGLE TEST",MSG(1)="LINE 1"
     * >S MSG(2)="LINE 2",XMSTRIP="",XMINSTR="I",XMTO(.6)=""
     * >D ADDRNSND^XMWSOA03(.RET,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,XMINSTR)
     * >ZW RET
     * RET="0^74457" - Dynamic IEN
     * 
     * RPC w/ invalid input
     * >S XMDUZ="",XMZ=74457
     * >D INMSG1^XMWSOA04(.RETURN,XMDUZ,XMZ)
     * >ZW RETURN
     * RETURN="^TMP(""XMLIST"",3580)" - ien is dynamic
     * 
     * >D ^%G
     * Device:
     * Right margin: 80 =>
     * Screen size for paging (0=nopaging)? 24 =>
     * For help on global specifications DO HELP^%G
     * Global ^TMP("XMLIST",$J
     * ^TMP("XMLIST",3580,0)="-1^Error in required input" - expected result
     * 
     * </pre>
     */
    @Test
    public void inmsg001() {

	XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();

	request.setXmduz(".6");
	request.setXmz("");

	XMXUTIL2Inmsg1Response response = this.service.inmsg1(request);

	assertNotNull(response);
	assertEquals("-1", response.getStatus());
	assertEquals("Error in required input", response.getMessage());
    }

    /**
     * <em>Test Case 2</em>
     * 
     * <pre>
     * 
     * Test Case 2 (RPC): RPC w/ valid input
     * 
     * Create, address, and send message
     * >S XMDUZ=DUZ,XMSUBJ="INFO TOGGLE TEST",MSG(1)="LINE 1"
     * >S MSG(2)="LINE 2",XMSTRIP="",XMINSTR="I",XMTO(.6)=""
     * >D ADDRNSND^XMWSOA03(.RET,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,XMINSTR)
     * >ZW RET
     * RET="0^74457" Dynamic IEN
     * 
     * Get message information
     * >S XMDUZ=.6,XMZ=$P(RET,U,2)
     * >D INMSG1^XMWSOA04(.RETURN,XMDUZ,XMZ)
     * >ZW RETURN
     * RETURN="^TMP(""XMLIST"",3580)"
     * >D ^%G
     * Global ^TMP("XMLIST",$J
     * ^TMP("XMLIST",3580,"XMIM","CRE8")="XMIM(""CRE8"")=3140306"
     *                        "CRE8 MM")="XMIM(""CRE8 MM"")=03/06/14"
     *                          "DATE")="XMIM(""DATE"")=3140306.132013"
     *                          TE MM")="XMIM(""DATE MM"")=03/06/14@13:20"
     *                          "FROM")="XMIM(""FROM"")=1"
     *                      "FROM DUZ")="XMIM(""FROM DUZ"")=1"
     *                     "FROM NAME")="XMIM(""FROM NAME"")=PROGRAMMER,ONE"
     *                         "LINES")="XMIM(""LINES"")=2"
     *                         "RESPS")="XMIM(""RESPS"")=0"
     *                         "SENDR")="XMIM(""SENDR"")="
     *                          "SUBJ")="XMIM(""SUBJ"")=DELIVER BASKET ALL"
     *                           "XMZ")="XMIM(""XMZ"")=74457"
     *                           ^TMP("XMLIST",3580,"XMIU","IEN")="XMIU(""IEN"")=2"
     *                                                    
     *                         "RESP")="XMIU(""RESP"")="
     * 
     * </pre>
     */
    @Test
    public void inmsg002() {

	XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();

	request.setXmduz(".6");
	request.setXmz(this.createMessage().getMsgIen());

	XMXUTIL2Inmsg1Response response = this.service.inmsg1(request);

	assertNotNull(response);
	System.out.println(response);
    }

    /**
     * \ <em>Test Case 3</em>
     * 
     * <pre>
     * 
     * Test Case 3 (RPC): RPC w/ valid input w/ optional flag “I” set
     * Create, address, and send message
     * >S XMDUZ=DUZ,XMSUBJ="INFO TOGGLE TEST",MSG(1)="LINE 1"
     * >S MSG(2)="LINE 2",XMSTRIP="",XMINSTR="I",XMTO(.6)=""
     * >D ADDRNSND^XMWSOA03(.RET,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,XMINSTR)
     * >ZW RET
     * RET="0^74457" Dynamic IEN
     * 
     * Get message information
     * >S XMDUZ=.6,XMZ=$P(RET,U,2),XMFLAGS=”I”
     * >D INMSG1^XMWSOA04(.RETURN,XMDUZ,XMZ,,XMFLAGS)
     * >ZW RETURN
     * RETURN="^TMP(""XMLIST"",3580)"
     * >D ^%G
     * Global ^TMP("XMLIST",$J
     * ^TMP("XMLIST",3580,"XMIM","CRE8")="XMIM(""CRE8"")=3140306"
     *                    "DATE")="XMIM(""DATE"")=3140306.132013"
     *                    "FROM")="XMIM(""FROM"")=1"
     *                    LINES")="XMIM(""LINES"")=2"
     *                    RESPS")="XMIM(""RESPS"")=0"
     *                    SENDR")="XMIM(""SENDR"")="
     *                    "SUBJ")="XMIM(""SUBJ"")=DELIVER BASKET ALL"
     *                     "XMZ")="XMIM(""XMZ"")=74457"
     *                     
     *                     ^TMP("XMLIST",3580,"XMIU","IEN")="XMIU(""IEN"")=2"
     *                     
     *                   "RESP")="XMIU(""RESP"")="
     * 
     * </pre>
     */
    @Test
    public void inmsg003() {

	XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();

	request.setXmduz(".6");
	request.setXmz(this.createMessage().getMsgIen());
	request.setXmflags("I");

	XMXUTIL2Inmsg1Response response = this.service.inmsg1(request);

	assertNotNull(response);
	System.out.println(response);
    }

    /**
     * <em>Test Case 3</em>
     * 
     * <pre>
     * Test Case 4 (RPC): RPC w/ valid input w/ optional flag “F” set
     * 
     * Create, address, and send message
     * >S XMDUZ=DUZ,XMSUBJ="INFO TOGGLE TEST",MSG(1)="LINE 1"
     * >S MSG(2)="LINE 2",XMSTRIP="",XMINSTR="I",XMTO(.6)=""
     * >D ADDRNSND^XMWSOA03(.RET,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,XMINSTR)
     * >ZW RET
     * RET="0^74457" Dynamic IEN
     * 
     * Get message information
     * >S XMDUZ=.6,XMZ=$P(RET,U,2),XMFLAGS=”F”
     * >D INMSG1^XMWSOA04(.RETURN,XMDUZ,XMZ,,XMFLAGS)
     * >ZW RETURN
     * RETURN="^TMP(""XMLIST"",3580)"
     * >D ^%GGlobal ^TMP("XMLIST",$J
     * 
     * ^TMP("XMLIST",3580,"XMIM","CRE8")="XMIM(""CRE8"")=3140306"
     *                           "DATE")="XMIM(""DATE"")=3140306.132013"
     *                           "DATE FM")="XMIM(""DATE FM"")=3140306.132013"
     *                              "FROM")="XMIM(""FROM"")=1"
     *                          "FROM DUZ")="XMIM(""FROM DUZ"")=1"
     *                         "FROM NAME")="XMIM(""FROM NAME"")=PROGRAMMER,ONE"
     *                             "LINES")="XMIM(""LINES"")=2"
     *                             "RESPS")="XMIM(""RESPS"")=0"
     *                             "SENDR")="XMIM(""SENDR"")="
     *                              "SUBJ")="XMIM(""SUBJ"")=DELIVER BASKET ALL"
     *                               "XMZ")="XMIM(""XMZ"")=74457"
     *                               
     *                               ^TMP("XMLIST",3580,"XMIU","IEN")="XMIU(""IEN"")=2"
     *                               
     *                               "RESP")="XMIU(""RESP"")="
     * </pre>
     */
    @Test
    public void inmsg004() {

	XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();

	request.setXmduz(".6");
	request.setXmz(this.createMessage().getMsgIen());
	request.setXmflags("F");

	XMXUTIL2Inmsg1Response response = this.service.inmsg1(request);

	assertNotNull(response);
	System.out.println(response);
    }

    /**
     * 
     * <em>Test Case 5</em>
     * 
     * <pre>
     * Test Case 5 (RPC): RPC w/ valid input w/ optional XMZREC
     * Create, address, and send message
     * >S XMDUZ=DUZ,XMSUBJ="INFO TOGGLE TEST",MSG(1)="LINE 1"
     * >S MSG(2)="LINE 2",XMSTRIP="",XMINSTR="I",XMTO(.6)=""
     * >D ADDRNSND^XMWSOA03(.RET,DUZ,XMDUZ,XMSUBJ,.MSG,XMSTRIP,.XMTO,XMINSTR)
     * >ZW RET
     * RET="0^74457" Dynamic IEN
     * 
     * Get message information
     * >S XMDUZ=.6,XMZ=$P(RET,U,2)
     * >S XMZREC="^XMB(3.9,"_XMZ_",0)"
     * >D INMSG1^XMWSOA04(.RETURN,XMDUZ,XMZ,XMZREC)
     * >ZW RETURN
     * RETURN="^TMP(""XMLIST"",3580)"
     * 
     * EVOLUTION>D ^%G
     * Global ^TMP("XMLIST",$J
     * ^TMP("XMLIST",3580,"XMIM","CRE8")="XMIM(""CRE8"")=3140306"
     *                   "CRE8 MM")="XMIM(""CRE8 MM"")=03/06/14"
     *                      "DATE")="XMIM(""DATE"")="
     *                   "DATE MM")="XMIM(""DATE MM"")="
     *                      "FROM")="XMIM(""FROM"")=XMB(3.9,74457,0)"
     *                 "FROM NAME")="XMIM(""FROM NAME"")=XMB(3.9,74457,0)"
     *                     "LINES")="XMIM(""LINES"")=2"
     *                     "RESPS")="XMIM(""RESPS"")=0"
     *                     "SENDR")="XMIM(""SENDR"")="
     *                      "SUBJ")="XMIM(""SUBJ"")=* No Subject *"
     *                       "XMZ")="XMIM(""XMZ"")=74457"
     *                       
     *                       ^TMP("XMLIST",3580,"XMIU","IEN")="XMIU(""IEN"")=2"
     * 
     * "RESP")="XMIU(""RESP"")="
     */
    @Ignore
    @Test
    public void inmsg005() {

	XMXUTIL2Inmsg1Request request = new XMXUTIL2Inmsg1Request();

	request.setXmduz(".6");
	request.setXmz(this.createMessage().getMsgIen());
	request.setXmzrec(""); // Need proper value

	XMXUTIL2Inmsg1Response response = this.service.inmsg1(request);

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
