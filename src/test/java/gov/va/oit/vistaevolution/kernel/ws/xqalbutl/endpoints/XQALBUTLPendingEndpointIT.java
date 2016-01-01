/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPendingEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XQALBUTLPendingEndpointIT extends VistaLinkContextITParent {
    
    @Autowired
    private XQALBUTLPendingEndpoint endpoint;
    
    private static XQALBUTLPendingRequest request;
    
    @BeforeClass
    public static void setup() {
        request = new XQALBUTLPendingRequest();
    }
    
    @AfterClass
    public static void teardown() {
        request = null;
    }
    
    @Before
    public void setuptest() {
        
        request.setXuien(".6");
        request.setXuaid("");
    }
    
    /**
     * <pre>
     * Create a new alert
     * >S XQA(DUZ)="",XQAMSG="PENDING-XQALBUTL TESTING",XQAID="NO-ID;"_DUZ_";" 
     * >S VAL=$$SETUP1^XQALERT
     * >W VAL
     * 1^4111904^NO-ID;53473;3131219.151736
     *
     * Check Pending status
     * >S XQAUSER=DUZ,XQAID=$P(VAL,U,3) 
     * >W $$PENDING^XQALBUTL(XQAUSER,XQAID)
     * 1
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testPending001() throws VistaWebServiceFault {
       
        request.setXuaid("NO-ID;1;3140212.104945");
        
        XQALBUTLPendingResponse response = this.endpoint.pending(request);
        assertNotNull(response);
        assertEquals("1", response.getReturns());
    }
    
    /**
     * <pre>
     * Test Case 2 (RPC) – Check pending status of a non-existing alert
     * S XUIEN=DUZ,XUAID="NO-ID;"_DUZ_";2990212.15540723"
     * >D PENDINGR^XUSOAR(.XURET,XUIEN,XUAID)
     * >W XURET
     * 0
     * </pre>
     * @throws VistaWebServiceFault
     */
    @Test
    public void testPending002()  throws VistaWebServiceFault {
        
        request.setXuaid("1");
        
        XQALBUTLPendingResponse response = this.endpoint.pending(request);
        assertNotNull(response);
        assertEquals("0", response.getReturns());
    }
    
    
}
