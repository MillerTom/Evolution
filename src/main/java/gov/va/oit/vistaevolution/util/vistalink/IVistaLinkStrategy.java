/**
 * 
 */
package gov.va.oit.vistaevolution.util.vistalink;

import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * This is the interface for a VistaLink Strategy. It is used by the implementation of {@link IVistaLinkContext}
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
public interface IVistaLinkStrategy {

	/**
	 * This function is called by an {@link IVistaLinkContext} which passes an instance of itself as per a standard 
	 * strategy pattern. It used the information contained in the context to execute an RPC Request. 
	 * @param vistaLinkContext Object containing all the necessary information for a strategy to run an RPC request. 
	 * @return String returned from execution of RPC in strategy. 
	 * @throws VistaWebServiceFault If there is a problem during the execution of the RPC. 
	 */
	String execute(IVistaLinkContext vistaLinkContext) throws VistaWebServiceFault;

}
