/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CRemsbmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1CRemsbmsgIT extends EvolutionIT<XMA1CRemsbmsgEndpoint> {

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Delete a message from a server basket.
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
    @Ignore
	@Test
	public void testRemsbmsg001() throws VistaWebServiceFault {
    	
    	XMA1CRemsbmsgRequest request = new XMA1CRemsbmsgRequest();
        
        request.setXmz("77032");
        request.setXmser("S.XU USER ADD");
        
        XMA1CRemsbmsgResponse response = this.service.remsbmsg(request);
        assertNotNull(response);
        assertEquals("0^Successful", response.getResponse());
		
	}
	
    /**
     * <em>Use Case #2</em>
     * 
     * <pre>
     * Input Error
     * 
     * >S (XMZ,XMSER)=""
     * >D REMSBMSG^XMWSOA01(.RETURN,XMSER,XMZ) 
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * 
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testRemsbmsg002() throws VistaWebServiceFault {
        
    	XMA1CRemsbmsgRequest request = new XMA1CRemsbmsgRequest("", "");

    	XMA1CRemsbmsgResponse response = this.service.remsbmsg(request);
        assertNotNull(response);
        assertEquals(response.getResponse(), "-1^Error in required input");
       
    }
    
    /**
     * <em>Use Case #3</em>
     * 
     * <pre>
     * Invalid Server Basket
     * 
     * >S XMZ=999,XMSER="S.ErrorTest"
     * >D REMSBMSG^XMWSOA01(.RETURN,XMSER,XMZ)
     * >ZW RETURN
     * RETURN="-1^Server basket not found"
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testRemsbmsg003() throws VistaWebServiceFault {
        
    	XMA1CRemsbmsgRequest request = new XMA1CRemsbmsgRequest();

    	request.setXmz("999");
        request.setXmser("S.ErrorTest");
        
        XMA1CRemsbmsgResponse response = this.service.remsbmsg(request);
        assertNotNull(response);
        assertEquals("-1^Server basket not found", response.getResponse());
    }
    
    /**
     * <em>Use Case #4</em>
     * 
     * <pre>
     * Message not found
     * 
     * >S XMSER="S.XU USER ADD",XMZ=73866
     * >D RENSBMSG^XMWSOA01(.RETURN,XMSER,XMZ)
     * >D REMSBMSG^XMWSOA01(.RETURN,XMSER,XMZ)
     * >ZW RETURN
     * RETURN="-1^Message not found in basket"
     * </pre>
     * @throws VistaWebServiceFault 
     */    
    @Test
    public void testRemsbmsg004() throws VistaWebServiceFault {
        
    	XMA1CRemsbmsgRequest request = new XMA1CRemsbmsgRequest();

    	request.setXmz("73866");
        request.setXmser("S.XU USER ADD");
        
        XMA1CRemsbmsgResponse response = this.service.remsbmsg(request);
        assertNotNull(response);
        assertEquals("-1^Message not found in basket", response.getResponse());
    }

	@Override
	protected Class<XMA1CRemsbmsgEndpoint> getType() {
		return XMA1CRemsbmsgEndpoint.class;
	}

}
