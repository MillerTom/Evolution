/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfieldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class DILFDVfieldIT extends EvolutionIT<DILFDVfieldEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DILFDVfieldIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Top-level File w/ valid field
	 * </pre>
	 */
	@Test
	public void testVfield001() throws VistaWebServiceFault {
		DILFDVfieldRequest request = new DILFDVfieldRequest("5", ".01");
		
		DILFDVfieldResponse response = service.vfield(request);
		
		LOGGER.debug("field exists: " + response.getFieldExists());
		
		assertNotNull(response);
		assertEquals("1", response.getFieldExists());
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Sub-file  w/ valid field
	 * </pre>
	 */
	@Test
	public void testVfield002() throws VistaWebServiceFault {
		DILFDVfieldRequest request = new DILFDVfieldRequest("5.01", "4");
		
		DILFDVfieldResponse response = service.vfield(request);
		
		LOGGER.debug("field exists: " + response.getFieldExists());
		
		assertNotNull(response);
		assertEquals("1", response.getFieldExists());
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Top-level file w/ invalid field
	 * </pre>
	 */
	@Test
	public void testVfield003() throws VistaWebServiceFault {
		DILFDVfieldRequest request = new DILFDVfieldRequest("5", "4");
		
		DILFDVfieldResponse response = service.vfield(request);
		
		LOGGER.debug("field exists: " + response.getFieldExists());
		
		assertNotNull(response);
		assertEquals("0", response.getFieldExists());
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Sub-file w/ invalid field
	 * </pre>
	 */
	@Test
	public void testVfield004() throws VistaWebServiceFault {
		DILFDVfieldRequest request = new DILFDVfieldRequest("5.01", "6");
		
		DILFDVfieldResponse response = service.vfield(request);
		
		LOGGER.debug("field exists: " + response.getFieldExists());
		
		assertNotNull(response);
		assertEquals("0", response.getFieldExists());
	}

	@Override
	protected Class<DILFDVfieldEndpoint> getType() {
		return DILFDVfieldEndpoint.class;
	}
}