package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlqEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1BKlqIT extends EvolutionIT<XMA1BKlqEndpoint> {
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Move message from default ‘IN’ basket to the ‘WASTE’ basket
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Test
	public void testKlq001() throws VistaWebServiceFault {
		XMA1BKlqRequest request = new XMA1BKlqRequest();
		
	    request.setXmduz("1");
        request.setXmk("");
        request.setXmz("73767");
        
        XMA1BKlqResponse response = this.service.klq(request);
        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("-1^Error in required input"));
	}
	
	/**
     * <em>Use Case #2</em>
     * 
     * <pre>
     * Move message from ‘IN’ basket explicitly to the ‘WASTE’ basket
     * </pre>
	 * @throws VistaWebServiceFault 
     */
	@Ignore
    @Test
    public void testKlq002() throws VistaWebServiceFault {
		XMA1BKlqRequest request = new XMA1BKlqRequest();
        
	    request.setXmduz("1");
        request.setXmk("1");
        request.setXmz("73768");
        
        XMA1BKlqResponse response = this.service.klq(request);
        assertNotNull(response);
        //assertTrue(response.getResponse().equalsIgnoreCase("0^Successful"));
    }
    
    /**
     * <em>Use Case #3</em>
     * 
     * <pre>
     * Input Error
     * 
     * >S (XMZ,XMDUZ,XMK)=""
     * >D KLQ^XMWSOA01(.RETURN,XMDUZ,XMK,XMZ)
     * >ZW RETURN
     * 
     * RETURN="-1^Error in required input"
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testKlq003() throws VistaWebServiceFault {
		XMA1BKlqRequest request = new XMA1BKlqRequest();
        
        request.setXmduz("");
        request.setXmk("");
        request.setXmz("");
        
        XMA1BKlqResponse response = this.service.klq(request);
        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("-1^Error in required input"));
    }

    /**
     * <em>Use Case #4</em>
     * 
     * <pre>
     * Message not found
     * 
     * >S (XMZ,XMDUZ,XMK)=999
     * >D KLQ^XMWSOA01(.RETURN,XMDUZ,XMK,XMZ)
     * >ZW RETURN
     * 
     * RETURN="-1^There is no message in that basket for this user"
     * </pre>
     * @throws VistaWebServiceFault 
     */	
    @Test
    public void testKlq004() throws VistaWebServiceFault {
		XMA1BKlqRequest request = new XMA1BKlqRequest();
        
        request.setXmduz(".5");
        request.setXmk("999");
        request.setXmz("999");
        
        XMA1BKlqResponse response = this.service.klq(request);
        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("-1^There is no message in that basket for this user"));        
    }

	@Override
	protected Class<XMA1BKlqEndpoint> getType() {
		return XMA1BKlqEndpoint.class;
	}

}
