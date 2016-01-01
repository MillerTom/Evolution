
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This API returns recipients of the alert with the xqaid 
 * input parameter as its alert ID from the ALERT TRACKING 
 * file (#8992.1) in the array specified by the root input 
 * parameter. If root is not specified, then the data is 
 * returned in the XQALUSER array. If the specified alert 
 * is not present, the root array is returned with a NULL 
 * value.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XQALBUTLUserdata", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALBUTLUserdataEndpoint {
    
    
    /**
     * <pre>
     * 
     *  This RPC returns information from the ALERT TRACKING (#8992.1) file 
     *  for the alert XUAID in the array specified by XURET.  If the specified 
     *  alert is not present, the array root is returned with a NULL value.       
     * 
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All USERDATA^XQALBUTL input
     *         Parameters
     * 
     * @return XQALBUTLUserdataResponse
     * 
     *         Domain Object that contains USERDATA^XQALBUTL output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XQALBUTLUserdataAction", operationName = "XQALBUTLUserdata")
    public XQALBUTLUserdataResponse userdata(@WebParam(name = "XQALBUTLUserdataRequest") XQALBUTLUserdataRequest request)
            throws VistaWebServiceFault;
}
