
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * This API returns recipients of the alert with the xqaid input parameter 
 * as its alert ID from the ALERT TRACKING file (#8992.1) in the array specified 
 * by the root input parameter. If root is not specified, then the data is returned 
 * in the XQALUSRS array. If the specified alert is not present, the root array 
 * is returned with a NULL value.
 * </pre>
 * @author Christopher Schuck
 *
 */
@WebService(name = "XQALBUTLUserlist", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALBUTLUserlistEndpoint {

    /**
     * <pre>
     * 
     * This RPC returns recipients of alert XUAID from the ALERT TRACKING
     * (#8992.1) file in the array specified by XURET.
     * 
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All USERLIST^XQALBUTL input
     *         Parameters
     * 
     * @return XQALBUTLUserlistResponse
     * 
     *         Domain Object that contains USERLIST^XQALBUTL output data
     * 
     * @throws VistaWebServiceFault
     */
	@WebMethod(action = "XQALBUTLUserlistAction", operationName = "XQALBUTLUserlist")
	public XQALBUTLUserlistResponse userlist(@WebParam(name = "XQALBUTLUserlistRequest") XQALBUTLUserlistRequest request) 
	        throws VistaWebServiceFault;

}
