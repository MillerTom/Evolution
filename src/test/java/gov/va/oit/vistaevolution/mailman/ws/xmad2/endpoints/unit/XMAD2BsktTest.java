package gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.XMAD2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.XMAD2BsktEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.XMAD2BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for BSKT method of XMAD2 Webservice
 */
public class XMAD2BsktTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMAD2BsktTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Pass in DUZ and an existing basket name and return the basket IEN.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XMDUZ=.6
	 * >S XMKN="WASTE"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=.5
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt001() throws VistaWebServiceFault {

		String expectedOutput = ".5";

		XMAD2BsktRequest request = new XMAD2BsktRequest();
		request.setXmduz(".6");
		request.setXmkn("WASTE");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMAD2BsktEndpoint service = new XMAD2BsktEndpointImpl(
				new XMAD2ResponseFactory(), getVistaLinkContext());

		XMAD2BsktResponse response = service.bskt(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Pass in a basket name of less than two characters and return an error
	 * message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=DUZ
	 * >S XMKN="A"
	 * 
	 * Procedure Call:
	 * >D BSKT^XMWSOA01(.RETURN,XMDUZ,XMKN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Must be |1|-|2| characters, no ^."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testBskt002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Must be |1|-|2| characters, no ^.";

		XMAD2BsktRequest request = new XMAD2BsktRequest();
		request.setXmduz(".6");
		request.setXmkn("A");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMAD2BsktEndpoint service = new XMAD2BsktEndpointImpl(
				new XMAD2ResponseFactory(), getVistaLinkContext());

		XMAD2BsktResponse response = service.bskt(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
