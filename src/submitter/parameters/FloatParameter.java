package submitter.parameters;

public class FloatParameter extends Parameter {
	private double minimum, maximum;
	private double value;
	private boolean isSet = false;

	public FloatParameter(String title, String description, boolean advanced,
			boolean required, double minimum, double maximum) {
		super(title, description, advanced, required);
		this.minimum = minimum;
		this.maximum = maximum;
	}

	@Override
	public boolean isValid(Object value) {
		double val;
		try {
			val = (double) value;
		} catch (ClassCastException e) { // TODO ?????
			return false;
		}
		return (minimum <= val) && (val < maximum);
	}

	@Override
	public void setValue(Object value) throws IllegalArgumentException {
		if (!isValid(value)) {
			throw new IllegalArgumentException();
		}

		this.value = (double) value;
		isSet = true;
	}

	@Override
	public void addToXML() {
		assert isSet;
		// TODO Auto-generated method stub

	}

	@Override
	public void addToJSON(String name, String json) {
		assert isSet;
		// TODO Auto-generated method stub

	}

	@Override
	public void validate() throws IllegalArgumentException {
		if (this.isRequired() && !isSet) {
			throw new IllegalArgumentException();
		}
	}

}
