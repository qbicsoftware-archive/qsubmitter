package submitter.parameters;

public class FloatParameter extends Parameter{

  private float minimum, maximum;
  private float value;
  private boolean isSet = false;

  public FloatParameter(String title, String description, boolean advanced, boolean required,
      float minimum, float maximum) {
    super(title, description, advanced, required);
    this.minimum = minimum;
    this.maximum = maximum;
  }

  @Override
  public boolean isValid(Object value) {
    float val;
    try {
      System.out.println(value.getClass().getName());
      val = (float) value;
    } catch (ClassCastException e) { // TODO ?????
      System.out.println("CAST");
      return false;
    }
    return (minimum <= val) && (val < maximum);
  }

  @Override
  public void setValue(Object value) throws IllegalArgumentException {
    System.out.println(isValid(value));
    if (!isValid(value)) {
      throw new IllegalArgumentException();
    }

    this.value = (float) value;
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

  @Override
  public Object getValue() {
    return value;
  }
  
  public double getMinimum() {
    return minimum;
  }

  public void setMinimum(float minimum) {
    this.minimum = minimum;
  }

  public double getMaximum() {
    return maximum;
  }

  public void setMaximum(float maximum) {
    this.maximum = maximum;
  }


}
