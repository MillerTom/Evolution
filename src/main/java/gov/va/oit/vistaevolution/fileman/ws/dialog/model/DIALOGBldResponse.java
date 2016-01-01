
package gov.va.oit.vistaevolution.fileman.ws.dialog.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * BLD^DIALOG
 * Output Parameters Class:
 * 
 * output_param:    (Optional) This is useful mainly if 
 *                  you are returning error messages as part 
 *                  of an API for other developers to use. Use 
 *                  it to pass dialogue parameters back to the 
 *                  user of your API, such that they can be 
 *                  accessed individually instead of just being 
 *                  embedded in the error text.
 *                  
 *                  Use only with DIALOG file (#.84) entries of 
 *                  type Error. Pass this local array by reference. 
 *                  Subscript each node by the parameter name and 
 *                  set the node to the corresponding parameter 
 *                  value. The parameter values can be in any                  
 *                  format (external or internal).
 *                  
 *  output_array:   (Optional) If provided, the text will be output 
 *                  in the local or global array named by this parameter. 
 *                  If this parameter is null, output is returned in 
 *                  the ^TMP global, under the "DIERR", "DIHELP", or "DIMSG" 
 *                  subscripts as documented in the DBS Contents of Arrays 
 *                  section.
 *                  
 *                  If you specify DIR("A") or DIR("?") as the output array, 
 *                  special handling is provided for populating the output 
 *                  array for use in a call to the Reader, ^DIR. Text is output 
 *                  in the format needed for input to the Reader. 
 * 
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIALOGBldResponse {

    @XmlElementWrapper(name = "output-param")
    @XmlElement(name = "param", required = true)
	private List<String> outputParam;

    @XmlElementWrapper(name = "output-array")
    @XmlElement(name = "array", required = true)
	private List<String> outputArray;


	/**
     * @return the outputParam
     */
    public List<String> getOutputParam() {
        return this.outputParam;
    }


    /**
     * @param aOutputParam the outputParam to set
     */
    public void setOutputParam(final List<String> aOutputParam) {
        this.outputParam = aOutputParam;
    }


    /**
     * @return the outputArray
     */
    public List<String> getOutputArray() {
        return this.outputArray;
    }


    /**
     * @param aOutputArray the outputArray to set
     */
    public void setOutputArray(final List<String> aOutputArray) {
        this.outputArray = aOutputArray;
    }


    /**
	 * Default Bean Constructor
	 */
	public DIALOGBldResponse() {
	    super();
	}
	
	/**
	 * Bean Constructor initializes object
	 * @param oParam
	 * @param oArray
	 */
	public DIALOGBldResponse(final List<String> oParam, 
	        final List<String> oArray) {
        
	    super();
	    this.outputParam = oParam;
	    this.outputArray = oArray;
    } 

}
