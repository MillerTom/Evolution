
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <pre>
 * Send Encryption to the Client Input Parameters Class:
 * 
 * root:    (required) This parameter is a closed 
 *          reference to a local or global root. 
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSRB1SendkeysRequest {
    
    @XmlElement(required = true)
    private String root;
    
    
    /**
     * @return the root
     */
    public String getRoot() {
        return root;
    }


    /**
     * @param root the root to set
     */
    public void setRoot(String root) {
        this.root = root;
    }


    /**
     * Default constructor
     */
    public XUSRB1SendkeysRequest() {
        super();
    }
    
}
