
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21InstEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstResponse;
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
public class XMA21InstIT extends VistaLinkContextITParent {
    
    @Autowired
    private XMA21InstEndpoint endpoint;
    
    private static XMA21InstRequest request;
    
    @BeforeClass
    public static void setup() {
        request = new XMA21InstRequest();        
    }
    
    @AfterClass
    public static void tearDown() {
        request = null;
    }
    
    
    @Before
    public void setupTest() {
        request.setXmadd("");
        request.setXmdf("");
        request.setXmduz(".5");
    }
  
    
    /**
     * <em>Use Case #1</em>
     * 
     * <pre>
     * Look up user in remote domain
     * >S XMADD="JOHN.MERRITT2@VA.GOV",XMDUZ=DUZ
     * >D INST^XMWSOA01(.XMRY,XMADD,,XMDUZ) 
     * >ZW XMRY
     * 
     * XMRY("JOHN.MERRITT2@MED.VA.GOV")="ADDRESS^JOHN.MERRITT2@MED.VA.GOV"
     * XMRY("XMMG")="REMOTE^ via FO-ALBANY.MED.VA.GOV"
     * XMRY("Y")="REMOTE^47^FO-ALBANY.MED.VA.GOV"
     * 
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testInst001() throws VistaWebServiceFault  {        
             
        request.setXmadd("STEVE.TJERNAGEL@VA.GOV");        
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals("48", response.getIen());
        assertEquals("STEVE.TJERNAGEL@VA.GOV", response.getAddress());
        assertEquals("REMOTE", response.getLocation());
        assertEquals("FORUM.VA.GOV", response.getDomain()); 
        
        System.out.println(response.toString());
    }
    
    /**
     * <em>Use Case #2</em>
     * 
     * <pre>
     * Look up user in remote domain with XMDF flag set.
     * 
     * >S XMADD="JOHN.MERRITT2@VA.GOV",XMDUZ=DUZ,XMDF=1
     * >D INST^XMWSOA01(.XMRY,XMADD,XMDF,XMDUZ)
     * >ZW XMRY
     * 
     * XMRY("JOHN.MERRITT2@MED.VA.GOV")="ADDRESS^JOHN.MERRITT2@MED.VA.GOV"
     * XMRY("XMMG")="REMOTE^ via FO-ALBANY.MED.VA.GOV"
     * XMRY("Y")="REMOTE^47^FO-ALBANY.MED.VA.GOV"
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testInst002() throws VistaWebServiceFault {
                
        request.setXmadd("john.merritt2@va.gov");
        request.setXmdf("1");       // Optional
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals("48", response.getIen());
        assertEquals("john.merritt2@VA.GOV", response.getAddress());
        assertEquals("REMOTE", response.getLocation());
        assertEquals("FORUM.VA.GOV", response.getDomain());        
        
        System.out.println(response.toString());
    }
    
    /**
     * <em>Use Case #3</em>
     * 
     * <pre>
     * Look up local user by partial name
     * 
     * Step1:  (Optional) Get partial name of local user associated with current login if needed.
     * 
     * >S X=$$GET1^DIQ(200,DUZ_",",.01)
     * >S X=$P(X,",")
     * >S X=$P(X,",") ;get just the first comma delimited piece of ‘X’ to use as a partial name
     *   
     * Step 2:  Call INST^XMWSOA01 using partial name, and display returned values
     * 
     * >S XMDUZ=DUZ,XMADD=X
     * >D INST^XMWSOA01(.XMRY,XMADD,,XMDUZ)
     * >ZW XMRY
     * XMRY(|DUZ here|)="ADDRESS^|DUZ here|"
     * XMRY("Y")="LOCAL^|DUZ here|^|username here|"
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testInst003() throws VistaWebServiceFault {
              
        request.setXmadd("POST");
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals(".5", response.getDuz());
        assertEquals("POSTMASTER", response.getUsername());
        assertEquals("LOCAL", response.getLocation());        
        
        System.out.println(response.toString());
    }
    
    /**
     * <em>Use Case #4</em>
     * 
     * <pre>
     * Look up user by partial name with XMBF flag set
     * 
     * Step1:  (Optional) Get partial name of local user associated with current login if needed.
     *
     *  >S X=$$GET1^DIQ(200,DUZ_",",.01)
     *  >S X=$P(X,",")
     *  >S X=$P(X,",") ;get just the first comma delimited piece of ‘X’ to use as a partial name
     *
     * Step 2:  Call INST^XMWSOA01 using partial name, and display returned values
     * 
     * >S XMDUZ=DUZ,XMADD=X,XMDF=1
     * >D INST^XMWSOA01(.XMRY,XMADD,XMDF,XMDUZ)
     * >ZW XMRY
     * XMRY(|DUZ here|)="ADDRESS^|DUZ here|"
     * XMRY("Y")="LOCAL^|DUZ here|^|username here|"
     * </pre>
     * 
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testInst004() throws VistaWebServiceFault {
        
        request.setXmadd("POST");
        request.setXmdf("1");
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals(".5", response.getDuz());
        assertEquals("POSTMASTER", response.getUsername());
        assertEquals("LOCAL", response.getLocation());
        
        System.out.println(response.toString());
        
    }
    
    /**
     * <em>Use Case #5</em>
     * 
     * <pre>
     * Look up remote user by partial name.
     * 
     * >K X,XMDUZ,XMDF,XMRY
     * 
     * >S XMADD="merritt@va.gov",XMDUZ=DUZ 
     * >D INST^XMWSOA01(.XMRY,XMADD,,XMDUZ) 
     * 
     * >ZW XMRY
     * 
     * XMRY("XMMG")="REMOTE^ via FO-ALBANY.MED.VA.GOV"
     * XMRY("Y")="REMOTE^47^FO-ALBANY.MED.VA.GOV"
     * XMRY("merritt@MED.VA.GOV")="ADDRESS^merritt@MED.VA.GOV"
     * </pre>
     * @throws VistaWebServiceFault 
     */    
    @Test
    public void testInst005() throws VistaWebServiceFault {
        
        request.setXmadd("merritt@va.gov");      
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals("48", response.getIen());
        assertEquals("merritt@VA.GOV", response.getAddress());
        assertEquals("REMOTE", response.getLocation());
        assertEquals("FORUM.VA.GOV", response.getDomain());  
        
        System.out.println(response.toString());
        
    }
    
