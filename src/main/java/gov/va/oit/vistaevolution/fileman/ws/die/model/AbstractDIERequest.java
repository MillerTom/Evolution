/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.die.model;

/**
 * @author Christopher Schuck
 *
 */
public class AbstractDIERequest {

	private int file;
	private String iens;
	private int field;
	private String flags;
	private String value;
	private String result;
	private String fdaRoot;
	private String[] fdaExtRoot;
	private String[] fdaIntRoot;
	private String[] msgRoot;
	
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public String getIens() {
		return iens;
	}
	public void setIens(String iens) {
		this.iens = iens;
	}
	public int getField() {
		return field;
	}
	public void setField(int field) {
		this.field = field;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getFdaRoot() {
		return fdaRoot;
	}
	public void setFdaRoot(String fdaRoot) {
		this.fdaRoot = fdaRoot;
	}
	public String[] getMsgRoot() {
		return msgRoot;
	}
	public void setMsgRoot(String[] msgRoot) {
		this.msgRoot = msgRoot;
	}
	public String[] getFdaExtRoot() {
		return fdaExtRoot;
	}
	public void setFdaExtRoot(String[] fdaExtRoot) {
		this.fdaExtRoot = fdaExtRoot;
	}
	public String[] getFdaIntRoot() {
		return fdaIntRoot;
	}
	public void setFdaIntRoot(String[] fdaIntRoot) {
		this.fdaIntRoot = fdaIntRoot;
	}
	
}
