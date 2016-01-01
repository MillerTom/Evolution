/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPkgPendEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendResponse;
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
public class XQALBUTLPkgPendEndpointIT extends VistaLinkContextITParent {
    

    @Autowired
    private XQALBUTLPkgPendEndpoint endpoint;
    
    private static XQALBUTLPkgPendRequest request;
    
    @BeforeClass
    public static void setup() {
        request = new XQALBUTLPkgPendRequest();
    }
    
    @AfterClass
    public static void teardown() {
        request = null;
    }
    
    @Before
    public void setuptest() {
        
        request.setXuien(".6");
        request.setXupkg("");
    }
    
    /**
     * <pre>
     * Test Case 1 – Create and send test alert, then inquire if 
     * user has the alert pending
     * 
     * NOTE:  The value of DUZ and Timestamps shown in this test 
     * will be different from the values in tests performed in other 
     * installations at different times, but the principle is the same, 
     * since DUZ should always exist, and identify the current user.  
     * 
     * Create an alert and send to test user's DUZ.  (DUZ for results shown is 1234)
     * 
     * >S XQA(DUZ)=""
     * >S XQAMSG="KERNEL ALERT TEST MESSAGE"
     * >S OK=$$SETUP1^XQALERT
     * >I +OK W "ALERT SENT"
     * ALERT SENT
     *
     * Request list of alerts for test user, to obtain XQKG from XQAID 
     * in the 2nd "^"-piece of ZZALRT(1):
     * >D USER^XQALERT("ZZALRT",DUZ)
     *
     * >ZW ZZALRT
     * ZZALRT=1
     * ZZALRT(1)="I  KERNEL ALERT TEST MESSAGE^NO-ID;1234;3131219.131745"
     * 
     * Use the XQAID returned in specified root ZZALRT to obtain XQKG.  
     * [The DUZ in ";"-piece 2 of the submitted XQAID should match the 
     * DUZ returned in "^"-piece 1 of ZZALRT(1), as shown below ]
     * 
     * >S XQAID=$P(ZZALRT(1),"^",2)
     * >W XQAID
     * NO-ID;1234;3131219.131745
     * >S XQKG=$P(XQAID,";",1) W XQKG
     * NO-ID
     * > W $$PKGPEND^XQALBUTL(DUZ,XQKG)
     * 
     * 1
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testPendingSoftware001() throws VistaWebServiceFault {
        
        request.setXupkg("NO-ID");
        
        XQALBUTLPkgPendResponse response = this.endpoint.pkgpend(request);
        assertNotNull(response);
        assertEquals("1", response.getReturns());
    }
    
    /**
     * <pre>
     * Test Case 2 – Request alert pending status of a user who 
     * did not receive the alert
     * 
     * >S XQKG="NO-ID"
     * >W $$PKGPEND^XQALBUTL(9999,XQKG)
     * 
     * 0
     * </pre>
     * @throws VistaWebServiceFault 
     */    
    @Test
    public void testPendingSoftware002() throws VistaWebServiceFault {
       
        request.setXuien(".5");
        request.setXupkg("NO-ID");
        
        XQALBUTLPkgPendResponse response = this.endpoint.pkgpend(request);
        assertNotNull(response);
        assertEquals("0", response.getReturns());
    }
}
