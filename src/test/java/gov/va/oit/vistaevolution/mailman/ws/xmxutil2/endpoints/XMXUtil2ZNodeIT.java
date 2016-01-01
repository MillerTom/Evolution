package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZNodeEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXUtil2ZNodeIT extends EvolutionIT<XMXUtil2ZNodeEndpoint> {
	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";
	private static Logger LOGGER = Logger.getLogger(XMXUtil2DateIT.class);
	
//	@Autowired
//	private XMXAPIAddrNSndEndpoint msgService;
//	
//	private TestMessageCreator msgCreator;
//	private XMXAPIAddrNSndResponse msgResponse = new XMXAPIAddrNSndResponse("123", "");
	
//	private boolean msgResponsePopulated = false;
	
//	private boolean initMailMessage() { 
//		msgCreator = new TestMessageCreator();
//		
//		if(msgCreator.createMailMessage(msgService,"Test Subject for XMXUtil2DateIT", "", null)) { 
//			this.msgResponsePopulated = msgCreator.isMsgResponsePopulated();
//			this.msgResponse = msgCreator.getMsgResponse();
//		}
//		return this.msgResponsePopulated;
//	}
	
	private ArrayList<String> message = null;

	public XMXUtil2ZNodeIT() {
		super();
	}

	@Before
	public void setUp() {
		message = new ArrayList<String>();
		message.add("Hello Dr. House");
		message.add("");
		message.add("This is a test to check if your e-mail is working.");
		message.add("Good bye.");

	}
	
	@After
	public void tearDown(){
		message = null;
	}
	
	@Autowired
	XMXUtil2ZNodeEndpoint service;
	
	
	/**
	 * 
	 * <em>Error.  Pass in null message IEN</em>
	 * <pre>
	 * 	Input Data:
		>S XMZ=""
		
		Procedure Call:
		>D ZNODE^XMWSOA07(.RETURN,XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN="-1^Error in required input"

	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNullMsgIen() throws VistaWebServiceFault {
		String expectedResponse = VistaConstants.ERR_MSG_INPUT_MISS.replace(VistaConstants.SRVNM, 
						XMXUtil2ZNodeEndpointImpl.MY_SERVICE);
		expectedResponse = expectedResponse.replace(VistaConstants.PARAM, "XMZ");
		
		XMXUtil2ZNodeRequest request = new XMXUtil2ZNodeRequest("");
		XMXUtil2ZNodeResponse response = service.ZNode(request);
		
		assertEquals(expectedResponse, response.getErrMsgs().get(0));
		
	}
	
	/**
	 * 
	 * <em>Error.  Pass is invalid message IEN</em>
	 * <pre>
	 * 	Input Data:
		>S XMZ=999999
		
		Procedure Call:
		>D ZNODE^XMWSOA07(.RETURN,XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN="-1^Message not found"

	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testInvalidMsgIen() throws VistaWebServiceFault {
		String expectedResponse = VistaConstants.ERR_MSG_NOT_FOUND;
		
		XMXUtil2ZNodeRequest request = new XMXUtil2ZNodeRequest("999999");
		XMXUtil2ZNodeResponse response = service.ZNode(request);
		
		assertEquals(expectedResponse, response.getErrMsgs().get(0));
		
	}
	
	/**
	 * 
	 * <em>Error.  Pass is invalid message IEN</em>
	 * <pre>
	 * 	Input Data:
		>S XMZ=0
		
		Procedure Call:
		>D ZNODE^XMWSOA07(.RETURN,XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN="-1^Message not found"

	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testMsgIENofZero() throws VistaWebServiceFault {
		String expectedResponse = VistaConstants.ERR_MSG_IN_REQD_INPUT2;
		
		XMXUtil2ZNodeRequest request = new XMXUtil2ZNodeRequest("0");
		XMXUtil2ZNodeResponse response = service.ZNode(request);
		
		assertEquals(expectedResponse, response.getErrMsgs().get(0));
		
	}
	
	/**
	 * 
	 * <em>Error.  Pass is invalid message IEN</em>
	 * <pre>
	 * 	Input Data:
		>S XMZ=0
		
		Procedure Call:
		>D ZNODE^XMWSOA07(.RETURN,XMZ)
		
		Expected Output:
		>ZW RETURN
		RETURN="-1^Message not found"

	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testVaidMsgIEN() throws VistaWebServiceFault {
//		if(initMailMessage()) { 
//			LOGGER.info("Successfully created new mail message for XMXUtil2^ZNode, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMXUtil2^ZNode");
//		}
		
//		XMXUtil2ZNodeRequest request = new XMXUtil2ZNodeRequest(msgResponse.getMsgIen());
//		XMXUtil2ZNodeResponse response = service.ZNode(request);
//		assertNull(response.getErrMsgs());
//		assertNotNull(response.getZeroNode());
		
	}

	@Override
	protected Class<XMXUtil2ZNodeEndpoint> getType() {
		return XMXUtil2ZNodeEndpoint.class;
	}
}
