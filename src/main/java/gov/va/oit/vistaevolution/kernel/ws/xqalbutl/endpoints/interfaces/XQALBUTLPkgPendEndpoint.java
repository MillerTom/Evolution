
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 *  This extrinsic function returns whether or not 
 *  the user specified has an alert with XQAID containing 
 *  the first ";"-piece (software/package identifier) 
 *  indicated by the xqkg input parameter pending. It 
 *  returns either of the following:
 *  
 *  1—YES, indicates one or more alerts pending for the 
 *  specified user containing the software/package identifier.
 *  
 *  0—NO, alerts not pending.
 *  
 * </pre> 
 * @author rcollins
 *
 */
@WebService(name = "XQALBUTLPkgPend", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALBUTLPkgPendEndpoint {
    
    
    /**
     * <pre>
     * 
     * This RPC returns whether the specified user (XUIEN) has one or more 
     * alerts pending (1=YES, 0=NO) for the specified package identifier (XUPKG).
     * 
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All PKGPEND^XQALBUTL input
     *         Parameters
     * 
     * @return XQALBUTLPkgPendResponse
     * 
     *         Domain Object that contains PKGPEND^XQALBUTL output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XQALBUTLPkgPendAction", operationName = "XQALBUTLPkgPend")
    public XQALBUTLPkgPendResponse pkgpend(@WebParam(name = "XQALBUTLPkgPendRequest") XQALBUTLPkgPendRequest request)
            throws VistaWebServiceFault;
}
