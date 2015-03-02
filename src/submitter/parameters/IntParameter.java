package submitter.parameters;

public class IntParameter extends Parameter {
  private int minimum, maximum;
  private int value;
  private boolean isSet = false;
  public IntParameter(String title, String description, boolean advanced,
      boolean required, int minimum, int maximum) {
  super(title, description, advanced, required);
  this.minimum = minimum;
  this.maximum = maximum;
} 
  
  @Override
  public void validate() throws IllegalArgumentException {
    if (this.isRequired() && !isSet) {
      throw new IllegalArgumentException();
  }
  }

  @Override
  public boolean isValid(Object value) {
    int val;
    try {
        val = (int) value;
    } catch (ClassCastException e) { // TODO ?????
        return false;
    }
    return (minimum <= val) && (val < maximum);
  }

  @Override
  public void setValue(Object value) throws IllegalArgumentException {
    if (!isValid(value)) {
      isSet = false;
      throw new IllegalArgumentException();
  }

  this.value = (int) value;
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
  public Object getValue() {
    return value;
  }

}
