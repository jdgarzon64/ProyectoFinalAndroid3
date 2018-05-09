package Model.clima;

public class Credits {
    private String credit1;
    private String credit2;
    private String credit3;

    public Credits() {
    }

    public Credits(String credit1, String credit2, String credit3) {
        this.credit1 = credit1;
        this.credit2 = credit2;
        this.credit3 = credit3;
    }

    public String getCredit1() {
        return credit1;
    }

    public void setCredit1(String value) {
        this.credit1 = value;
    }

    public String getCredit2() {
        return credit2;
    }

    public void setCredit2(String value) {
        this.credit2 = value;
    }

    public String getCredit3() {
        return credit3;
    }

    public void setCredit3(String value) {
        this.credit3 = value;
    }
}