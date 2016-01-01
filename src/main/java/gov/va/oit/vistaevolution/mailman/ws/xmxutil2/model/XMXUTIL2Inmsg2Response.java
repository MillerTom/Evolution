package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get Message Information (Part 2)
 * Output Parameters Class:
 * 
 * 
 * recipients:      (Optional) Number of recipients of the message.
 * 
 * flags:           (Optional) Message is any or all of the following:
 *                  P - Priority.
 *                  I - Information Only (cannot be replied to).
 *                  X - Closed message (cannot be forwarded).
 *                  C - Confidential message (surrogate cannot read).
 *                  S - Send to sender (make sender a recipient).
 *                  R - Confirm receipt (return receipt requested).
 *                  F - Forward messages to users, if the users aren't already on the messages.
 * 
 * type:            (Optional) Message type is one of the following special types:
 *                  D - Document
 *                  S - Spooled Document
 *                  X - DIFROM
 *                  O - ODIF
 *                  B - BLOB
 *                  K - KIDS
 * 
 * vaporize:        (Optional) Date/time (any format understood by VA FileMan) on
 *                  which to delete (vaporize) this message from recipient baskets.
 *                  Recipients can override this date.
 * 
 * basket:          (Optional) Basket to deliver to for all recipients. The default
 *                  is the "IN" basket. Recipients must have specified in their personal
 *                  preferences that such targeted basket delivery is allowed. Otherwise,
 *                  this option is ignored.
 * 
 * hint:            (Optional) Hint for scramble key (mandatory if message is to be
 *                  scrambled). It must be from 1 to 40 characters in length.
 * 
 * origin:          (Optional) Did the user send the message?
 *                  0-No
 *                  1-Yes
 * 
 *                  (results from a call to $$ORIGIN8R^XMXSEC)
 *                  
 * ien:             (Optional) IEN of XMDUZ
 * 
 * newMsg:          (Optional) Determines if the message is new.
 *                  0-No
 *                  1-Yes
 * 
 * message:         (Optional) reply message
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXUTIL2Inmsg2Response")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2Inmsg2Response extends AbstractVistaResponse {
    
    @XmlElement(name = "recipients", required = false)
    private String recipients;
    
    @XmlElement(name = "flags", required = false)
    private String flags;
    
    @XmlElement(name = "type", required = false)
    private String type;
    
    @XmlElement(name = "vaporize_date", required = false)
    private String vaporize;
    
    @XmlElement(name = "recipients_basket", required = false)
    private String  basket;
    
    @XmlElement(name = "key_hint", required = false)
    private String hint;
    
    @XmlElement(name = "originator", required = false)
    private String origin;
    
    @XmlElement(name = "ien", required = false)
    private String ien;
    
    @XmlElement(name = "new_message", required = false)
    private String newMsg;
    
    @XmlElement(name = "message", required = false)
    private String message;
    
    
    /**
     * @return the recipients
     */
    public String getRecipients() {
        return this.recipients;
    }
    
    /**
     * @param recipients the recipients to set
     */
    protected void setRecipients(final String recipients) {
        this.recipients = recipients;
    }
    
    /**
     * @return the flags
     */
    public String getFlags() {
        return this.flags;
    }
    
    /**
     * @param flags the flags to set
     */
    protected void setFlags(final String flags) {
        this.flags = flags;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * @param type the type to set
     */
    protected void setType(final String type) {
        this.type = type;
    }
    
    /**
     * @return the vaporize
     */
    public String getVaporize() {
        return this.vaporize;
    }
    
    /**
     * @param vaporize the vaporize to set
     */
    protected void setVaporize(final String vaporize) {
        this.vaporize = vaporize;
    }
    
    /**
     * @return the basket
     */
    public String getBasket() {
        return this.basket;
    }
    
    /**
     * @param basket the basket to set
     */
    protected void setBasket(final String basket) {
        this.basket = basket;
    }
    
    /**
     * @return the hint
     */
    public String getHint() {
        return this.hint;
    }
    
    /**
     * @param hint the hint to set
     */
    protected void setHint(final String hint) {
        this.hint = hint;
    }
    
    /**
     * @return the origin
     */
    public String getOrigin() {
        return this.origin;
    }
    
    /**
     * @param origin the origin to set
     */
    protected void setOrigin(final String origin) {
        this.origin = origin;
    }
    
    /**
     * @return the ien
     */
    public String getIen() {
        return this.ien;
    }

    /**
     * @param ien the ien to set
     */
    protected void setIen(final String ien) {
        this.ien = ien;
    }

    /**
     * @return the newMsg
     */
    public String getNewMsg() {
        return this.newMsg;
    }

    /**
     * @param newMsg the newMsg to set
     */
    protected void setNewMsg(final String newMsg) {
        this.newMsg = newMsg;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }
    
    /**
     * @param message the message to set
     */
    protected void setMessage(final String message) {
        this.message = message;
    }
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL2Inmsg2Response() {
        super();
    }
    
    /**
     * Constructor initializes the status, message, and
     * the rawResponse.
     * 
     * @param status
     * @param message
     * @param rawResponse
     */
    public XMXUTIL2Inmsg2Response(final String status, final String message,
            final String rawResponse) {
        
        this();
        this.status = status;
        this.message = message;
        this.rawResponse = rawResponse;
    }
    
    /**
     * Constructor initializes class return values
     * 
     * @param recipients
     * @param flags
     * @param type
     * @param vaporize
     * @param basket
     * @param hint
     * @param origin
     * @param ien
     * @param newMsg
     * @param rawResponse
     */
    public XMXUTIL2Inmsg2Response(final String recipients, final String flags, final String type,
            final String vaporize, final String  basket, final String hint, final String origin,
            final String ien, final String newMsg, final String rawResponse) {
        
        this();
        this.recipients = recipients;
        this.flags = flags;
        this.type = type;
        this.vaporize = vaporize;
        this.basket = basket;
        this.hint = hint;
        this.origin = origin;
        this.ien = ien;
        this.newMsg = newMsg;
        this.rawResponse = rawResponse;
    }
    
}