    /**
     * <em>Use Case #6</em>
     * 
     * <pre>
     * Look up an invalid address; error returned in XMMG (XMLOC not set)
     * 
     * >K XMADD,XMDUZ,XMDF,XMRY
     * >S XMADD="XQZD",XMDUZ=DUZ 
     * >D INST^XMWSOA01(.XMRY,XMADD,,XMDUZ)
     * >ZW XMRY
     * XMRY("XMMG")="-1^Addressee not found." 
     * </pre>
     * @throws VistaWebServiceFault 
     */
    @Test
    public void testInst006() throws VistaWebServiceFault {
        
        request.setXmadd("XQZD");      
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals("-1", response.getResponse());
        assertEquals("Addressee not found.", response.getMessage());
        
        System.out.println(response.toString());
    }
    
    
    /**
     * <em>Use Case #7</em>
     * 
     * <pre>
     * Look up local address for non-existent user with XMDF flag set; error returned in XMMG
     * 
     * >K XMADD,XMDUZ,XMDF,XMRY 
     * >S XMADD="XQZD",XMDUZ=DUZ,XMDF=1
     * >D INST^XMWSOA01(.XMRY,XMADD,XMDF,XMDUZ)
     * >ZW XMRY
     * XMRY("XMMG")="-1^Addressee not found."
     * </pre>
     * @throws VistaWebServiceFault 
     */    
    @Test
    public void testInst007() throws VistaWebServiceFault {
       
        request.setXmadd("XQZD");   
        request.setXmdf("1");
        
        XMA21InstResponse response = endpoint.inst(request);
        assertNotNull(response);
        assertEquals("-1", response.getResponse());
        assertEquals("Addressee not found.", response.getMessage());
        
        System.out.println(response.toString());
    }
    
    
    /**
     * <em>Use Case #8</em>
     * 
     * <pre>
     * Input Error
     * 
     * >K XMADD,XMDUZ,XMDF,XMRY 
     * >S XMADD="",XMDUZ=DUZ,XMDF=1
     * >D INST^XMWSOA01(.XMRY,XMADD,XMDF,XMDUZ)
     * >ZW XMRY
     * XMRY("XMMG")="-1^Error in required input"
     * </pre>
     * @throws VistaWebServiceFault 
     */    
    @Test
    public void testInst008() throws VistaWebServiceFault {
       
        request.setXmadd("");        
        
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);
        assertEquals("-1", response.getResponse());
        assertEquals("Error in required input", response.getMessage());
        
        System.out.println(response.toString());
    }
}
