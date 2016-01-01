package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXAPIBListBsktEntry")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBListBsktEntry { 

	public XMXAPIBListBsktEntry() { 
		super();
	}

	@XmlElement(name = "basketIen", required = false)
	private String basketIen;
	@XmlElement(name = "basketName", required = false)
	private String basketName;
	@XmlElement(name = "numMessagesInBasket", required = false)
	private String numMessagesInBasket;
	@XmlElement(name = "numNewMessagesInBasket", required = false)
	private String numNewMessagesInBasket;

	public String getBasketIen() { 
		return this.basketIen;
	}
	public void setBasketIen(String lvBasketIen) { 
		this.basketIen = lvBasketIen;
	}
	public String getBasketName() { 
		return this.basketName;
	}
	public void setBasketName(String lvBasketName) { 
		this.basketName = lvBasketName;
	}
	public String getNumMessagesInBasket() { 
		return this.numMessagesInBasket;
	}
	public void setNumMessagesInBasket(String lvNumMessagesInBasket) { 
		this.numMessagesInBasket = lvNumMessagesInBasket;
	}
	public String getNumNewMessagesInBasket() { 
		return this.numNewMessagesInBasket;
	}
	public void setNumNewMessagesInBasket(String lvNumNewMessagesInBasket) { 
		this.numNewMessagesInBasket = lvNumNewMessagesInBasket;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("basketIen ==> " + this.basketIen + "\n");
		sb.append("basketName ==> " + this.basketName + "\n");
		sb.append("numMessagesInBasket ==> " + this.numMessagesInBasket + "\n");
		sb.append("numNewMessagesInBasket ==> " + this.numNewMessagesInBasket + "\n");
		return sb.toString();
	}

}

