/**	
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces.XUSCLEANLoutEndpoint;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XUSCLEANLoutEndpointIT extends VistaLinkContextITParent {
    
    @Autowired
    private XUSCLEANLoutEndpoint endpoint;
    
    /**
     * <em>Test Case 1</em>
     * Log In:
     * 
     * >D ^ZU
     *
     *                         >>>>> NOTICE <<<<<
     *  This account is established for software demonstration, testing and user
     *                            training only.
     *   The data in this TEST system is protected by the same confidentiality
     *    regulations, statutes, and penalties for unauthorized disclosure as
     *                        the production system.
     *
     *   Volume set: ROU:CACHE  UCI: ICD09A  Device: TNA334: (10.3.99.40/4532)
     *
     *       ACCESS CODE: ******
     *       VERIFY CODE: ********
     *
     *       Good evening TJERNAGEL,STEVE
     *
     *      Code to find entry in SIGN-ON LOG
     *      >S X=DT F  S X=$O(^XUSEC(0,X)) Q:'X  W !,^XUSEC(0,X,0)
     *
     *  API Call
     *  >D LOUT^XUSCLEAN(3140211.090053)
     *
     *  Check for the signoff time 
     *  >D ^%G
     *  Global ^XUSEC(0,3140211.090053
     *  ^XUSEC(0,3140211.090053,0)="53467^NLA0::113950^113950^3140211.171008^ROU^^0^ICD0
     *  9A^10.3.99.39^FELIX1^10.3.99.39^^^^^^518"
     */
    @Ignore
    @Test
    public void lout0001Test() {
        
    }
}
