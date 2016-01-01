package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPILateMsgsEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPILateMsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class XMXAPILateMsgsTest extends VistaLinkContextTestParent {

	public XMXAPILateMsgsTest() {	}
	private XMXAPILateMsgsRequest request;

	@Before
	public void setUp() {
		request = new XMXAPILateMsgsRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmkza(new HashMap<Object, Object>());
		request.setXmInstr(new ArrayList<String>());
	}
	
	/**
	 * <em>Error DUZ is null</em>
	 * 
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

	 * </pre>
	 */
	@Test
	public void testDuzIsNull() throws VistaWebServiceFault {

		String expectedOutput = VistaConstants.ERR_MSG_IN_REQD_INPUT2;
		request.setDuz(null);
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("3141231");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		XMXAPILateMsgsEndpoint service = new XMXAPILateMsgsEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getErrors().get(0));

	}
	
	/**
	 * <em>Error XMDUZ is null</em>
	 * 
			Input Data:
			>K XMKZA
			>S DUZ=".5"
			>S XMDUZ=
			>S XMK=1
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
	public void testXmDuzIsNull() throws VistaWebServiceFault {

		String expectedOutput = VistaConstants.ERR_MSG_IN_REQD_INPUT2;
		request.setXmDuz(null);
		request.setXmk("1");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("3141231");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		XMXAPILateMsgsEndpoint service = new XMXAPILateMsgsEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getErrors().get(0));

	}
	
	
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

		String expectedOutput = "-1^Message 'XYZ' does not exist";
		
		request.setXmk("XYZ");
		request.getXmkza().put("1,2","");
		request.getXmInstr().add("3141231");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		XMXAPILateMsgsEndpoint service = new XMXAPILateMsgsEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPILateMsgsResponse response = service.LateMsgs(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getRawResponse());

	}

}
