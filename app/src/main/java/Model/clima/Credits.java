package Model.clima;


import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Credits {
    private String credit1;
    private String credit2;
    private String credit3;

    @JsonProperty("credit1")
    public String getCredit1() { return credit1; }
    @JsonProperty("credit1")
    public void setCredit1(String value) { this.credit1 = value; }

    @JsonProperty("credit2")
    public String getCredit2() { return credit2; }
    @JsonProperty("credit2")
    public void setCredit2(String value) { this.credit2 = value; }

    @JsonProperty("credit3")
    public String getCredit3() { return credit3; }
    @JsonProperty("credit3")
    public void setCredit3(String value) { this.credit3 = value; }
}