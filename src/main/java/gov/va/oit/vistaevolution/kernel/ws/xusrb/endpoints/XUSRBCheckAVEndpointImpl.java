package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.XUSRBResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBCheckAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;
import java.util.ArrayList;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XUSRBCheckAVService", portName = "XUSRBCheckAVServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBCheckAVEndpoint")
public class XUSRBCheckAVEndpointImpl extends SpringBeanAutowiringSupport implements XUSRBCheckAVEndpoint {

//note: due to the nature of this class logging will only be used in test classes.
	
	@Autowired
	private XUSRBResponseFactory xusrbResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	public XUSRBCheckAVEndpointImpl() {
		super();
	}

	public XUSRBCheckAVEndpointImpl(XUSRBResponseFactory xusrbResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xusrbResponseFactory = xusrbResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * @return the xusrbResponseFactory
	 */
	public XUSRBResponseFactory getXusrbResponseFactory() {
		return xusrbResponseFactory;
	}

	/**
	 * @param xusrbResponseFactory
	 *            the xusrbResponseFactory to set
	 */
	public void setXusrbResponseFactory(
			XUSRBResponseFactory xusrbResponseFactory) {
		this.xusrbResponseFactory = xusrbResponseFactory;
	}

	/**
	 * @return the vistaLinkContext
	 */
	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	/**
	 * @param vistaLinkContext
	 *            the vistaLinkContext to set
	 */
	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XUSRBCheckAVResponse checkAV(XUSRBCheckAVRequest request)
			throws VistaWebServiceFault {

		ArrayList<String> params = new ArrayList<String>();
		params.add(request.getAvCode());
		return xusrbResponseFactory.createXUSRBCheckAVResponseFromString(
						getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA CHECK ACCESS"),params));
	}

}
