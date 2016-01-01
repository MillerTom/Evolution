/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.XUSKAAJResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJSignoffEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJSignoffEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XUSKAAJSignoffService",
portName="XUSKAAJSignoffServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJSignoffEndpoint")
public class XUSKAAJSignoffEndpointImpl extends SpringBeanAutowiringSupport implements XUSKAAJSignoffEndpoint {

    private static final String RPCCALL = "XUS KAAJEE LOGOUT";
    
	private static final Logger LOG = Logger.getLogger(XUSKAAJSignoffEndpointImpl.class);	
	
	@Autowired
	private XUSKAAJResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	/**
	 * Default Bean Constructor
	 */
	public XUSKAAJSignoffEndpointImpl() {
	    super();
	}
	
	/**
	 * Constructor intializes the object
	 * @param context
	 * @param factory
	 */
	public XUSKAAJSignoffEndpointImpl(IVistaLinkContext context, 
	        XUSKAAJResponseFactory factory) {
	    
	    this();
	    this.vistaLinkContext = context;
	    this.responseFactory = factory;
	}

	/** (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJSignoffEndpoint#signoff(gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffRequest)
	 */
	@Override
	public XUSKAAJSignoffResponse signoff(XUSKAAJSignoffRequest request)
			throws VistaWebServiceFault {
		
	    List<String> params = new ArrayList<String>(1);
	    params.add(0, request.getDa());
		
		try {
		    return responseFactory
		            .createSignoffXUSKAAJResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		}
		catch (Exception ex){
            
            LOG.error("ABNORMAL ERROR OCCURRED in XUSKAAJSignoffEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
	}
	
	public XUSKAAJResponseFactory getXuskaajResponseFactory() {
		return responseFactory;
	}

	public void setXuskaajResponseFactory(
			XUSKAAJResponseFactory xuskaajResponseFactory) {
		this.responseFactory = xuskaajResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
