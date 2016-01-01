/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 *
 * DIALOG Extractor (Single Line)
 * Input Parameters Class:
 *
 * dialog:      (Required) Record number from the DIALOG
 *              file (#.84) for the text to be returned.
 *
 * text:        (Optional) Name of local array containing
 *              the parameter list for those parameters that
 *              are to be incorporated into the resulting text.
 *              These parameters should be in external, printable
 *              format. If there is only one parameter in the list,
 *              it can be passed in a local variable or as a literal.
 * 
 * file:        (Optional)
 * 
 * field:       (Optional)
 *
 * </pre>
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DIALOGEzBldRequest extends AbstractVistaRequest {
    
    @XmlElement(required = true)
    private String dialog;
    
    @XmlElement(required = false)
    private String text;
    
    @XmlElement(required = false)
    private String file;
    
    @XmlElement(required = false)
    private String field;
    
    
    /**
     * @return the dialog
     */
    public String getDialog() {
        return this.dialog;
    }
    
    
    /**
     * @param dialog the dialog to set
     */
    public void setDialog(final String dialog) {
        this.dialog = dialog;
    }
    
    
    /**
     * @return the text
     */
    public String getText() {
        return this.text;
    }
    
    
    /**
     * @param text the text to set
     */
    public void setText(final String text) {
        this.text = text;
    }
    
    
    /**
     * @return the file
     */
    public String getFile() {
        return this.file;
    }
    
    
    /**
     * @param file the file to set
     */
    public void setFile(final String file) {
        this.file = file;
    }
    
    
    /**
     * @return the field
     */
    public String getField() {
        return this.field;
    }
    
    
    /**
     * @param field the field to set
     */
    public void setField(final String field) {
        this.field = field;
    }
    
    
    /**
     * Default Bean Constructor
     */
    public DIALOGEzBldRequest() {
        super();
    }
    
}
