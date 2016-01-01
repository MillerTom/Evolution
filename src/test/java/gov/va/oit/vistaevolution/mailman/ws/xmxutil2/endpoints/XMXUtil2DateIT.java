package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2DateEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXUtil2DateIT extends VistaLinkContextITParent {
	private static final String ERR_MSG_NOT_POP = "Failed to populate a new mail message in VistA";
	private static Logger LOGGER = Logger.getLogger(XMXUtil2DateIT.class);
	private final SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
	final String TEST2_REGEX_FORMAT = "\\d{2}/\\d{2}/\\d{2}\\@\\d{2}:\\d{2}";
	
	@Autowired
	private XMXUtil2DateEndpoint service;
	
	private XMXUtil2DateRequest request;
	private XMXUtil2DateResponse response;
	public XMXUtil2DateIT() {
		super();
	}
	
//	@Autowired
//	private XMXAPIAddrNSndEndpoint msgService;
	
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
	
	/**
	 * <em>What is the message date? 
	 * 
	 *  Get Date only, no time component</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ=100
				>S XMTIME=0
				
				Procedure Call:
				>D DATE^XMWSOA06(.RETURN,XMZ,XMTIME)
				
				Expected Output:
				>ZW RETURN
				RETURN="01/25/09"


	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2Date001() throws VistaWebServiceFault {
		
//		if(initMailMessage()) { 
//			LOGGER.info("Successfully created new mail message for XMA2R^ENTA, IEN = " 
//					+ this.msgResponse.getMsgIen());
//		}else { 
//			LOGGER.error("Failed to create new mail message for XMA2R^ENTA");
//		}
//
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		}


//		Date d = new Date();
//		LOGGER.warn("\njtestXMXUtil2Date001 date d = " + df.format(d) +"\n") ;
//		String testResponse = df.format(d);
//		request = new XMXUtil2DateRequest(msgResponse.getMsgIen(), "0");
//
//		response = service.Date(request);		
//
//
//		assertNotNull(response);
//		assertEquals(testResponse, response.getMsgDate());	// assertEquals(null == input)

	}	// end test 1
	
	
	/**
	 * <em>What is the message date? 
	 * 
	 *  Get Date and time component</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ=100
				>S XMTIME=1
				
				Procedure Call:
				>D DATE^XMWSOA06(.RETURN,XMZ,XMTIME)
				
				Expected Output:
				>ZW RETURN
				RETURN="01/25/09@15:10:26"


	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2Date002() throws VistaWebServiceFault {
//		if(!this.msgResponsePopulated) { 
//			// try to populate, if we can't fail
//			if(!initMailMessage()) { 
//				fail(ERR_MSG_NOT_POP);
//			}
//		}
//		Date d = new Date();
//		LOGGER.warn("\njtestXMXUtil2Date001 date d = " + df.format(d) +"\n") ;
//		request = new XMXUtil2DateRequest(msgResponse.getMsgIen(), "1");
//
//		response = service.Date(request);		
//
//
//		assertNotNull(response);
//		assertTrue("date ok", response.getMsgDate().matches(TEST2_REGEX_FORMAT));
//
	}	// end test 1

	
	/**
	 * <em>What is the message date? 
	 * 
	 * Error.  Pass in Invalid Message IEN.</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ=999999
				>S XMTIME=1
				
				Procedure Call:
				>D DATE^XMWSOA06(.RETURN,XMZ,XMTIME)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Message not found"



	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2Date003() throws VistaWebServiceFault {
		String testResponse = VistaConstants.ERR_MSG_NOT_FOUND;	
		
		request = new XMXUtil2DateRequest("999999", "1");
		
		response = service.Date(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getMsgDate());	// assertEquals(null == input) 
	}	// end test 1
	
	/**
	 * <em>What is the message date? 
	 * 
	 * Error.  Pass in no msg IEN.</em>
	 * 
	 * 
	 * <pre>
				Input Data:
				>S XMZ=""
				>S XMTIME=1
				
				Procedure Call:
				>D DATE^XMWSOA06(.RETURN,XMZ,XMTIME)
				
				Expected Output:
				>ZW RETURN
				RETURN="-1^Error in required input"



	
	</pre>
	 */
	
	@Test
	public void jtestXMXUtil2Date004() throws VistaWebServiceFault {
		request = new XMXUtil2DateRequest("", "1");
		
		response = service.Date(request);		
		
		
		assertNotNull(response);
		assertEquals(VistaConstants.ERR_MSG_IN_REQD_INPUT2, response.getErrors().get(0));	// assertEquals(null == input) 
	}	// end test 1
}
