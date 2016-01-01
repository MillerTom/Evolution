/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNetNameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
public class XMXUTILNetNameIT extends EvolutionIT<XMXUTILNetNameEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTILNetNameIT.class);

	@Override
	protected Class<XMXUTILNetNameEndpoint> getType() {
		return XMXUTILNetNameEndpoint.class;
	}

	private XMXUTILNetNameRequest request;
	private XMXUTILNetNameResponse response;

	@Before
	public void setUp() {
		request = new XMXUTILNetNameRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
     * Test Case 1
     * 
     * Retrieve information for MDUZ of .5
     * 
     * >D NETNAME^XMWSOA07(.RESULT,.5)
     * >ZW RESULT
     * RESULT="POSTMASTER@DBITTEST.DBITPRO.COM"
     * 
   */
    @Test
    public void testNetName001() throws VistaWebServiceFault {

    	request.setXmDuz(".5");
	
		
		// Execute request against mocked object backend.
		response = service.netName(request);
	
		assertNotNull(response);
		assertEquals("POSTMASTER@DBITTEST.DBITPRO.COM", response.getResults());
        
    }
    
    
    /**
     * Test Case 2
     * 
     * Retrieve information for MDUZ of .6
     * 
     * >D NETNAME^XMWSOA07(.RESULT,.6)
     * >ZW RESULT
     * RESULT="SHARED.MAIL@DBITTEST.DBITPRO.COM"
     * 
     */
    @Test
    public void testNetName002() throws VistaWebServiceFault {

    	request.setXmDuz(".6");
	
		
		// Execute request against mocked object backend.
		response = service.netName(request);
	
		assertNotNull(response);
		assertEquals("SHARED.MAIL@DBITTEST.DBITPRO.COM", response.getResults());
        
    }
    
    
    /**
     * Test Case 3
     * 
     * Retrieve information inputting string POSTMASTER
     * 
     * >D NETNAME^XMWSOA07(.RESULT,"POSTMASTER")
     * >ZW RESULT
     * RESULT="-1^Error in required input"
     * 
     */
    @Test
    public void testNetName003() throws VistaWebServiceFault {

    	request.setXmDuz("POSTMASTER");
	
		
		// Execute request against mocked object backend.
		response = service.netName(request);
	
		assertNotNull(response);
		assertEquals("-1^Error in required input", response.getResults());
        
    }
    
    
    /**
     * Test Case 4
     * 
     * Retrieve information inputting string 14PROGRAMMER
     *
     * >D NETNAME^XMWSOA07(.RESULT,"14PROGRAMMER")
     * 
     * >ZW RESULT
     * RESULT="14PROGRAMMER@IDBITTEST.DBITPRO.COM"
     * 
     */
    @Test
    public void testNetName004() throws VistaWebServiceFault {

    	request.setXmDuz("14PROGRAMMER");
	
		
		// Execute request against mocked object backend.
		response = service.netName(request);
	
		assertNotNull(response);
		assertEquals("14PROGRAMMER@DBITTEST.DBITPRO.COM", response.getResults());
        
    }
    
    /**
     * Test Case 5
     * 
     *  Retrieve information inputting string BATS14CATS
     *  
     *  >D NETNAME^XMWSOA07(.RESULT,"BATS14CATS")
     *  >ZW RESULT
     *  RESULT="-1^Error in required input"
     *  
     */
    @Test
    public void testNetName005() throws VistaWebServiceFault {

    	request.setXmDuz("BATS14CATS");
	
		
		// Execute request against mocked object backend.
		response = service.netName(request);
	
		assertNotNull(response);
		assertEquals("-1^Error in required input", response.getResults());
        
    }
    
    /**
     * Test Case 6
     * 
     * Retrieve information inputting string 2 BATS14CATS
     * 
     * >D NETNAME^XMWSOA07(.RESULT,"2BATS14CATS")
     * >ZW RESULT
     * RESULT="2BATS14CATS@DBITTEST.DBITPRO.COM"
     * 
     */
    @Test
    public void testNetName006() throws VistaWebServiceFault {

    	request.setXmDuz("2BATS14CATS");
	
		
		// Execute request against mocked object backend.
		response = service.netName(request);
	
		assertNotNull(response);
		assertEquals("2BATS14CATS@DBITTEST.DBITPRO.COM", response.getResults());
        
    }

}
