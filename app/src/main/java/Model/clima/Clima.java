package Model.clima;

public class Clima {
    private Credits credits;
    private CurrentDataAgroclimatic currentDataAgroclimatic;
    private CurrentDataClimatic currentDataClimatic;
    private Station station;

    public Clima(Credits credits, CurrentDataAgroclimatic currentDataAgroclimatic, CurrentDataClimatic currentDataClimatic, Station station) {
        this.credits = credits;
        this.currentDataAgroclimatic = currentDataAgroclimatic;
        this.currentDataClimatic = currentDataClimatic;
        this.station = station;
    }

    public Clima() {
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits value) {
        this.credits = value;
    }

    public CurrentDataAgroclimatic getCurrentDataAgroclimatic() {
        return currentDataAgroclimatic;
    }

    public void setCurrentDataAgroclimatic(CurrentDataAgroclimatic value) {
        this.currentDataAgroclimatic = value;
    }

    public CurrentDataClimatic getCurrentDataClimatic() {
        return currentDataClimatic;
    }

    public void setCurrentDataClimatic(CurrentDataClimatic value) {
        this.currentDataClimatic = value;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station value) {
        this.station = value;
    }
}