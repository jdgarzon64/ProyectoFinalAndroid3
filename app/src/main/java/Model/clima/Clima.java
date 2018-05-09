package Model.clima;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Clima {
    private Credits credits;
    private CurrentDataAgroclimatic currentDataAgroclimatic;
    private CurrentDataClimatic currentDataClimatic;
    private Station station;

    @JsonProperty("Credits")
    public Credits getCredits() { return credits; }
    @JsonProperty("Credits")
    public void setCredits(Credits value) { this.credits = value; }

    @JsonProperty("CurrentDataAgroclimatic")
    public CurrentDataAgroclimatic getCurrentDataAgroclimatic() { return currentDataAgroclimatic; }
    @JsonProperty("CurrentDataAgroclimatic")
    public void setCurrentDataAgroclimatic(CurrentDataAgroclimatic value) { this.currentDataAgroclimatic = value; }

    @JsonProperty("CurrentDataClimatic")
    public CurrentDataClimatic getCurrentDataClimatic() { return currentDataClimatic; }
    @JsonProperty("CurrentDataClimatic")
    public void setCurrentDataClimatic(CurrentDataClimatic value) { this.currentDataClimatic = value; }

    @JsonProperty("Station")
    public Station getStation() { return station; }
    @JsonProperty("Station")
    public void setStation(Station value) { this.station = value; }
}
