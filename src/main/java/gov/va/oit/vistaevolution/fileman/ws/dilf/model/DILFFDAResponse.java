/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.model;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
public class DILFFDAResponse {

	/**
	 * 
	 */
	public DILFFDAResponse() {
		this(null);
	}

	private String response;


	/**
	 * @param makeRPCCall
	 */
	public DILFFDAResponse(String response) {
		this.setResponse(response);
		// TODO Auto-generated constructor stub
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
