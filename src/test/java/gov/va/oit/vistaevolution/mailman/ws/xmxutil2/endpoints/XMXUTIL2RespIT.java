/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.XUSRB2UserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2RespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XMXUTIL2RespIT extends VistaLinkContextITParent {
    
    @Autowired
    private XMXUTIL2RespEndpoint service;
    
    @Autowired
    private XUSRB2UserinfoEndpoint userinfo;

    /*
    
    @Override
    protected Class<XMXUTIL2RespEndpoint> getType() {
        return XMXUTIL2RespEndpoint.class;
    }
    */
    
    /**
     * Test Case #1 (RPC): -1^Message not found
     * >S XMZ=999
     * >D RESP^XMWSOA07(.RET,XMZ) ;RPC NAME: XMWSOA NO OF RESPONSES
     * >ZW RET
     * RET="-1^Message not found"
     */
    @Test
    public void respTest001() {
        
        XMXUTIL2RespRequest request = new XMXUTIL2RespRequest();
        
        request.setXmz("999");
        
        XMXUTIL2RespResponse response = this.service.resp(request);
        
        assertNotNull(response);
        assertEquals("-1", response.getResponses());
        assertEquals("Message not found", response.getMessage());        
    }
    
    /**
     * Test Case #2 (RPC) – -1^Error in required input
     * >S XMZ=””
     * >D RESP^XMWSOA07(.RETURN,XMZ) ;RPC NAME: XMWSOA NO OF RESPONSES
     * >ZW RETURN
     */
    @Test
    public void respTest002() {
        
        XMXUTIL2RespRequest request = new XMXUTIL2RespRequest();
        
        request.setXmz("");
        
        XMXUTIL2RespResponse response = this.service.resp(request);
        
        assertNotNull(response);
        assertEquals("-1", response.getResponses());
        assertEquals("Error in required input", response.getMessage());        
    }
    
    
    /**
     * Test Case #3 (RPC) – Get number of responses to a message
     * 
     * Get User’s DUZ
     * >d USERINFO^XUSRB2(.USROUT) ;RPC NAME: XUS GET USER INFO
     * >ZW USROUT
     * USROUT(0)=1 user’s DUZ
     * USROUT(1)="PROGRAMMER,ONE"
     * USROUT(2)="One Programmer"
     * USROUT(3)="500^CAMP MASTER^500"
     * USROUT(4)="COMPUTER SPECIALIST"
     * USROUT(5)="INFORMATION SYSTEMS CENTER"
     * USROUT(6)=""
     * USROUT(7)=9999
     * USROUT(8)=""
     * 
     * Send a message
     * >S XMDUZ=USROUT(0),XMSUBJ="XMWSOA IS MSG RESPONSE TEST"
     * >S MSG(1)="IS MSG RESPONSE 1"
     * >S XMTO(XMDUZ)=""
     * >D SENDMSG^XMWSOA03(.RETURN,USROUT(0),XMDUZ,XMSUBJ,.MSG,.XMTO) ;RPC NAME: XMWSOA SENDMSG
     * >ZW RETURN
     * RETURN=74113
     * 
     * Respond to the message
     * >S XMZ=RETURN,RMSG(1)="RESPONSE LINE 1",XMSUBJ=”RESPONSE SUBJECT”
     * >D ANSRMSGM^XMWSOA03(.RRET,DUZ,XMDUZ,XMZ,XMSUBJ,.RMSG) ;RPC NAME: XMWSOA ANSRMSGM
     * >ZW RRET
     * RET="0^74136"
     * 
     * Check response status
     * >S XMZ=$P(RRET,U,2)
     * >D RESP^XMWSOA07(.RETURN,XMZ) ;RPC NAME: XMWSOA NO OF RESPONSES
     * >ZW RETURN
     * RETURN=0 - this should have been a positive response, but alas…
     */
    @Test
    public void respTest003() {
        
        XUSRB2UserinfoResponse userResponse = this.userinfo.userinfo(new XUSRB2UserinfoRequest());
        assertNotNull(userResponse);
        
        //  TODO: Need other endpoints in order to test this one
    }
    
    
    
}
