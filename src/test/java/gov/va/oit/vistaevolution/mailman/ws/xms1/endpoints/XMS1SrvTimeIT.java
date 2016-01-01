/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1SrvTimeEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XMS1SrvTimeIT extends VistaLinkContextITParent {

    @Autowired
    private XMS1SrvTimeEndpoint service;
    
    /**
     * <pre>
     * Test Case 1 (RPC): No Updates
     * 
     * Create message stub
     * >S XMDUZ=DUZ,XMSUB="SRVTIME TEST"
     * EVOLUTION>D XMZ^XMA2
     * EVOLUTION>W XMZ
     * 74395
     * Note: when available, replace with CRE8XMZ^XMWSOA08(.RET,XMSUB) RPC:XMWSOA CRE8XMZ
     * 
     * Add text
     * EVOLUTION>S MSG(1)="SRVTIME TEST LINE 1",XMTEXT="MSG("EVOLUTION>D ENL^XMD
     * Note: there’s no RPC for this step; it might be optional; we can try leaving it out.
     * 
     * Send to server basket
     * EVOLUTION>S XMXX="S.XU FINDUSER"
     * EVOLUTION>D SETSB^XMWSOA01(.RETURN,XMXX,XMZ)
     * 
     * Attempt to set server related fields
     * EVOLUTION>S XMSER=XMXX,STATUS="SRVTIME"
     * EVOLUTION>D SRVTIME^XMWSOA03(.RET,XMZ,XMSER,STATUS)
     * EVOLUTION>ZW RET
     * RET="-1^1 No Update"
     * </pre>
     */
    @Test
    public void srvTime001() {
        
        XMS1SrvTimeRequest request = new XMS1SrvTimeRequest();
        
        request.setStatus("SRVTIME");
        request.setXmser("S.XU FINDUSER");
        request.setXmz("74395");
        
        XMS1SrvTimeResponse response = this.service.srvtime(request);
        assertNotNull(response);
        assertEquals("-1", response.getResponse());
        assertEquals("1 No Update", response.getMessage());
        
    }
    
    /**
     * <pre>
     * Test Case 2 (RPC): Error in required input
     * 
     * >S XMZ=""
     * >S XMSER="", STATUS=""
     * >D SRVTIME^XMWSOA03(.RETURN,XMZ,XMSER,STATUS)
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     */
    @Test
    public void srvTime002() {
        
      XMS1SrvTimeRequest request = new XMS1SrvTimeRequest();
      
      request.setStatus("");
      request.setXmser("");
      request.setXmz("");
      
      XMS1SrvTimeResponse response = this.service.srvtime(request);
      assertNotNull(response);
      assertEquals("-1", response.getResponse());
      assertEquals("Error in required input", response.getMessage());

    }
 
    /**
     * <pre>
     * Test Case 3 (RPC): Message not found
     * >S XMZ=9999,XMSER="S.XU FINDUSER",STATUS="SRVTIME"
     * >D SRVTIME^XMWSOA03(.RETURN,XMZ,XMSER,STATUS)
     * >ZW RETURN
     * RETURN="-1^Message not found"
     * </pre>
     */
    @Test
    public void srvTime003() {
        
      XMS1SrvTimeRequest request = new XMS1SrvTimeRequest();
      
      request.setStatus("SRVTIME");
      request.setXmser("S.XU FINDUSER");
      request.setXmz("9999");
      
      XMS1SrvTimeResponse response = this.service.srvtime(request);
      assertNotNull(response);
      assertEquals("-1", response.getResponse());
      assertEquals("Message not found", response.getMessage());

    }   
}
