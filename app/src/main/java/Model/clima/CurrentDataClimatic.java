package Model.clima;

public class CurrentDataClimatic {
    private long dewpointC;
    private long dewpointF;
    private double heatIndexC;
    private double heatIndexF;
    private long precipRateInh;
    private long precipRateMmh;
    private double precipTodayIn;
    private double precipTodayMm;
    private double pressureHpa;
    private double pressureInhg;
    private double pressureMB;
    private long relativeHumidity;
    private String reportDate;
    private String reportDateLocale;
    private long solarRadiation;
    private double tempC;
    private double tempF;
    private long uvIndex;
    private long windDegrees;
    private String windDir;
    private double windGustKmh;
    private double windGustMph;
    private long windSpeedKmh;
    private long windSpeedMph;
    private double windchillC;
    private double windchillF;

    public CurrentDataClimatic() {
    }

    public CurrentDataClimatic(long dewpointC, long dewpointF, double heatIndexC, double heatIndexF, long precipRateInh, long precipRateMmh, double precipTodayIn, double precipTodayMm, double pressureHpa, double pressureInhg, double pressureMB, long relativeHumidity, String reportDate, String reportDateLocale, long solarRadiation, double tempC, double tempF, long uvIndex, long windDegrees, String windDir, double windGustKmh, double windGustMph, long windSpeedKmh, long windSpeedMph, double windchillC, double windchillF) {
        this.dewpointC = dewpointC;
        this.dewpointF = dewpointF;
        this.heatIndexC = heatIndexC;
        this.heatIndexF = heatIndexF;
        this.precipRateInh = precipRateInh;
        this.precipRateMmh = precipRateMmh;
        this.precipTodayIn = precipTodayIn;
        this.precipTodayMm = precipTodayMm;
        this.pressureHpa = pressureHpa;
        this.pressureInhg = pressureInhg;
        this.pressureMB = pressureMB;
        this.relativeHumidity = relativeHumidity;
        this.reportDate = reportDate;
        this.reportDateLocale = reportDateLocale;
        this.solarRadiation = solarRadiation;
        this.tempC = tempC;
        this.tempF = tempF;
        this.uvIndex = uvIndex;
        this.windDegrees = windDegrees;
        this.windDir = windDir;
        this.windGustKmh = windGustKmh;
        this.windGustMph = windGustMph;
        this.windSpeedKmh = windSpeedKmh;
        this.windSpeedMph = windSpeedMph;
        this.windchillC = windchillC;
        this.windchillF = windchillF;
    }

    public long getDewpointC() {
        return dewpointC;
    }

    public void setDewpointC(long value) {
        this.dewpointC = value;
    }

    public long getDewpointF() {
        return dewpointF;
    }

    public void setDewpointF(long value) {
        this.dewpointF = value;
    }

    public double getHeatIndexC() {
        return heatIndexC;
    }

    public void setHeatIndexC(double value) {
        this.heatIndexC = value;
    }

    public double getHeatIndexF() {
        return heatIndexF;
    }

    public void setHeatIndexF(double value) {
        this.heatIndexF = value;
    }

    public long getPrecipRateInh() {
        return precipRateInh;
    }

    public void setPrecipRateInh(long value) {
        this.precipRateInh = value;
    }

    public long getPrecipRateMmh() {
        return precipRateMmh;
    }

    public void setPrecipRateMmh(long value) {
        this.precipRateMmh = value;
    }

    public double getPrecipTodayIn() {
        return precipTodayIn;
    }

    public void setPrecipTodayIn(double value) {
        this.precipTodayIn = value;
    }

    public double getPrecipTodayMm() {
        return precipTodayMm;
    }

    public void setPrecipTodayMm(double value) {
        this.precipTodayMm = value;
    }

    public double getPressureHpa() {
        return pressureHpa;
    }

    public void setPressureHpa(double value) {
        this.pressureHpa = value;
    }

    public double getPressureInhg() {
        return pressureInhg;
    }

    public void setPressureInhg(double value) {
        this.pressureInhg = value;
    }

    public double getPressureMB() {
        return pressureMB;
    }

    public void setPressureMB(double value) {
        this.pressureMB = value;
    }

    public long getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(long value) {
        this.relativeHumidity = value;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String value) {
        this.reportDate = value;
    }

    public String getReportDateLocale() {
        return reportDateLocale;
    }

    public void setReportDateLocale(String value) {
        this.reportDateLocale = value;
    }

    public long getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(long value) {
        this.solarRadiation = value;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double value) {
        this.tempC = value;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double value) {
        this.tempF = value;
    }

    public long getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(long value) {
        this.uvIndex = value;
    }

    public long getWindDegrees() {
        return windDegrees;
    }

    public void setWindDegrees(long value) {
        this.windDegrees = value;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String value) {
        this.windDir = value;
    }

    public double getWindGustKmh() {
        return windGustKmh;
    }

    public void setWindGustKmh(double value) {
        this.windGustKmh = value;
    }

    public double getWindGustMph() {
        return windGustMph;
    }

    public void setWindGustMph(double value) {
        this.windGustMph = value;
    }

    public long getWindSpeedKmh() {
        return windSpeedKmh;
    }

    public void setWindSpeedKmh(long value) {
        this.windSpeedKmh = value;
    }

    public long getWindSpeedMph() {
        return windSpeedMph;
    }

    public void setWindSpeedMph(long value) {
        this.windSpeedMph = value;
    }

    public double getWindchillC() {
        return windchillC;
    }

    public void setWindchillC(double value) {
        this.windchillC = value;
    }

    public double getWindchillF() {
        return windchillF;
    }

    public void setWindchillF(double value) {
        this.windchillF = value;
    }
}