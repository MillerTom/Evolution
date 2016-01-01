package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPILateMsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8BsktEndpoint;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPILateMsgsIT extends EvolutionIT<XMXAPILateMsgsEndpoint> {
	 
	private static final Logger LOGGER = Logger.getLogger(XMXAPILateMsgsIT.class);

	private XMXAPILateMsgsRequest request;
	private String basketIen = "";
	private String mailMsgIen1 = "";
	private String mailMsgIen2 = "";
	private boolean mailMsg1MoveOK = false;
	private boolean mailMsg2MoveOK = false;
	
	
	@Override
	protected Class<XMXAPILateMsgsEndpoint> getType() {
		return XMXAPILateMsgsEndpoint.class;
	}
	
	@Before
    public void setUp() {
		request = new XMXAPILateMsgsRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmkza(new HashMap<Object, Object>());
		request.setXmInstr(new LinkedList<String>());
		createMailMessages();
		createMailBasket();
		moveMailMessages();
		
		
	}
	
	private void createMailBasket() { 
		XMXAPIBCre8BsktEndpoint service = null;
		try {
			service = getEndpointImpl(XMXAPIBCre8BsktEndpoint.class);
		} catch (Exception e) {
			LOGGER.error(this.getClass().toString() + ".createMailBasket(): failed to create XMXAPIBCre8BsktEndpoint");
			LOGGER.error(this.getClass().toString() + ".createMailBasket(): exception: " + e.getMessage() );
		}
		if(service != null) { 
			this.basketIen = MailUtils.createMailBasket("ZZ_LATEMSGSTEST", service);
			LOGGER.info("XMXAPILateMsgsIT.createMailBasket() new basket ien  = " + this.basketIen);
			
		}else { 
			LOGGER.error("Service was null");
		}
		
	}
	
	
	private void createMailMessages() { 
		XMDEndpoint service = null;
		try {
			service = getEndpointImpl(XMDEndpoint.class);
		} catch (Exception e) {
			LOGGER.error(this.getClass().toString() + ".createMailMessages(): failed to create XMDEndpoint");
			LOGGER.error(this.getClass().toString() + ".createMailMessages(): exception: " + e.getMessage() );
		}
		if(service != null) { 
			this.mailMsgIen1 = MailUtils.createMailMessage(service, null, null, null);
			this.mailMsgIen2 = MailUtils.createMailMessage(service, null, null, null);
			LOGGER.info("XMXAPILateMsgsIT new ien msg 1 = " + this.mailMsgIen1);
			LOGGER.info("XMXAPILateMsgsIT new ien msg 2 = " + this.mailMsgIen2);
		}else { 
			LOGGER.error("Service was null");
		}
	}
	
	private void moveMailMessages() { 
		XMA1BS2Endpoint service = null;
		try {
			service = getEndpointImpl(XMA1BS2Endpoint.class);
		} catch (Exception e) {
			LOGGER.error(this.getClass().toString() + ".moveMailMessages(): failed to create XMDEndpoint");
			LOGGER.error(this.getClass().toString() + ".moveMailMessages(): exception: " + e.getMessage() );
		}
		if(service != null) { 
			LOGGER.info(this.getClass().toString() + ".moveMailMessages():  new ien msg 1 = " + this.mailMsgIen1);
			this.mailMsg1MoveOK = MailUtils.moveMessageToABasket(service, null, this.basketIen, this.mailMsgIen1).startsWith("0")  ? true : false;
			this.mailMsg2MoveOK =  MailUtils.moveMessageToABasket(service, null, this.basketIen, this.mailMsgIen2).startsWith("0") ? true :false;
			LOGGER.info("XMXAPILateMsgsIT new ien msg 1 = " + this.mailMsgIen1);
			LOGGER.info("XMXAPILateMsgsIT new ien msg 2 = " + this.mailMsgIen2);
		}else { 
			LOGGER.error("Service was null");
		}
		
	}
	
	
	/**
	 * <em>This RPC "Laters" messages in a basket.</em>
	 * 
	 * 		Returns:
			<number of messages> latered
			-1^[error text]



	 * 
	 * <b>Error.  DUZ is null.</b>
	 * 
	 * <pre>
				Input Data:
				>K XMKZA
				>S DUZ=""
				>S XMDUZ=.5
				>S XMK=1
				>S XMKZA("1,2")=""
				>S XMINSTR=3141231
				
				Procedure Call:
				>D LATEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMINSTR)
				
				Expected Output:
				>ZW RETURN
				RETURN(1)="ERROR,-1^Error in required input"

	</pre>
	 */
	@Test
	public void testDuzIsNull() {
		String testResponse = VistaConstants.ERR_MSG_IN_REQD_INPUT2; 	
		
		request.setDuz(null);
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("3141231");
		
		XMXAPILateMsgsResponse response = service.LateMsgs(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
	 
	
	/* 
	 * <b>Error.  XMDUZ is null.</b>
	 * 
	 * <pre>
				Input Data:
				>K XMKZA
				>S DUZ=".5"
				>S XMDUZ=""
				>S XMK=1
				>S XMKZA("1,2")=""
				>S XMINSTR=3141231
				
				Procedure Call:
				>D LATEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMINSTR)
				
				Expected Output:
				>ZW RETURN
				RETURN(1)="ERROR,-1^Error in required input"

	</pre>
	 */
	@Test
	public void testXmDuzIsNull() {
		String testResponse = VistaConstants.ERR_MSG_IN_REQD_INPUT2; 	
		
		request.setXmDuz(null);
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("3141231");
		
		XMXAPILateMsgsResponse response = service.LateMsgs(request);		
		
		
		assertNotNull(response);
		assertEquals(testResponse, response.getErrors().get(0));	 
	}	// end test 
	
	/**
	 * <em>Error Basket does not exist</em>
	 * 
			Input Data:
			>K XMKZA
			>S DUZ=".5"
			>S XMDUZ=".5"
			>S XMK=XYZ
			>S XMKZA("1,2")=""
			>S XMINSTR=3141231
			
			Procedure Call:
			>D LATEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMINSTR)
			
			Expected Output:
			>ZW RETURN
			RETURN(1)="ERROR,-1^Error in required input"

	 * </pre>
	 */
	@Test
	public void testBasketDoesNotExist() throws VistaWebServiceFault {

		String expectedOutput = "-1^Basket 'XYZ' not found.";
		
		request.setXmk("XYZ");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("4/24/24");
		
		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getErrors().get(0));

	}
	
	/**
	 * <em>Test null later date</em>
	 * 
			Input Data:
			>K XMKZA
			>S DUZ=".5"
			>S XMDUZ=".5"
			>S XMK=1
			>S XMKZA("1,2")=""
			>S XMINSTR=""
			
			Procedure Call:
			>D LATEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMINSTR)
			
			Expected Output:
			>ZW RETURN
			RETURN(1)="ERROR,-1^Error in required input"

	 * </pre>
	 */
	@Test
	public void testNullLaterDate() throws VistaWebServiceFault {

		String expectedOutput = "-1^Later date must be supplied.";
		
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("");
		
		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getErrors().get(0));

	}
	
	/**
	 * <em>Test later date is in the past</em>
	 * 
			Input Data:
			>K XMKZA
			>S DUZ=".5"
			>S XMDUZ=".5"
			>S XMK=1
			>S XMKZA("1,2")=""
			>S XMINSTR="4/24/1980"
			
			Procedure Call:
			>D LATEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMINSTR)
			
			Expected Output:
			>ZW RETURN
			RETURN(1)="ERROR,-1^Error in required input"

	 * </pre>
	 */
	@Test
	public void testLaterDateIsInThePast() throws VistaWebServiceFault {

		String expectedOutput = "-1^Must be a date in the future.";
		
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("4/24/1980");
		
		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getErrors().get(0));

	}
	
	/**
	 * <em>Test valid move</em>
	 * 
			Input Data:
			>K XMKZA
			>S DUZ=".5"
			>S XMDUZ=".5"
			>S XMK=1
			>S XMKZA("1,2")=""
			>S XMINSTR="4/24/2080"
			
			Procedure Call:
			>D LATEMSGS^XMWSOA03(.RETURN,DUZ,XMDUZ,XMK,.XMKZA,XMINSTR)
			
			Expected Output:
			>ZW RETURN
			RETURN(1)="ERROR,-1^Error in required input"

	 * </pre>
	 */
	@Test
	public void testValidMsgMove() throws VistaWebServiceFault {

		String expectedOutput = "0^2 messages latered.";
		
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("4/24/2080");
		
		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getMoveResults());

	}

}
