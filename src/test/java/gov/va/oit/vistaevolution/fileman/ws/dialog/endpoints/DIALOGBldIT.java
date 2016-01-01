/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGBldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class DIALOGBldIT extends EvolutionIT<DIALOGBldEndpoint> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DIALOGBldIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Single parameter input.
	 * </pre>
	 */
	@Test
	public void testBld001() throws VistaWebServiceFault {
		DIALOGBldRequest request = new DIALOGBldRequest("101");
		
		DIALOGBldResponse response = service.bld(request);
		
		assertNotNull(response);
		assertEquals("Only those with programmer's access can perform this function.", response.getOutputArray().get(0));
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Single-value Input Parameter passed as a literal value; no output array
	 * </pre>
	 */
	@Test
	public void testBld002() {
		DIALOGBldRequest request = new DIALOGBldRequest();
		request.setDialogNum("201");
		List<String> textParam = new ArrayList<String>();
		textParam.add("MYVAR");
		request.setTextParam(textParam);
		request.setFlags("");
		request.setDir("");
		
		DIALOGBldResponse response = service.bld(request);
		
		assertNotNull(response);
		assertEquals("The input variable MYVAR is missing or invalid.", response.getOutputArray().get(0));
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Single parameter input passed in local variable; no output array. No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld003() {
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Single parameter input as array passed by reference w/ output to a local array and no special output formatting. No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld004() {
	}

	/**
	 * <em>Use Case #5</em>
	 * 
	 * <pre>
	 * Single parameter input as array passed by reference w/ flag specifying output to a local array formatted for ^TMP.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld005() {
		DIALOGBldRequest request = new DIALOGBldRequest();
		request.setDialogNum("201");
		List<String> textParam = new ArrayList<String>();
		textParam.add("MYVAR");
		request.setTextParam(textParam);
		request.setFlags("F");
		request.setDir("");
		
		DIALOGBldResponse response = service.bld(request);
		
		assertNotNull(response);
		assertEquals("The input variable MYVAR is missing or invalid.", response.getOutputArray().get(0));
	}

	/**
	 * <em>Use Case #6</em>
	 * 
	 * <pre>
	 * Multiple parameter input passed by reference w/ output to a local array and no special output formatting.
	 * </pre>
	 */
	@Test
	public void testBld006() {
		DIALOGBldRequest request = new DIALOGBldRequest();
		request.setDialogNum("330");
		List<String> textParam = new ArrayList<String>();
		textParam.add("DAFFODIL");
		textParam.add("TREE");
		request.setTextParam(textParam);
		request.setFlags("");
		request.setDir("");
		
		DIALOGBldResponse response = service.bld(request);
		
		assertNotNull(response);
		assertEquals("The value 'DAFFODIL' is not a valid TREE.", response.getOutputArray().get(0));
	}

	/**
	 * <em>Use Case #7</em>
	 * 
	 * <pre>
	 * Single-value Input Parameter passed as a literal value for a DIMSG (Type 2) Dialog; no output array. No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld007() {
	}

	/**
	 * <em>Use Case #8</em>
	 * 
	 * <pre>
	 * Simple call to a DIHELP (Type 3) Dialog – no input parameters, no output array.  No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld008() {
	}

	/**
	 * <em>Use Case #9</em>
	 * 
	 * <pre>
	 * Simple call to a DIHELP (Type 3) Dialog – Dialog number passed as a literal, no input parameters, no output array. No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld009() {
	}

	/**
	 * <em>Use Case #10</em>
	 * 
	 * <pre>
	 * Single-value Input Parameter passed as a literal value for a DIHELP (Type 3) Dialog; no output array. No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld010() {
	}

	/**
	 * <em>Use Case #11</em>
	 * 
	 * <pre>
	 * Single parameter input as array passed by reference w/ output to a local array formatted like ^TMP and output parameter specified for 2 values. No RPC test case.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testBld011() {
	}

	@Override
	protected Class<DIALOGBldEndpoint> getType() {
		return DIALOGBldEndpoint.class;
	}

}
