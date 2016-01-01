/**
 * 
 */
package gov.va.oit.vistaevolution.util.vistalink;

import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.List;

/**
 * This is a standard context class from a OO Strategy Pattern that encompasses all the information necessary 
 * to leverage an {@link IVistaLinkStrategy} to execute an RPC. 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public interface IVistaLinkContext {

	/**
	 * @param rpcName
	 * @param parameters
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@SuppressWarnings("rawtypes")
	@Deprecated
	String makeRPCCall(String rpcName, List parameters)
			throws VistaWebServiceFault;

	/**
	 * @param rpcName
	 * @param parameters
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@SuppressWarnings("rawtypes")
	String makeRPCCall(RPCIdentifier rpcId, List parameters)
			throws VistaWebServiceFault;

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getParameters();

	/**
	 * 
	 * @return
	 */
	@Deprecated
	String getRpcName();

	/**
	 * 
	 * @return
	 */
	RPCIdentifier getRpcId();

	/**
	 * @param string
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@Deprecated
	String makeRPCCall(String rpcName) throws VistaWebServiceFault;

	/**
	 * @param rpcIdentifier
	 * @return
	 * @throws VistaWebServiceFault 
	 */
	String makeRPCCall(RPCIdentifier rpcIdentifier) throws VistaWebServiceFault;

}
