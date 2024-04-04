public class Mpesa {
    private float _mpesaBalance;
    private int _airtimeBalance;
    private int _dataBalance;

    public Mpesa(float mpesaBalance, int airtimeBalance, int dataBalance) {
        _mpesaBalance = mpesaBalance;
        _airtimeBalance = airtimeBalance;
        _dataBalance = dataBalance;
    }

    public void set_mpesaBalance(float mpesaBalance) {
        _mpesaBalance = mpesaBalance;
    }

    public float get_mpesaBalance() {
        return _mpesaBalance;
    }

    public void set_airtimeBalance(int airtimeBalance) {
        _airtimeBalance = airtimeBalance;
    }

    public int get_airtimeBalance() {
        return _airtimeBalance;
    }

    public void set_dataBalance(int dataBalance) {
        _dataBalance = dataBalance;
    }

    public int get_dataBalance() {
        return _dataBalance;
    }
}
