package gov.va.oit.vistaevolution.util;

import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;
import gov.va.oit.vistaevolution.ws.model.VistaXml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XmlUtils {
	private static Logger LOGGER = Logger.getLogger(XmlUtils.class);

	/**
	 * @param clazz
	 * @return
	 * @throws VistaWebServiceFault
	 *             unchecked.
	 */
	public static String toStringFromJAXBObject(VistaXml vistaXml) {
		StringWriter rawXml = new StringWriter();
		try {
				JAXBContext context = JAXBContext.newInstance(vistaXml.getClass());
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(vistaXml, rawXml);
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(e);
			LOGGER.error(fault);
			throw fault;
		}
		return rawXml.toString();
	}
}
