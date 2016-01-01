/**
 *
 */
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
 * Output Generator
 * Output Parameters Class:
 *
 * If W is passed in the FLAGS parameter, the text is written to the
 * current device. If A is passed in the FLAGS parameter, the text is
 * written to the local array whose name is specified in the second
 * parameter. The format of that array is:
 *
 * ARRAY:       Total number of lines (only returned if the T flag is
 *              passed in the FLAGS parameter).
 *
 * ARRAY(n):    A line of formatted text (n=sequential integer starting
 *              with 1).
 * </pre>
 *
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIALOGMsgResponse {

    @XmlElementWrapper(name = "outputarray")
    @XmlElement(required = false)
	private List<String> outputArray;

    /**
     * @return the outputArray
     */
    public List<String> getOutputArray() {
        return this.outputArray;
    }

    /**
     * @param outputArray the outputArray to set
     */
    public void setOutputArray(final List<String> outputArray) {
        this.outputArray = outputArray;
    }

    /**
     * Default Bean Constructor
     */
    public DIALOGMsgResponse() {
        super();
    }

    /**
     * Constructor initializes bean
     * @param value
     */
    public DIALOGMsgResponse(final List<String> value) {

        super();
        this.outputArray = value;
    }


}
