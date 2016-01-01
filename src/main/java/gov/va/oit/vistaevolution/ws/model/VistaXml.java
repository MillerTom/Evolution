package gov.va.oit.vistaevolution.ws.model;

import gov.va.oit.vistaevolution.util.XmlUtils;

/**
 * This 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
public abstract class VistaXml {

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return XmlUtils.toStringFromJAXBObject(this);
	}

}