/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserdataEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XQALBUTLUserdataEndpointIT extends VistaLinkContextITParent {
    
    @Autowired
    private XQALBUTLUserdataEndpoint endpoint;
    
    private static XQALBUTLUserdataRequest request;
    
    @BeforeClass
    public static void setup() {
        request = new XQALBUTLUserdataRequest();
    }
    
    @AfterClass
    public static void teardown() {
        request = null;
    }
    
    @Before
    public void setuptest() {
        
        request.setXuien("1");
        request.setXqaid("");
    }
    

    /**
     * <pre>
     * Test Case 1 – Create and send test alert, then request 
     *               list of recipients
     *
     * NOTE:  The value of DUZ used in this test will be different 
     *        from its value in tests performed in other installations, 
     *        but the principle is the same, since DUZ should always exist,
     *        and identify the current user.  Note also that the Timestamp 
     *        returned in ZZALRT(1) will also be different, as will the User 
     *        Name returned in XQALUSRS(1).
     *
     * Create an alert and send to test user's DUZ.  (DUZ for results shown is 1234)
     * >S XQA(DUZ)=""
     * >S XQAMSG="KERNEL ALERT TEST MESSAGE"
     * >S OK=$$SETUP1^XQALERT
     * >I +OK W "ALERT SENT"
     * ALERT SENT
     *
     * Request list of alerts for test user, to obtain XQAID in the 2nd "^"-piece of ZZALRT(1):
     * >D USER^XQALERT("ZZALRT",DUZ)
     *
     * >ZW ZZALRT
     * ZZALRT=1
     * ZZALRT(1)="I  KERNEL ALERT TEST MESSAGE^NO-ID;1234;3131219.131745"
     *
     * Use the XQAID obtained to get user data for the test alert, returned in specified root XXX.  [The DUZ in ";"-piece 2 of the submitted XQAID should match the DUZ returned in "^"-piece 1 of XXX(.01), as shown below ]
     * >S XQAID=$P(ZZALRT(1),"^",2) W XQAID
     * NO-ID;1234;3131219.131745
     * >D USERDATA^XQALBUTL(XQAID,DUZ,"XXX")
     * >ZW XXX
     * XXX(.01)="1234^USER,TEST"
     * XXX(.01,"RECIPIENT")=""
     * XXX(.02)=""
     * XXX(.02,"ALERT FIRST DISPLAYED")=""
     * XXX(.03)=""
     * XXX(.03,"FIRST SELECTED ALERT")=""
     * XXX(.04)=""
     * XXX(.04,"PROCESSED ALERT")=""
     * XXX(.05)=""
     * XXX(.05,"DELETED ON")=""
     * XXX(.06)=""
     * XXX(.06,"AUTO DELETED")=""
     * XXX(.07)=""
     * XXX(.07,"FORWARDED BY")=""
     * XXX(.08)=""
     * XXX(.08,"DATE/TIME FORWARDED")=""
     * XXX(.09)=""
     * XXX(.09,"DELETED BY USER")=""
     * 
     * </pre>
     * @throws VistaWebServiceFault 
     */  
    @Ignore
    @Test
    public void testUserData001() throws VistaWebServiceFault {
        
        request.setXqaid("NO-ID;1;3140212.104945");
        
        XQALBUTLUserdataResponse response = this.endpoint.userdata(request);
        assertNotNull(response);
        System.out.println(response);
    }
    
    
    /**
     * <pre>
     * Test Case 2 – Request user data for invalid alert
     * 
     * >S XQAID=1
     * >D USERDATA^XQALBUTL(XQAID,DUZ)
     * >ZW XXX
     * XXX=""
     * </pre>
     */
    @Ignore
    @Test
    public void testUserData002() {
        
    }
}
