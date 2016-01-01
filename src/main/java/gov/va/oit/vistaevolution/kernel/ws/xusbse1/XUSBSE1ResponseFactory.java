/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1;

import org.springframework.stereotype.Component;

import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

/**
 * @author 0G4976SEC
 *
 */
@Component
public class XUSBSE1ResponseFactory extends AbstractResponseFactory {

	/**
	 * 
	 */
	public XUSBSE1ResponseFactory() {
		super();
	}

	
	public XUSBSE1GetVisitResponse createXUSBSE1ResponseFromString(String rawResponse){
		
		return new XUSBSE1GetVisitResponse(rawResponse);
	}
}
