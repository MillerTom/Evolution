/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDRootEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class DILFDRootIT extends EvolutionIT<DILFDRootEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DILFDRootIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Top-level File reference
	 * </pre>
	 */
	@Test
	public void testRoot001() throws VistaWebServiceFault {
		DILFDRootRequest request = new DILFDRootRequest("5", "");
		
		DILFDRootResponse response = service.root(request);
		
		LOGGER.debug("global name: " + response.getGlbName());
		
		assertNotNull(response);
		assertEquals(response.getGlbName(), "^DIC(5,");
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Sub-file reference
	 * </pre>
	 */
	@Test
	public void testRoot002() {
		DILFDRootRequest request = new DILFDRootRequest("5.01", "1,51,");
		
		DILFDRootResponse response = service.root(request);
		
		LOGGER.debug("global name: " + response.getGlbName());
		
		assertNotNull(response);
		assertEquals(response.getGlbName(), "^DIC(5,51,1,");
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Top-level file reference w/ closed root
	 * </pre>
	 */
	@Test
	public void testRoot003() {
		DILFDRootRequest request = new DILFDRootRequest("5", "", "1", "");
		
		DILFDRootResponse response = service.root(request);
		
		LOGGER.debug("global name: " + response.getGlbName());
		
		assertNotNull(response);
		assertEquals(response.getGlbName(), "^DIC(5,"); // not the expected result
		
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Sub-file reference w/ closed root
	 * </pre>
	 */
	@Test
	public void testRoot004() {
		DILFDRootRequest request = new DILFDRootRequest("5.01", "1,51,", "1", "");
		
		DILFDRootResponse response = service.root(request);
		
		LOGGER.debug("global name: " + response.getGlbName());
		
		assertNotNull(response);
		assertEquals(response.getGlbName(), "^DIC(5,51,1,"); // not the expected result
	}

	/**
	 * <em>Use Case #5</em>
	 * 
	 * <pre>
	 * Error code 200
	 * </pre>
	 */
	@Test
	public void testRoot005() {
		DILFDRootRequest request = new DILFDRootRequest("99999", "", "", "1");
		
		DILFDRootResponse response = service.root(request);
		
		LOGGER.debug("global name: " + response.getGlbName());
		
		assertNotNull(response);
		assertEquals(response.getGlbName(), "");
	}

	/**
	 * <em>Use Case #6</em>
	 * 
	 * <pre>
	 * Error code 205 - No RPC test case defined
	 * </pre>
	 */
	@Ignore
	@Test
	public void testRoot006() {
		
	}

	@Override
	protected Class<DILFDRootEndpoint> getType() {
		return DILFDRootEndpoint.class;
	}
}