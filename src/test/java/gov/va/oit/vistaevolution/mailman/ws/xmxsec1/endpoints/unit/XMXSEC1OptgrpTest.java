/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1OptgrpEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1OptgrpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for OPTGRP method of XMXSEC1 Webservice
 */
public class XMXSEC1OptgrpTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC1OptgrpTest() {
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
	 * 
	 * Procedure Call:
	 * >D OPTGRP^XMWSOA04(.RETURN,XMDUZ,XMK)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544233156)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544233156,0)="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptgrp001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Error in required input");

		String expectedOutput = "-1^Error in required input";

		XMXSEC1OptgrpRequest request = new XMXSEC1OptgrpRequest();
		request.setXmduz("");
		request.setXmk("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSEC1OptgrpEndpoint service = new XMXSEC1OptgrpEndpointImpl(
				getVistaLinkContext(), new XMXSEC1ResponseFactory());

		XMXSEC1OptgrpResponse response = service.optgrp(request);

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Use an invalid user.
	 * 
	 * <pre>
	 *   Input Data:
	 * >K ^TMP("XMLIST",$J)
	 * >S XMDUZ=999999
	 * >S XMK=1
	 * 
	 * Procedure Call:
	 * >D OPTGRP^XMWSOA04(.RETURN,XMDUZ,XMK)
	 * 
	 * Expected Output:	
	 * >ZW RETURN
	 * RETURN="^TMP(""XMLIST"",544233156)"   *** Your $J value will be different
	 * 
	 * 
	 * ***Notes:
	 * This is what’s stored in the global array ^TMP("XMLIST",$J).
	 * 
	 * ^TMP("XMLIST",544233156,0)="-1^Not a valid user"
	 * 
	 * </pre>
	 */
	@Test
	public void testOptgrp002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Not a valid user");

		String expectedOutput = "-1^Not a valid user";

		XMXSEC1OptgrpRequest request = new XMXSEC1OptgrpRequest();
		request.setXmduz("999999");
		request.setXmk("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSEC1OptgrpEndpoint service = new XMXSEC1OptgrpEndpointImpl(
				getVistaLinkContext(), new XMXSEC1ResponseFactory());

		XMXSEC1OptgrpResponse response = service.optgrp(request);

		assertNotNull(response);
		assertEquals(results.size(), response.getErrors().size());

	}
}
