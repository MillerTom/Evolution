package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBQMBoxResponse extends AbstractVistaResponse {

    @XmlElement(required = false)
    private String numOfNewMsgs;
    @XmlElement(required = false)
    private String newPriorityMail;
    @XmlElement(required = false)
    private String numOfNewMsgsForINBskt;
    @XmlElement(required = false)
    private String dateLastMsgRecieved;
    @XmlElement(required = false)
    private String newMessagesSinceLastChecked;
    @XmlElement(required = false)
    private String basketIen;
    @XmlElement(required = false)
    private String basketName;

    public String getBasketIen() {
	return basketIen;
    }

    public void setBasketIen(String basketIen) {
	this.basketIen = basketIen;
    }

    public String getBasketName() {
	return basketName;
    }

    public void setBasketName(String basketName) {
	this.basketName = basketName;
    }

    public String getNumOfNewMsgs() {
	return numOfNewMsgs;
    }

    public void setNumOfNewMsgs(String numOfNewMsgs) {
	this.numOfNewMsgs = numOfNewMsgs;
    }

    public String getNewPriorityMail() {
	return newPriorityMail;
    }

    public void setNewPriorityMail(String newPriorityMail) {
	this.newPriorityMail = newPriorityMail;
    }

    public String getNumOfNewMsgsForINBskt() {
	return numOfNewMsgsForINBskt;
    }

    public void setNumOfNewMsgsForINBskt(String numOfNewMsgsForINBskt) {
	this.numOfNewMsgsForINBskt = numOfNewMsgsForINBskt;
    }

    public String getDateLastMsgRecieved() {
	return dateLastMsgRecieved;
    }

    public void setDateLastMsgRecieved(String dateLastMsgRecieved) {
	this.dateLastMsgRecieved = dateLastMsgRecieved;
    }

    public String getNewMessagesSinceLastChecked() {
	return newMessagesSinceLastChecked;
    }

    public void setNewMessagesSinceLastChecked(
	    String newMessagesSinceLastChecked) {
	this.newMessagesSinceLastChecked = newMessagesSinceLastChecked;
    }

}
