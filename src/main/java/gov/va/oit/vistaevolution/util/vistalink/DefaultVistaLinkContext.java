/**
 * 
 */
package gov.va.oit.vistaevolution.util.vistalink;

import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
public class DefaultVistaLinkContext implements IVistaLinkContext {

	private static final Logger LOG = Logger
			.getLogger(DefaultVistaLinkContext.class);

	private List<Object> parameters;
	@Deprecated
	private String rpcName;
	private IVistaLinkStrategy vistaLinkStrategy;

	private RPCIdentifier rpcId;

	/**
	 * @param vistaLinkConnectStrategy
	 * @param vistaLinkExecuteRPCStrategy
	 */
	public DefaultVistaLinkContext(IVistaLinkStrategy vistaLinkStrategy) {
		this.setVistaLinkStrategy(vistaLinkStrategy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.utils.vistalink.IVistaLinkContext#makeRPCCall
	 * (java.lang.String, java.lang.String, java.util.LinkedList)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Deprecated
	public String makeRPCCall(String rpcName, List parameters)
			throws VistaWebServiceFault {
		this.setRpcName(rpcName);
		this.setParameters(parameters);
		LOG.debug("Executing strategy: " + getVistaLinkStrategy().toString()
				+ " for RPC named: " + rpcName);
		return vistaLinkStrategy.execute(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.utils.vistalink.IVistaLinkContext#makeRPCCall
	 * (java.lang.String, java.lang.String, java.util.LinkedList)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String makeRPCCall(RPCIdentifier rpcId, List parameters)
			throws VistaWebServiceFault {
		this.setRpcId(rpcId);
		this.setParameters(parameters);
		LOG.debug("Executing strategy: " + getVistaLinkStrategy().toString()
				+ " for RPC named: " + rpcId.getName());
		return vistaLinkStrategy.execute(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext#makeRPCCall
	 * myPrincipal(java.lang.String)
	 */
	@Override
	@Deprecated
	public String makeRPCCall(String rpcName) throws VistaWebServiceFault {
		return this.makeRPCCall(rpcName, null);
	}
	
	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext#makeRPCCall(gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier)
	 */
	@Override
	public String makeRPCCall(RPCIdentifier rpcIdentifier) throws VistaWebServiceFault {
		return this.makeRPCCall(rpcIdentifier, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext#getParameters
	 * ()
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List getParameters() {
		return parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext#getRpcName()
	 */
	@Override
	@Deprecated
	public String getRpcName() {
		return rpcName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext#getRpcId()
	 */
	@Override
	public RPCIdentifier getRpcId() {
		return rpcId;
	}

	protected void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

	protected void setRpcName(String rpcName) {
		this.rpcName = rpcName;
	}

	protected IVistaLinkStrategy getVistaLinkStrategy() {
		return vistaLinkStrategy;
	}

	protected void setVistaLinkStrategy(IVistaLinkStrategy vistaLinkStrategy) {
		this.vistaLinkStrategy = vistaLinkStrategy;
	}

	protected void setRpcId(RPCIdentifier rpcId) {
		this.rpcId = rpcId;
	}



}
