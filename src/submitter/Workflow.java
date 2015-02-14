package submitter;

import java.util.List;

import submitter.parameters.ParameterSet;

public abstract class Workflow {
	protected ParameterSet params;
	protected List<Node> nodes;

	private String name;
	private String description;
	private String version;
	private String id;

	protected Workflow(String id, String name, String description,
			String version) {
		this.name = name;
		this.description = description;
		this.version = version;
		this.id = id;
	}

	/**
	 * Workflow-global parameters. Those could be parameters that are used in
	 * several nodes but should be set only once.
	 * 
	 * @return
	 */
	public ParameterSet parameters() {
		return params;
	}

	/**
	 * Check if all required parameters are set and throw an error if not.
	 * 
	 * @throws IllegalArgumentException
	 */
	public void validate() throws IllegalArgumentException {
		params.validate();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getVersion() {
		return version;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public String getID() {
		return id;
	}
}