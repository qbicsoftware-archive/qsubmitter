package submitter.parameters;

import java.util.List;

public class InputList { // TODO extends Parameter?
	private String title;
	private String description;
	private List<Parameter> data; // TODO OrderedMap?

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
	public InputList(String title, String description,
			List<Parameter> params) {
		this.title = title;
		this.description = description;
		this.data = params;
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

	public Parameter getParam(int index) {
		return data.get(index);
	}

	public void validate() throws IllegalArgumentException {
		for (Parameter param : data) {
			param.validate();
		}
	}
}