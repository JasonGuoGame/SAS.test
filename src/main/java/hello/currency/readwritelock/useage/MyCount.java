package hello.currency.readwritelock.useage;

/**
 * Created by scnyig on 4/28/2017.
 */
public class MyCount {
    private String oid;         //’À∫≈
    private int cash;             //’Àªß”‡∂Ó

    MyCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "MyCount{" +
                "oid='" + oid + '\'' +
                ", cash=" + cash +
                '}';
    }
}
