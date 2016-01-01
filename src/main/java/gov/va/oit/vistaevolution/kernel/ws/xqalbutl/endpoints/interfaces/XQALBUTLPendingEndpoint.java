
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This extrinsic function returns whether or not the user specified has 
 * the alert indicated by the xqaid input parameter as pending. It returns 
 * either of the following:
 * 
 * 1—YES, alert is pending.
 * 0—NO, alert is not pending.
 * </pre>
 *
 * @author rcollins
 *
 */
@WebService(name = "XQALBUTLPending", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALBUTLPendingEndpoint {
    
    
    /**
     * <pre>
     * This RPC returns whether the user specified has the alert indicated 
     * by the argument XUAID is pending (1=YES, 0=NO).
     * </pre>
     * 
     * @param request
     * 
     *         Domain Object that contains All Pending^XQALBUTL input
     *         Parameters
     * 
     * @return XQALBUTLPendingResponse
     * 
     *         Domain Object that contains Pending^XQALBUTL output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XQALBUTLPendingAction", operationName = "XQALBUTLPending")
    public XQALBUTLPendingResponse pending(@WebParam(name = "XQALBUTLPendingRequest") XQALBUTLPendingRequest request)
            throws VistaWebServiceFault;
    
}
