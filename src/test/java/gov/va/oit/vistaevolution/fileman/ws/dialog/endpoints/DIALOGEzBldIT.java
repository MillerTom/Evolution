/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces.DIALOGEzBldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class DIALOGEzBldIT extends VistaLinkContextITParent {


    @Autowired
	private DIALOGEzBldEndpoint service;
    
	private DIALOGEzBldRequest request;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		request = new DIALOGEzBldRequest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		request = null;
	}

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Test Case 1 (RPC): IEN input only
	 * >S DDR("DIALOG")=110
	 * >D EZBLDR^DDR5(.DATA,.DDR)
	 * >ZW DATA
	 *  DATA="The record is currently locked."
	 * </pre>
	 */
	@Test
	public void testEzbld001() {
	    
	    this.request.setDialog("110");
	    this.request.setText(null);
	    DIALOGEzBldResponse response = this.service.ezbld(request);
	    
	    assertNotNull(response);
	    assertEquals("The record is currently locked.", response.getResponse());
	    		
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Test Case 2 (RPC): IEN input, plus single parameter passed as literal
	 * >S DDR("DIALOG")=201,DDR("TEXT")="PARAM"
	 * >D EZBLDR^DDR5(.DATA,.DDR)
	 * >ZW DATA
	 * DATA="The input variable PARAM is missing or invalid."
	 * </pre>
	 */
	@Test
	public void testEzbld002() {
	    
	    this.request.setDialog("201");
	    this.request.setText("PARAM");
        DIALOGEzBldResponse response = this.service.ezbld(request);
        
        assertNotNull(response);
        assertEquals("The input variable PARAM is missing or invalid.", response.getResponse());
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Test Case 3 (RPC): IEN input plus single parameter passed in array by reference
	 * >S DDR("DIALOG")=201,DDR("TEXT",1)="PAR2"
	 * >D EZBLDR^DDR5(.DATA,.DDR)
	 * >ZW DATA
	 * DATA="The input variable PAR2 is missing or invalid."
	 * </pre>
	 */
	@Test
	public void testEzbld003() {
		
	    this.request.setDialog("201");
        this.request.setText("PAR2");
        DIALOGEzBldResponse response = this.service.ezbld(request);
        
        assertNotNull(response);
        assertEquals("The input variable PAR2 is missing or invalid.", response.getResponse());

	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Test Case 4 (RPC): single parameter input
	 * >S DDR("DIALOG")=302,DDR("TEXT")=201
	 * >D EZBLDR^DDR5(.DATA,.DDR)
	 * >ZW DATA
	 * DATA="Entry '201' already exists."
	 * </pre>
	 */
	@Test
	public void testEzbld004() {
		
	    this.request.setDialog("302");
        this.request.setText("201");
        DIALOGEzBldResponse response = this.service.ezbld(request);
        
        assertNotNull(response);
        assertEquals("Entry '201' already exists.", response.getResponse());
	}
	
	/**
	 * <pre>
	 * Test Case 5 (RPC): Multiple parameter input
	 * >S DDR("DIALOG")=502,DDR("TEXT","FILE")=5,DDR("TEXT","FIELD")=.01
	 * >D EZBLDR^DDR5(.DATA,.DDR)
	 * >ZW DATA
	 * DATA="Field# .01 in file# 5 has a corrupted definition."
	 * </pre> 
	 */
	@Test
	public void testEzbld005() {
	    
	    this.request.setDialog("502");
        this.request.setFile("5");
        this.request.setField(".01");
        
        DIALOGEzBldResponse response = this.service.ezbld(request);
        
        assertNotNull(response);
        assertEquals("Field# .01 in file# 5 has a corrupted definition.", response.getResponse());	       
	}
}
