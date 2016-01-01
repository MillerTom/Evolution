/**
 * 
 */
package gov.va.oit.vistaevolution.util.vistalink;

import gov.va.med.exception.FoundationsException;
import gov.va.med.vistalink.adapter.cci.VistaLinkAppProxyConnectionSpec;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnection;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnectionFactory;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnectionSpec;
import gov.va.med.vistalink.adapter.cci.VistaLinkDuzConnectionSpec;
import gov.va.med.vistalink.adapter.cci.VistaLinkVpidConnectionSpec;
import gov.va.med.vistalink.institution.InstitutionMappingDelegate;
import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.med.vistalink.rpc.RpcRequestFactory;
import gov.va.med.vistalink.rpc.RpcResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;

import org.apache.log4j.Logger;

/**
 * The primary purpose of this class is to establish a connection to the VistA
 * Link J2EE Connector, to execute an RPC call against a VistA/M system, and to
 * relay the output back to the requester. This class used in addition to a
 * Context class that sets the RPC call that will be executed.
 * 
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 * 
 */

public class J2EEVistaLinkStrategy implements IVistaLinkStrategy {

	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(J2EEVistaLinkStrategy.class);

	private String connSpecType;
	private String userId;
	private String division;

	private final String VPID_INDICATOR = "vpid";
	private final String DUZ_INDICATOR = "duz";
	private final String PROXY_INDICATOR = "proxy";

	public J2EEVistaLinkStrategy() {
		this.connSpecType = null;
		this.division = null;
		this.userId = null;
	}

	/**
	 * new Default Constructor
	 * 
	 * @param connSpecType
	 *            Re-authentication id type: "duz", "vpid", or "proxy"
	 * @param endUserId
	 *            Unique identifier of the requester
	 * @param division
	 *            Station or Division identifier
	 * 
	 * */
	public J2EEVistaLinkStrategy(String connSpecType, String userId,
			String division) {
		super();
		this.setConnSpecType(connSpecType);
		this.setEndUserId(userId);
		this.setDivision(division);
	}

	@Override
	public String execute(IVistaLinkContext vistaLinkContext)
			throws VistaWebServiceFault {
		Context initcntx = null;
		VistaLinkConnectionSpec connSpec = null;
		VistaLinkConnectionFactory vlconnfactry = null;
		VistaLinkConnection vlconn = null;
		RpcRequest rpcRequest = null;

		String jndiName = null;
		try {

			initcntx = new InitialContext();
			// JNDI name look up is based off VA specific implementation of
			// business rules around station numbers
			jndiName = InstitutionMappingDelegate
					.getJndiConnectorNameForInstitution(getDivision());

			connSpec = createVistaLinkConnectionSpec(getConnSpecType(),
					getEndUserId());
			vlconnfactry = (VistaLinkConnectionFactory) initcntx
					.lookup(jndiName);
			vlconn = (VistaLinkConnection) vlconnfactry.getConnection(connSpec);
			rpcRequest = RpcRequestFactory.getRpcRequest();
			rpcRequest.setRpcContext(vistaLinkContext.getRpcId().getContext());
			rpcRequest.setRpcName(vistaLinkContext.getRpcId().getName());
			if (vistaLinkContext.getParameters() != null) {
				rpcRequest.setParams(vistaLinkContext.getParameters());
			}
			RpcResponse vResp = vlconn.executeRPC(rpcRequest);

			return vResp.getResults();

		} catch (NamingException e) {
			LOG.error("Error executing RPC call.  Can not find JNDI: "
					+ jndiName, e);
			return null;
		} catch (ResourceException e) {
			LOG.error("Error executing RPC call.  Can not create connection.",
					e);
			return null;
		} catch (FoundationsException e) {
			LOG.error(
					"Error executing RPC call.  Issue with implementing the VistALink Java Foundations Library.",
					e);
			return null;
		} finally {
			try {
				vlconn.close();
			} catch (ResourceException e) {
				LOG.error(
						"Error executing RPC call.  Connection failed to close.",
						e);
			}
		}

	}

	public String getEndUserId() {
		return userId;
	}

	public void setEndUserId(String endUserId) {
		this.userId = endUserId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getConnSpecType() {
		return connSpecType;
	}

	public void setConnSpecType(String connSpecType) {
		this.connSpecType = connSpecType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * createVistaLinkConnectionSpec returns the Connection Specification used
	 * for re-authentication, returning null if the connection type isn't
	 * specified.
	 */
	private VistaLinkConnectionSpec createVistaLinkConnectionSpec(
			String connSpecType, String identifier) {

		if (VPID_INDICATOR.equalsIgnoreCase(connSpecType)) {
			return new VistaLinkVpidConnectionSpec(this.getDivision(),
					identifier);
		} else if (DUZ_INDICATOR.equalsIgnoreCase(connSpecType)) {
			return new VistaLinkDuzConnectionSpec(division, identifier);
		} else if (PROXY_INDICATOR.equalsIgnoreCase(connSpecType)) {
			return new VistaLinkAppProxyConnectionSpec(division, identifier);
		} else {
			return null;
		}
	}
}
