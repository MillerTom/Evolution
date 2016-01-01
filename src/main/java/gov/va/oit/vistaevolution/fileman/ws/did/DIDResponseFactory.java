/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did;

import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDAttributeValue;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldResponse;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldListResponse;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileResponse;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileListResponse;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDGet1Response;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
public class DIDResponseFactory extends AbstractResponseFactory {
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(AbstractResponseFactory.class);

	/**
	 * @param results
	 * @return
	 */
	public DIDGet1Response createGet1ResponseFromString(String results) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param rawResponse
	 * @return
	 * @throws VistaWebServiceFault
	 */
	public DIDFieldResponse createDIDFieldResponseFromString(
			DIDFieldRequest request, String rawResponse)
			throws VistaWebServiceFault {
		List<String> responseLines = this.processLines(rawResponse);

		ArrayList<DIDAttributeValue> attributes = this
				.getListOfAttributesValues(request.getAttributes(),
						request.getFlags(), responseLines);

		return new DIDFieldResponse(attributes);
	}

	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	public DIDFileListResponse createDIDFileListResponseFromString(
			String rawResponse) {
		return new DIDFileListResponse(processLines(rawResponse));

	}

	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	// TODO This is not a true implementation because we do not know what will
	// be returned from the RPC.
	public DIDFileResponse createDIDFileResponseFromString(String rawResponse) {
		List<String> rawLines = processLines(rawResponse);
		ArrayList<DIDAttributeValue> attributes = new ArrayList<DIDAttributeValue>(
				0);
		for (String lineOfResponse : rawLines) {
			attributes.add(new DIDAttributeValue(lineOfResponse));
		}
		return new DIDFileResponse(attributes);
	}

	public DIDFieldListResponse createDIDFieldListResponseFromString(
			String rawResponse) {
		return new DIDFieldListResponse(Arrays.asList(rawResponse.split("\n")));
	}

	/**
	 * This is a private function for use in constrtucting an array list of
	 * attribute values based on the list of strings form the response and the
	 * request used to retrieve them.
	 * 
	 * @param attributeNames
	 *            The various attribute Names
	 * @param flags
	 *            Flags used
	 * @param responseLines
	 *            List of strings, one for each line of response.
	 * @return
	 * @throws VistaWebServiceFault
	 */
	private ArrayList<DIDAttributeValue> getListOfAttributesValues(
			List<String> attributeNames, List<String> flags,
			List<String> responseLines) throws VistaWebServiceFault {
		// create an array list.
		ArrayList<DIDAttributeValue> attributeValues = new ArrayList<DIDAttributeValue>(
				0);
		// alphabetize flags
		if (flags != null)
			Collections.sort(flags);

		// initial counter for list location
		int listLocation = 0;

		try {
			// for each attribute / number of attributes
			for (String attribute : attributeNames) {
				if (flags != null && flags.size() != 0) {
					// for each flag / number of flags
					for (String flag : flags) {
						// create and add DIDAttribute from first current list
						// location.
						attributeValues.add(new DIDAttributeValue(attribute,
								flag, responseLines.get(listLocation)));
						// increment list location counter.
						listLocation++;
					}
				} else {
					// Add them using on lyte line value and attreibute name.
					attributeValues.add(new DIDAttributeValue(attribute,
							responseLines.get(listLocation)));
				}
			}
		} catch (Exception e) {
			LOG.error("An error occured while mapping data for a response.", e);
			VistaWebServiceFault fault = new VistaWebServiceFault(e);
			throw fault;
		}
		return attributeValues;
	}

}
