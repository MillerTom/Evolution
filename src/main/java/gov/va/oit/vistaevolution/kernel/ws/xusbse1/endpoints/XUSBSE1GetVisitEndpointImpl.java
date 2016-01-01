/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import gov.va.oit.vistaevolution.kernel.ws.xusbse1.XUSBSE1ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints.interfaces.XUSBSE1GetVisitEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@Component
@WebService(serviceName="Xusbse1GetVisitService",portName="Xusbse1GetVisitPort",endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusbse1.endpoints.interfaces.XUSBSE1GetVisitEndpoint")
public class XUSBSE1GetVisitEndpointImpl  extends SpringBeanAutowiringSupport implements XUSBSE1GetVisitEndpoint {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(XUSBSE1GetVisitEndpointImpl.class);
	
	@Autowired
	private XUSBSE1ResponseFactory xusbse1ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default non-argument constructor. 
	 */
	public XUSBSE1GetVisitEndpointImpl() {
		super();
	}
	
	/**
	 * Constructor for XUSBSE1GetVisitEndpointImpl
	 * 
	 * @param xusbse1ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUSBSE1GetVisitEndpointImpl(XUSBSE1ResponseFactory xusbse1ResponseFactory, IVistaLinkContext vistaLinkContext){
		super();
		this.xusbse1ResponseFactory = xusbse1ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xusbse1.enpoints.interfaces.XUSBSE1GetVisitEndpoint#getVisit(gov.va.oit.vistaevolution.kernel.ws.xusbse1.model.XUSBSE1GetVisitRequest)
	 */
	@Override
	public XUSBSE1GetVisitResponse getVisit(
			XUSBSE1GetVisitRequest xusbse1GetVisitRequest)
			throws VistaWebServiceFault {
		ArrayList<String> params = new ArrayList<String>();
		
		params.add(xusbse1GetVisitRequest.getToken());
		
		return xusbse1ResponseFactory.createXUSBSE1ResponseFromString(vistaLinkContext.makeRPCCall(new RPCIdentifier("XUS GET VISITOR"),params)) ;
	}

}
