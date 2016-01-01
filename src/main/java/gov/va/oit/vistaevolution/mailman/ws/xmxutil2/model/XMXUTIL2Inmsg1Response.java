/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Get Message Information (Part 1)
 * Output Parameters Class:
 * 
 * createDate:         (Optional) Local create date (in VA FileMan format).
 * 
 * creatDate_mm:      (Optional) External MailMan format: dd mmm yy hh:mm (Not set, if
 *                      XMFLAGS contains "I" or "F".)
 * 
 * sendDate:           (Optional) When the message was sent (internal).
 * 
 * sendDate_mm:        (Optional) External MailMan format: dd mmm yy hh:mm (Internet date,
 *                      if error.) (Not set, if XMFLAGS contains "I" or "F".)
 * 
 * from:                (Optional) Who sent the message (internal).
 * 
 * fromDuz:            (Optional) DUZ of person who sent the message (if applicable).
 *                      (Not set if XMFLAGS contains "I".)
 * 
 * fromName:           (Optional) Name of person who sent the message. (Not set if
 *                      XMFLAGS contains "I".)
 * 
 * lines:               (Optional) How many lines are in the message.
 * 
 * responses:           (Optional) How many responses does the message have.
 * 
 * sender:              (Optional) Who really sent the message (if applicable).
 * 
 * senderDuz:          (Optional) DUZ of person who really sent the message (if applicable).
 *                      (Not set, if XMFLAGS contains "I".)
 * 
 * senderName:         (Optional) Name of person who really sent the message (if applicable).
 *                      (Not set, if XMFLAGS contains "I".)
 * 
 * subject:             (Optional) Subject of message (all ~U~ translated to ^).
 * 
 * xmz:                 (Optional) Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
 * 
 * ien:                 (Optional) IEN of XMDUZ in the message's RECIPIENT multiple.
 * 
 * responseNum:        (Optional) Number of the last response that the user has read.
 * 
 * message             (Optional) Response message.
 * 
 * 
 * </pre>
 * @author rcollins
 *
 */
