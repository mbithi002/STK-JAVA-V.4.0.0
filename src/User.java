
public class User extends Mpesa {
  private int _phoneNumber;
  private int _mpesaPin;

  public User(int phoneNumber, int mpesaPin, float mpesaBalance, int airtimeBalance, int dataBalance) {
    super(mpesaBalance, airtimeBalance, dataBalance);
    _phoneNumber = phoneNumber;
    _mpesaPin = mpesaPin;
  }

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
