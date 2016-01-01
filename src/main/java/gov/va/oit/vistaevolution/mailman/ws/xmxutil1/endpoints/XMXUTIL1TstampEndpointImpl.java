/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TstampEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TstampResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.utils.XMXUTIL1Constants;
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
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMXUTIL1TstampService", portName = "XMXUTIL1TstampServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TstampEndpoint")
public class XMXUTIL1TstampEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL1TstampEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL1TstampEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUTIL1ResponseFactory xmxutil1ResponseFactory;

	private int errCount = 0;
	private List<String> errMsgs;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTIL1TstampEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxutil1ResponseFactory
	 */
	public XMXUTIL1TstampEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
	}

	@Override
	public XMXUTIL1TstampResponse tstamp() throws VistaWebServiceFault {
		this.errCount = 0;
		this.errMsgs = new ArrayList<String>();

		if (this.errCount > 0) {
			return new XMXUTIL1TstampResponse(null, errMsgs);
		} else {
			return xmxutil1ResponseFactory
					.createTstampResponseFromString(getVistaLinkContext()
							.makeRPCCall(
									new RPCIdentifier(
											XMXUTIL1Constants.CONTEXT,
											XMXUTIL1Constants.TSTAMP_RPC)));
		}
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
	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * @return the xmxutil1ResponseFactory
	 */
	public XMXUTIL1ResponseFactory getXmxutil1ResponseFactory() {
		return xmxutil1ResponseFactory;
	}

	/**
	 * @param xmxutil1ResponseFactory
	 *            the xmxutil1ResponseFactory to set
	 */
	protected void setXmxutil1ResponseFactory(
			XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
	}

	/**
	 * @return the errCount
	 */
	public int getErrCount() {
		return errCount;
	}

	/**
	 * @param errCount
	 *            the errCount to set
	 */
	protected void setErrCount(int errCount) {
		this.errCount = errCount;
	}

	/**
	 * @return the errMsgs
	 */
	public List<String> getErrMsgs() {
		return errMsgs;
	}

	/**
	 * @param errMsgs
	 *            the errMsgs to set
	 */
	protected void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

	/**
	 * 
	 * @return the LOGGER
	 */
	public static Logger getLogger() {
		return LOGGER;
	}

}
