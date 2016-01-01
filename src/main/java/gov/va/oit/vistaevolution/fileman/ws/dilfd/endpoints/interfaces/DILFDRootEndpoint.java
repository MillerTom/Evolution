
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * 
 * This extrinsic function resolves the file root when passed file or subfile 
 * numbers. At the top level of the file $$ROOT returns the global name. When 
 * passing a subfile number, $$ROOT uses the IENS to build the root string.
 * 
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@WebService(name = "DILFDRoot", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDRootEndpoint {
    
    
    /**
     * <pre>
     * This API resolves the file root when passed file or subfile numbers.
     * </pre> 
     * 
     * @param DILFDRootRequest
     * 
     *            Domain Object that contains All Root^DILFD input
     *            Parameters
     * 
     * @return DILFDRootResponse
     * 
     *         Domain Object that contains Root^DILFD output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DILFDRootAction", operationName = "DILFDRoot")
	public DILFDRootResponse root(@WebParam(name = "DILFDRootRequest") DILFDRootRequest request) 
	        throws VistaWebServiceFault;
}
