/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIFwdMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/* 
 * XMWSOA FWDMSGM
 * 
 * This RPC forward messages by message number.
 * 
 * NOTE: Only the user or a surrogate can use this API.
 * 
 * 
 *  Input Parameters
 * 
 *  DUZ		(Required) String - User's DUZ
 *  XMDUZ   (Required) String -The user (DUZ or name) whose messages are to be forwarded.
 *  XMKZA   (Required) List - Identifies messages, using a list array of
 *  						  message numbers (xmz) in the MESSAGE file (#3.9) (xmk must not be
 *  						  specified and ranges are not allowed):
 *  
 *  							List array: ARRAY(1234567)=""
 *  				                        ARRAY(9763213)=""
 *  XMTO   (Required) List - Addressee or addressee array. If it is an array, it must be passed by reference
 *  
 *  						User's DUZ, or enough of user's name for a positive ID. For example:
 *  						     1301, "lastname,first", ARRAY(1301)="", or
 *  									ARRAY("lastname,first")=""
 *  						G.group name (enough for positive ID)
 *  						S.server name (enough for positive ID)
 *  						D.device name (enough for positive ID)
 *  							Prefix the above (except devices and servers) by:
 *  								I:-For "Information Only" recipient (cannot reply).
 *  							For example:
 *  								"I:1301" or
 *  								"I:lastname,first"
 *  						C:-For "copy" recipient (not expected to reply).
 *  							For example:
 *  								"C:1301" or
 *  								"C:lastname,first"
 *  						L@datetime:-For when (in future) to send to this recipient (datetime
 *  								can be anything accepted by VA FileMan).
 *  							For example:
 *  								"L@25 DEC@0500:1301" or
 *  								"L@1 JAN:lastname,first" or
 *  								"L@2981225.05:1301"
 *  								(Can combine IL@datetime: or CL@datetime:)
 *  
 *  					To delete recipients, prefix the recipients' name with a minus sign ("-").
 *  						For example:
 *  							-1301 or
 *  							"-lastname,first"
 *  
 *   					To address any recipient (including users, groups, devices, and
 *   							servers) at a remote site, just add the @site name.
 *   						For example:
 *   							recipient@site name
 *   
 *   
 *  XMINSTR   (Optional) List - Array of special instructions:
 *  
 *  ("ADDR FLAGS") Special addressing instructions, any or all of the
 * following:
 *   I-Do not Initialize (KILL) the ^TMP addressee global, because it already
  *   contains addressees for this message, as a result of a previous call to an
 *    API.
 *   R-Do not Restrict message addressing:
 *    Ignore "domain closed."
 *    Ignore "keys required for domain."
 *    Ignore "may not forward to domain."
 *    Ignore "may not forward priority mail to groups."
 *    Ignore "message length restrictions to remote addressees." 
 *   X-Do not create the ^TMP addressee global, because addressees are only
 *     being checked for validity.
 *   
 *  ("FWD BY") String saying who forwarded the message. The default
 * is user. This string is placed in the FORWARDED BY
 * field (#8) in the RECIPIENT Multiple field in the
 * MESSAGE file (#3.9). It must not be any real person, except for the
 * Postmaster. The DUZ is not captured in FORWARDED BY field (#8) ,
 * "FORWARDED BY (XMDUZ)" in the RECIPIENT Multiple field of the MESSAGE file
 * (#3.9)
 * VistA software.
 *   
 *  ("LATER") Date/time (any format understood by VA FileMan) on
 * which to send this message. The default is now.
 *   
 *  ("SELF BSKT") Basket to deliver to, 
 * if sender is recipient. The default is the "IN" basket. 
 *   
 *  ("SHARE BSKT")
 * Basket to deliver to if SHARED,MAIL is recipient. The default is the "IN"
 * basket. 
 *   
 *  ("SHARE DATE") Date/time (any format understood by VA FileMan) to
 * delete this message from SHARED,MAIL if SHARED,MAIL is the recipient.
 *  
 *  Returns (String):
 *  <number of messages> filtered or
 *  -1^[error text]
 * 
 */
public class XMXAPIFwdMsgIT extends EvolutionIT<XMXAPIFwdMsgEndpoint> {

	@Override
	protected Class<XMXAPIFwdMsgEndpoint> getType() {
		return XMXAPIFwdMsgEndpoint.class;
	}

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXAPIFwdMsgIT.class);

	private XMXAPIFwdMsgRequest request;
	private XMXAPIFwdMsgResponse response;

	@Before
	public void setUp() {
		request = new XMXAPIFwdMsgRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1
	 *
	 * Forward a message from DUZ .5 to DUZ .6
	 * 
	 * >S MSG(59118)="",TO(.6)=""
	 * >D FWDMSGM^XMWSOA03(.RESULT,.5,.5,.MSG,.TO)
	 * 
	 * >ZW RESULT
	 * RESULT="0^1 message forwarded."
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testFwdMsg001() throws VistaWebServiceFault {

		ArrayList <String>xmkzas = new ArrayList<String>();
		ArrayList <String>xmtos = new ArrayList<String>();
		ArrayList <String>xminstrs = new ArrayList<String>();
		
		request.setDuz(".5");
		request.setXmDuz(".5");
	
		xmkzas.add("59118");
		request.setXmkzas(xmkzas);
		
		xmtos.add(".6");
		request.setXmtos(xmtos);
		
		xminstrs.add("");
		request.setXminstrs(xminstrs);
		
		// Execute request against mocked object backend.
		response = service.fwdMsg(request);
	
		assertNotNull(response);
		assertEquals("0^1 message forwarded.", response.getResults());
	}

}
