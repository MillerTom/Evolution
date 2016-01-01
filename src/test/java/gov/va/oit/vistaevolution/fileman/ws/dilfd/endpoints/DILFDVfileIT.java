/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfileEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class DILFDVfileIT extends EvolutionIT<DILFDVfileEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(DILFDVfileIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Top-level File w/ valid field
	 * </pre>
	 */
	@Test
	public void testVfile001() throws VistaWebServiceFault {
		DILFDVfileRequest request = new DILFDVfileRequest("5");
		
		DILFDVfileResponse response = service.vfile(request);
		
		LOGGER.debug("file exists: " + response.getFileExists());
		
		assertNotNull(response);
		assertEquals("1", response.getFileExists());
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Sub-file valid
	 * </pre>
	 */
	@Test
	public void testVfile002() throws VistaWebServiceFault {
		DILFDVfileRequest request = new DILFDVfileRequest("5.01");
		
		DILFDVfileResponse response = service.vfile(request);
		
		LOGGER.debug("file exists: " + response.getFileExists());
		
		assertNotNull(response);
		assertEquals("1", response.getFileExists());
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Invalid file
	 * </pre>
	 */
	@Test
	public void testVfile003() throws VistaWebServiceFault {
		DILFDVfileRequest request = new DILFDVfileRequest("5.03");
		
		DILFDVfileResponse response = service.vfile(request);
		
		LOGGER.debug("file exists: " + response.getFileExists());
		
		assertNotNull(response);
		assertEquals("0", response.getFileExists());
	}

	@Override
	protected Class<DILFDVfileEndpoint> getType() {
		return DILFDVfileEndpoint.class;
	}
}