@XmlRootElement(name = "XMXUTIL2Inmsg1Response")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2Inmsg1Response extends AbstractVistaResponse {
    
    @XmlElement(name = "create_date", required = false)
    private String createDate;
    
    @XmlElement(name = "creat_date_mm", required = false)
    private String creatDate_mm;
    
    @XmlElement(name = "send_date", required = false)
    private String sendDate;
    
    @XmlElement(name = "send_date_mm", required = false)
    private String sendDate_mm;
    
    @XmlElement(name = "from", required = false)
    private String from;
    
    @XmlElement(name = "from_duz", required = false)
    private String fromDuz;
    
    @XmlElement(name = "from_name", required = false)
    private String fromName;
    
    @XmlElement(name = "lines", required = false)
    private String lines;
    
    @XmlElement(name = "responses", required = false)
    private String responses;
    
    @XmlElement(name = "sender", required = false)
    private String sender;
    
    @XmlElement(name = "duz", required = false)
    private String senderDuz;
    
    @XmlElement(name = "sender_name", required = false)
    private String senderName;
    
    @XmlElement(name = "subject", required = false)
    private String subject;
    
    @XmlElement(name = "xmz", required = false)
    private String xmz;
    
    @XmlElement(name = "ien", required = false)
    private String ien;
    
    @XmlElement(name = "response_num", required = false)
    private String responseNum;
    
    @XmlElement(name = "message", required = false)
    private String message;
    
    
    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return this.createDate;
    }
    
    
    /**
     * @param createDate the createDate to set
     */
    protected void setCreateDate(final String createDate) {
        this.createDate = createDate;
    }
    
    
    /**
     * @return the creatDate_mm
     */
    public String getCreatDateMM() {
        return this.creatDate_mm;
    }
    
    
    /**
     * @param creatDate_mm the creatDate_mm to set
     */
    protected void setCreatDateMM(final String creatDate_mm) {
        this.creatDate_mm = creatDate_mm;
    }
    
    
    /**
     * @return the sendDate
     */
    public String getSendDate() {
        return this.sendDate;
    }
    
    
    /**
     * @param sendDate the sendDate to set
     */
    protected void setSendDate(final String sendDate) {
        this.sendDate = sendDate;
    }
    
    
    /**
     * @return the sendDate_mm
     */
    public String getSendDateMM() {
        return this.sendDate_mm;
    }
    
    
    /**
     * @param sendDate_mm the sendDate_mm to set
     */
    protected void setSendDateMM(final String sendDate_mm) {
        this.sendDate_mm = sendDate_mm;
    }
    
    
    /**
     * @return the from
     */
    public String getFrom() {
        return this.from;
    }
    
    
    /**
     * @param from the from to set
     */
    protected void setFrom(final String from) {
        this.from = from;
    }
    
    
    /**
     * @return the fromDuz
     */
    public String getFromDuz() {
        return this.fromDuz;
    }
    
    
    /**
     * @param fromDuz the fromDuz to set
     */
    protected void setFromDuz(final String fromDuz) {
        this.fromDuz = fromDuz;
    }
    
    
    /**
     * @return the fromName
     */
    public String getFromName() {
        return this.fromName;
    }
    
    
    /**
     * @param fromName the fromName to set
     */
    protected void setFromName(final String fromName) {
        this.fromName = fromName;
    }
    
    
    /**
     * @return the lines
     */
    public String getLines() {
        return this.lines;
    }
    
    
    /**
     * @param lines the lines to set
     */
    protected void setLines(final String lines) {
        this.lines = lines;
    }
    
    
    /**
     * @return the responses
     */
    public String getResponses() {
        return this.responses;
    }
    
    
    /**
     * @param responses the responses to set
     */
    protected void setResponses(final String responses) {
        this.responses = responses;
    }
    
    
    /**
     * @return the sender
     */
    public String getSender() {
        return this.sender;
    }
    
    
    /**
     * @param sender the sender to set
     */
    protected void setSender(final String sender) {
        this.sender = sender;
    }
    
    
    /**
     * @return the senderDuz
     */
    public String getSenderDuz() {
        return this.senderDuz;
    }
    
    
    /**
     * @param senderDuz the senderDuz to set
     */
    protected void setSenderDuz(final String senderDuz) {
        this.senderDuz = senderDuz;
    }
    
    
    /**
     * @return the senderName
     */
    public String getSenderName() {
        return this.senderName;
    }
    
    
    /**
     * @param senderName the senderName to set
     */
    protected void setSenderName(final String senderName) {
        this.senderName = senderName;
    }
    
    
    /**
     * @return the subject
     */
    public String getSubject() {
        return this.subject;
    }
    
    
    /**
     * @param subject the subject to set
     */
    protected void setSubject(final String subject) {
        this.subject = subject;
    }
    
    
    /**
     * @return the xmz
     */
    public String getXmz() {
        return this.xmz;
    }
    
    
    /**
     * @param xmz the xmz to set
     */
    protected void setXmz(final String xmz) {
        this.xmz = xmz;
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
     * @return the responseNum
     */
    public String getResponseNum() {
        return this.responseNum;
    }
    
    
    /**
     * @param responseNum the responseNum to set
     */
    protected void setResponseNum(final String responseNum) {
        this.responseNum = responseNum;
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
    public XMXUTIL2Inmsg1Response() {
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
    public XMXUTIL2Inmsg1Response(final String status, final String message, 
            final String rawResponse) {
        
        this();
        this.status = status;
        this.message = message;
        this.rawResponse = rawResponse;
    }
    
    /**
     * Constructor initializes class return values
     * 
     * @param createDate
     * @param creatDate_mm
     * @param sendDate
     * @param sendDate_mm
     * @param from
     * @param fromDuz
     * @param fromName
     * @param lines
     * @param responses
     * @param sender
     * @param senderDuz
     * @param senderName
     * @param subject
     * @param xmz
     * @param ien
     * @param responseNum
     * @param rawResponse
     */
    public XMXUTIL2Inmsg1Response(final String create_date, final String create_date_mm, final String send_date,
            final String send_date_mm, final String from,  final String from_duz, final String from_name, final String lines,
            final String responses, final String sender, final String sender_duz, final String sender_name, final String subject,
            final String xmz, final String ien,  final String response_num, final String rawResponse) {
        
        this();
        this.createDate = create_date;
        this.creatDate_mm = create_date_mm;
        this.sendDate = send_date;
        this.sendDate_mm = send_date_mm;
        this.from = from;
        this.fromDuz = from_duz;
        this.fromName = from_name;
        this.lines = lines;
        this.responses = responses;
        this.sender = sender;
        this.senderDuz = sender_duz;
        this.senderName = sender_name;
        this.subject = subject;
        this.xmz = xmz;
        this.ien = ien;
        this.responseNum = response_num;
        this.rawResponse = rawResponse;
        
    }
    
    
    
}
