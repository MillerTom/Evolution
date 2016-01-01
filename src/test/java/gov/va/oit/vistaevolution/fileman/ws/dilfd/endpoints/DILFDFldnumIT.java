/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDFldnumEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class DILFDFldnumIT extends EvolutionIT<DILFDFldnumEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DILFDFldnumIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Top-level File reference
	 * </pre>
	 */
	@Test
	public void testFldnum001() throws VistaWebServiceFault {
		DILFDFldnumRequest request = new DILFDFldnumRequest("200", "DUZ(0)");
		
		DILFDFldnumResponse response = service.fldnum(request);
		
		LOGGER.debug("response: " + response.getReturnVal());
		
		assertNotNull(response);
		assertEquals("3", response.getReturnVal());
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Sub-file reference
	 * </pre>
	 */
	@Test
	public void testFldnum002() throws VistaWebServiceFault {
		DILFDFldnumRequest request = new DILFDFldnumRequest("8994.02", "INPUT PARAMETER");
		
		DILFDFldnumResponse response = service.fldnum(request);
		
		LOGGER.debug("response: " + response.getReturnVal());
		
		assertNotNull(response);
		assertEquals(".01", response.getReturnVal());
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Error code 401 – The file does not exist.
	 * </pre>
	 */
	@Test
	public void testFldnum003() throws VistaWebServiceFault {
		DILFDFldnumRequest request = new DILFDFldnumRequest("99999", "NAME");
		
		DILFDFldnumResponse response = service.fldnum(request);
		
		LOGGER.debug("response: " + response.getReturnVal());
		
		assertNotNull(response);
		assertEquals("0", response.getReturnVal());
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Error code 501 – The file does not contain the field.
	 * </pre>
	 */
	@Test
	public void testFldnum004() throws VistaWebServiceFault {
		DILFDFldnumRequest request = new DILFDFldnumRequest("200", "HOBBIES");
		
		DILFDFldnumResponse response = service.fldnum(request);
		
		LOGGER.debug("response: " + response.getReturnVal());
		
		assertNotNull(response);
		assertEquals("0", response.getReturnVal());
	}

	/**
	 * <em>Use Case #5</em>
	 * 
	 * <pre>
	 * Error code 505 – More than one field has the name
	 * Unable to reproduce, can’t find or create a file using Fileman with two fields having the same name.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testFldnum005() throws VistaWebServiceFault {
		
	}

	@Override
	protected Class<DILFDFldnumEndpoint> getType() {
		return DILFDFldnumEndpoint.class;
	}
}