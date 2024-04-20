// CLASS CONTAINING USER ATRIBUTES
// USER EXTENDS MPESA CLASS
public class User extends Mpesa {
  // ENCAPSULATED ATTRIBUTES
  private int _phoneNumber;
  private int _mpesaPin;

  // CONSTRUCTOR
  public User(int phoneNumber, int mpesaPin, float mpesaBalance, int airtimeBalance, int dataBalance) {
    // ATTRIBUTED EXTENDED FROM THE SUPERCLASS
    super(mpesaBalance, airtimeBalance, dataBalance);
    _phoneNumber = phoneNumber;
    _mpesaPin = mpesaPin;
  }

  // SETTERS AND CONSTRUCTORS
  public void set_phoneNumber(int phoneNumber) {
    _phoneNumber = phoneNumber;
  }

  public int get_phoneNumber() {
    return _phoneNumber;
  }

  public void set_mpesaPin(int mpesaPin) {
    _mpesaPin = mpesaPin;
  }

  public int get_mpesaPin() {
    return _mpesaPin;
  }

}
