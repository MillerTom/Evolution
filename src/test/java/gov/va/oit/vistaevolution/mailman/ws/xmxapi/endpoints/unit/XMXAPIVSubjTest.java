package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.XMXAPIVSubjEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVSubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIVSubjTest extends VistaLinkContextTestParent {

	private XMXAPIVSubjRequest request;

	@Before
	public void setUp() {
		request = new XMXAPIVSubjRequest();

		
	}

	/**
	 * <em>Successful subject message</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S X=”This is a test subject”
	 * 
	 * Procedure Call:
	 * >D D VSUBJ^XMWSOA08(.DATA,X)
	 * 
	 * Expected Output:
	 * >ZW DATA
	 * DATA="0^This is a test subject"
	 * </pre>
	 */
	@Test
	public void testSucessfulSubject() throws VistaWebServiceFault {

		String expectedOutput = "0^This is a test subject";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		request.setSubject("This is a test subject");

		XMXAPIVSubjEndpoint service = new XMXAPIVSubjEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPIVSubjResponse response = service.vsubj(request);

		assertNotNull(response);
		assertEquals(expectedOutput.split("\\^")[1], response.getResult());

	}
	
	/**
	 * <em>Return code for an empty subject</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S X=””
	 * 
	 * Procedure Call:
	 * >D D VSUBJ^XMWSOA08(.DATA,X)
	 * 
	 * Expected Output:
	 * >ZW DATA
	 * DATA="0^* No Subject *"
	 * </pre>
	 */
	@Test
	public void testEmptySubject() throws VistaWebServiceFault {

		String expectedOutput = "0^* No Subject *";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		request.setSubject("");

		XMXAPIVSubjEndpoint service = new XMXAPIVSubjEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPIVSubjResponse response = service.vsubj(request);

		assertNotNull(response);
		assertEquals(expectedOutput.split("\\^")[1], response.getResult());

	}
	
	/**
	 * <em>Return code for a subject with control characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S X=”Test Subject_$C(23)_$C(24)”
	 * 
	 * Procedure Call:
	 * >D D VSUBJ^XMWSOA08(.DATA,X)
	 * 
	 * Expected Output:
	 * >ZW DATA
	 * DATA="0^Test Subject"
	 * </pre>
	 */
	@Test
	public void testSubjectWithControlChars() throws VistaWebServiceFault {

		String expectedOutput = "0^Test Subject";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		request.setSubject("Test Subject_$C(23)_$C(24");

		XMXAPIVSubjEndpoint service = new XMXAPIVSubjEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPIVSubjResponse response = service.vsubj(request);

		assertNotNull(response);
		assertEquals(expectedOutput.split("\\^")[1], response.getResult());

	}

	/**
	 * <em>Return code for a subject with format Rnnn</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S X=”R123”
	 * 
	 * Procedure Call:
	 * >D D VSUBJ^XMWSOA08(.DATA,X)
	 * 
	 * Expected Output:
	 * >ZW DATA
	 * DATA="-1^Subject 'Rnnn' reserved."
	 * </pre>
	 */
	@Test
	public void testSubjectWithRnn() throws VistaWebServiceFault {

		String expectedOutput = "-1^Subject 'Rnnn' reserved.";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		request.setSubject("R123");

		XMXAPIVSubjEndpoint service = new XMXAPIVSubjEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPIVSubjResponse response = service.vsubj(request);

		assertNotNull(response);
		assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
		assertEquals(expectedOutput.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>Return code for a subject less than 3 characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S X=”AB”
	 * 
	 * Procedure Call:
	 * >D D VSUBJ^XMWSOA08(.DATA,X)
	 * 
	 * Expected Output:
	 * >ZW DATA
	 * DATA="="-1^Subject must be from 3 to 65 characters long."
	 * </pre>
	 */
	@Test
	public void testSubjectLowerLimit() throws VistaWebServiceFault {

		String expectedOutput = "-1^Subject must be from 3 to 65 characters long.";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		request.setSubject("AB");

		XMXAPIVSubjEndpoint service = new XMXAPIVSubjEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPIVSubjResponse response = service.vsubj(request);

		assertNotNull(response);
		assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
		assertEquals(expectedOutput.split("\\^")[1], response.getErrors().get(0));

	}
	
	/**
	 * <em>Return code for a subject Greater than 65 characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S $P(X,”A”,66)=”B”
	 * 
	 * Procedure Call:
	 * >D D VSUBJ^XMWSOA08(.DATA,X)
	 * 
	 * Expected Output:
	 * >ZW DATA
	 * DATA="="-1^Subject must be from 3 to 65 characters long."
	 * </pre>
	 */
	@Test
	public void testSubjectUpperLimit() throws VistaWebServiceFault {

		String expectedOutput = "-1^Subject must be from 3 to 65 characters long.";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedOutput);
		
		request.setSubject("$P(X,”A”,66)=B");

		XMXAPIVSubjEndpoint service = new XMXAPIVSubjEndpointImpl(new XMXAPIResponseFactory(), getVistaLinkContext());

		XMXAPIVSubjResponse response = service.vsubj(request);

		assertNotNull(response);
		assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
		assertEquals(expectedOutput.split("\\^")[1], response.getErrors().get(0));

	}


}
