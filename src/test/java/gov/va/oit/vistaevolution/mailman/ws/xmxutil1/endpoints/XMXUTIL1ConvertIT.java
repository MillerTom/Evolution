package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ConvertEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XMXUTIL1ConvertIT extends VistaLinkContextITParent {

	@Autowired
	private XMXUTIL1ConvertEndpoint service;
	
	private XMXUTIL1ConvertRequest request;
	private XMXUTIL1ConvertResponse response;
	
	public XMXUTIL1ConvertIT() {
		
	}
	
	
	/**
	 * <em>Function to convert Internet dates to FM (returns -1 if error)
	 * 
	 *  Test a date string, return only date, no Time params with no control characters!</em>
	 *  Vars: 
	 *  X         Internet date
  	 *	XMTIME    =1 Convert time, too; =0 convert date only
	 * 
	 * <pre>
				Input Data:
				>Set x="23 May 2011 13:35:33 -0500 (EST)"
				>Set xmtime="0"
				
				Procedure Call:
				
				>S DATA=$$Convert^XMXUTIL1(X, XMTIME)
				
				Expected Output:
				>ZW RETURN
				RETURN=3110523


	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1Convert001() throws VistaWebServiceFault {
		String testResponse = "3110523";	// this is the correct response, no time component
		String dateTime2Convert = "23 May 2011 13:35:33 -0500 (EST)";
		String convertTime = "0";
		request = new XMXUTIL1ConvertRequest(dateTime2Convert, convertTime);
		
		response = service.Convert(request);		
		
		System.out.println(response.getFormattedDate());
		assertNotNull(response);
		assertEquals(testResponse, response.getFormattedDate());	// assertEquals(null == input) 
	}	// end test 1

	
	/**
	 * <em>Function to convert Internet dates to FM (returns -1 if error)
	 * 
	 *  Test a date string, return only date, no Time params with no control characters!</em>
	 *  Vars: 
	 *  X         Internet date
  	 *	XMTIME    =1 Convert time, too; =0 convert date only
	 * 
	 * <pre>
				Input Data:
				>Set x="23 May 2011 13:35:33 -0500 (EST)"
				>Set xmtime="1"
				
				Procedure Call:
				
				>S DATA=$$Convert^XMXUTIL1(X, XMTIME)
				
				Expected Output:
				
				Expected Output:
				>ZW RETURN
				RETURN=3110523.1335


	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1Convert002() throws VistaWebServiceFault {
		String testResponse = "3110523.1335";	
		String dateTime2Convert = "23 May 2011 13:35:33 -0500 (EST)";
		String convertTime = "1";
		request = new XMXUTIL1ConvertRequest(dateTime2Convert, convertTime);
		
		response = service.Convert(request);		
		
		System.out.println(response.getFormattedDate());
		assertNotNull(response);
		assertEquals(testResponse, response.getFormattedDate());	// assertEquals(null == input) 
	}	// end test 2

	
	/**
	 * <em>Function to convert Internet dates to FM (returns -1 if error)
	 * 
	 *  Test a date string, return only date, no Time params with no control characters!</em>
	 *  Vars: 
	 *  X         Internet date
  	 *	XMTIME    =1 Convert time, too; =0 convert date only
	 * 
	 * <pre>
				Input Data:
				>S XMDATE="123 May 2011 13:35:33 -0500 (EST)"
				>S XMTIME=1
				
				Procedure Call:
				>D INT2FM^XMWSOA06(.RETURN,XMDATE,XMTIME)
				
				Expected Output:
				>ZW RETURN
				RETURN=-1


	
	</pre>
	 */
	
	@Test
	public void jtestXMXUTIL1Convert003() throws VistaWebServiceFault {
		String testResponse = "-1";	
		String dateTime2Convert = "123 May 2011 13:35:33 -0500 (EST)";
		String convertTime = "1";
		request = new XMXUTIL1ConvertRequest(dateTime2Convert, convertTime);
		
		response = service.Convert(request);		
		
		System.out.println(response.getFormattedDate());
		assertNotNull(response);
		assertEquals(testResponse, response.getFormattedDate());	// assertEquals(null == input) 
	}	// end test 2
}
