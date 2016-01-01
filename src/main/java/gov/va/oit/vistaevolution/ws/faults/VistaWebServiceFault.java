/**
 * 
 */
package gov.va.oit.vistaevolution.ws.faults;

import javax.xml.ws.WebFault;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebFault(faultBean = "gov.va.oit.vistaevolution.ws.faults.FaultBean")
public class VistaWebServiceFault extends RuntimeException {

	@SuppressWarnings("unused")
	private FaultBean faultBean;

	/**
	 * @param e
	 */
	public VistaWebServiceFault(Exception e) {
		super(e);
	}

	/**
	 * @param string
	 */
	public VistaWebServiceFault(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public VistaWebServiceFault(String message, Throwable cause) {
		super(message, cause);
	}

	public VistaWebServiceFault(String message, FaultBean faultBean,
			Throwable cause) {
		super(message, cause);
		this.faultBean = faultBean;
	}

	public VistaWebServiceFault(String message, FaultBean faultBean) {
		super(message);
		this.faultBean = faultBean;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4638686502327086700L;

}
