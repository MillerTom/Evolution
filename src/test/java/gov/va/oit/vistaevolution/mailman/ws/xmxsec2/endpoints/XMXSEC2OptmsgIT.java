/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for OPTMSG method of XMXSEC2 Webservice
 */
public class XMXSEC2OptmsgIT extends VistaLinkContextITParent {

	@Autowired
	private XMXSEC2OptmsgEndpointImpl service;

	private XMXSEC2OptmsgRequest request;
	private XMXSEC2OptmsgResponse response;

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC2OptmsgIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. Set XMDUZ to null.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=""
	 * >S XMK=1
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTMSG^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544269449,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptmsg001() throws VistaWebServiceFault {

		request = new XMXSEC2OptmsgRequest("", "1", "100");

		response = service.optmsg(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Set XMK to null.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=83323
	 * >S XMK=""
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTMSG^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544269449,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptmsg002() throws VistaWebServiceFault {

		request = new XMXSEC2OptmsgRequest("83323", "", "100");

		response = service.optmsg(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Use an invalid user.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=999999
	 * >S XMK=1
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTMSG^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544269449,0)="-1^Not a valid user"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptmsg003() throws VistaWebServiceFault {

		request = new XMXSEC2OptmsgRequest("999999", "1", "100");

		response = service.optmsg(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Not a valid user", response.getMsgRoot().get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Return what the user can do with the message.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=.5
	 * >S XMK=1
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D OPTMSG^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544269449)"   *** Your $J value will be different
	 * 
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * Global ^TMP("XMLIST",$J
	 * ^TMP("XMLIST",544269449,"A")="XMOPT(""A"")=Answer"
	 * ^TMP("XMLIST",544269449,"A","?")="XMOPT(""A"",""?"")=You need 'send' privilege to Answer a message."
	 * ^TMP("XMLIST",544269449,"AA")="XMOPT(""AA"")=Access Attachments"
	 * ^TMP("XMLIST",544269449,"AA","?")="XMOPT(""AA"",""?"")=This message has no attachments."
	 * ^TMP("XMLIST",544269449,"B")="XMOPT(""B"")=Backup"
	 *                         "C")="XMOPT(""C"")=Copy"
	 * ^TMP("XMLIST",544269449,"C","?")="XMOPT(""C"",""?"")=You need 'send' privilege to Copy a message."
	 * ^TMP("XMLIST",544269449,"D")="XMOPT(""D"")=Delete"
	 *                         "E")="XMOPT(""E"")=Edit"
	 * ^TMP("XMLIST",544269449,"E","?")="XMOPT(""E"",""?"")=You need 'send' privilege to Edit a message."
	 * ^TMP("XMLIST",544269449,"F")="XMOPT(""F"")=Forward"
	 *                         "H")="XMOPT(""H"")=Headerless Print"
	 *                         "I")="XMOPT(""I"")=Ignore"
	 *                        "IN")="XMOPT(""IN"")=Information only"
	 * ^TMP("XMLIST",544269449,"IN","?")="XMOPT(""IN"",""?"")=Only the originator may toggle 'Information only'."
	 * ^TMP("XMLIST",544269449,"K")="XMOPT(""K"")=Priority replies"
	 * ^TMP("XMLIST",544269449,"K","?")="XMOPT(""K"",""?"")=The message must be 'priority' in order to toggle 'Priority replies'."
	 * ^TMP("XMLIST",544269449,"L")="XMOPT(""L"")=Later"                               
	 *                         "N")="XMOPT(""N"")=New"
	 *                         "P")="XMOPT(""P"")=Print"
	 *                         "Q")="XMOPT(""Q"")=Query"
	 *                        "QC")="XMOPT(""QC"")=Query Current"
	 *                        "QD")="XMOPT(""QD"")=Query Detailed"
	 *                        "QN")="XMOPT(""QN"")=Query Network"
	 *                       "QNC")="XMOPT(""QNC"")=Query Not Current"
	 *                        "QR")="XMOPT(""QR"")=Query Recipients"
	 *                        "QT")="XMOPT(""QT"")=Query Terminated"
	 *                         "R")="XMOPT(""R"")=Reply"
	 *                         "S")="XMOPT(""S"")=Save"
	 *                         "T")="XMOPT(""T"")=Terminate"
	 *                         "V")="XMOPT(""V"")=Vaporize date edit"
	 *                         "W")="XMOPT(""W"")=Write"
	 * ^TMP("XMLIST",544269449,"W","?")="XMOPT(""W"",""?"")=You need 'send' privilege to Write (send) a message."
	 * ^TMP("XMLIST",544269449,"X")="XMOPT(""X"")=Xtract"
	 * ^TMP("XMLIST",544269449,"X","?")="XMOPT(""X"",""?"")=This message is neither KIDS nor Packman."
	 * 
	 * </pre>
	 */
	@Test
	public void testOptmsg004() throws VistaWebServiceFault {

		request = new XMXSEC2OptmsgRequest(".5", "1", "100");

		response = service.optmsg(request);

		assertNotNull(response);
		if (response.getOptionsList() != null) {
			assertEquals("Access Attachments", response.getOptionsList().get(2));
		} else {
			fail("optionsList is NULL, Error Message Returned : "
					+ response.getMsgRoot().get(1));
		}
	}
}
