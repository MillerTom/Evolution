/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFORefEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "DILFORefService", portName = "DILFORefServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFORefEndpoint")
public class DILFORefEndpointImpl extends SpringBeanAutowiringSupport implements
		DILFORefEndpoint {

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * @param vistaLinkContext
	 * @param dilfResponseFactory
	 */
	public DILFORefEndpointImpl(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * Default-No Arg Constructor
	 */
	public DILFORefEndpointImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.
	 * DILFOrefEndpoint
	 * #convertClosedRootToOpenRoot(gov.va.oit.vistaevolution.fileman
	 * .ws.dilf.model.DILFOrefRequest)
	 */
	@Override
	public DILFORefResponse oref(DILFORefRequest request)
			throws VistaWebServiceFault {
		return new DILFORefResponse(vistaLinkContext.makeRPCCall(
				new RPCIdentifier("EVOLUTION", "DDR SOA GET OPEN ROOT"),
				Arrays.asList(request.getDdr())));
	}

}
