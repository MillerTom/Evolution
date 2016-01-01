/**
 * 
 */
package gov.va.oit.vistaevolution.util.vistalink;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class RPCIdentifier {

	private String context;
	private String name;

	/**
	 * Set context and name on instantiation.
	 * 
	 * @param context
	 * @param name
	 */
	public RPCIdentifier(String context, String name) {
		this.setContext(context);
		this.setName(name);
	}

	/**
	 * Sets context to blank sting while name is set to argument.
	 * 
	 * @param name
	 */
	public RPCIdentifier(String name) {
		this.setContext("");
		this.setName(name);
	}

	/**
	 * Default not arg with nulls for values.
	 * 
	 * @param name
	 */
	protected RPCIdentifier() {
		this.setContext(null);
		this.setName(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof RPCIdentifier) {
			RPCIdentifier instance = (RPCIdentifier) object;
			if (instance.getContext().equals(this.getContext())
					&& instance.getName().equals(this.getName()))
				return true;
			else
				return false;
		} else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Object: RPCIdentifier Context: " + this.getContext()
				+ " Name: " + this.getName();

	}

	public String getContext() {
		return context;
	}

	protected void setContext(String context) {
		this.context = context;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

}
