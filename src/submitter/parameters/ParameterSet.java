package submitter.parameters;

import java.util.Map;
import java.util.Set;

public class ParameterSet { // TODO extends Parameter?
	private String title;
	private String description;
	private Map<String, Parameter> params; // TODO OrderedMap?

	/**
	 * Parameter sets should be created by the implementations of
	 * {@link Submitter}. These can use the {@link ParameterSetFactory}.
	 * 
	 * @param title
	 *            The title of the parameter set. A view might show this as
	 *            label.
	 * @param description
	 *            A longer description of the parameter set. A view might show
	 *            this as tooltip.
	 * @param params
	 *            {@code params} describes which parameters are expected.
	 */
	public ParameterSet(String title, String description,
			Map<String, Parameter> params) {
		this.title = title;
		this.description = description;
		this.params = params;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String asXML() {
		throw new RuntimeException();
	}

	public String asJSON() {
		throw new RuntimeException();
	}

	public Set<String> getParamNames() {
		return params.keySet();
	}

	public Parameter getParam(String key) {
		return params.get(key);
	}

	public void validate() throws IllegalArgumentException {
		for (Parameter param : params.values()) {
			param.validate();
		}
	}
}