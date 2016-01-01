/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGMsgEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgRequest;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class DIALOGMsgIT extends VistaLinkContextITParent {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DIALOGMsgIT.class);

	private DIALOGMsgEndpoint service;
	private DIALOGMsgRequest request;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new DIALOGMsgEndpointImpl();
		request = new DIALOGMsgRequest(); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		service = null;
		request = null;
	}

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Write error text to screen and kill input array.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testMsg001() {
		
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Write help text to the screen and to a local array with formatting.
	 * </pre>
	 */
	@Ignore
	@Test
	public void testMsg002() {
		
	}

}