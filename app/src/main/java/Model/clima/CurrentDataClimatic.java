package Model.clima;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class CurrentDataClimatic {
    private long dewpointC;
    private double dewpointF;
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
    private double solarRadiation;
    private double tempC;
    private double tempF;
    private long uvIndex;
    private long windDegrees;
    private String windDir;
    private double windGustKmh;
    private long windGustMph;
    private double windSpeedKmh;
    private double windSpeedMph;
    private double windchillC;
    private double windchillF;

    @JsonProperty("dewpoint_c")
    public long getDewpointC() { return dewpointC; }
    @JsonProperty("dewpoint_c")
    public void setDewpointC(long value) { this.dewpointC = value; }

    @JsonProperty("dewpoint_f")
    public double getDewpointF() { return dewpointF; }
    @JsonProperty("dewpoint_f")
    public void setDewpointF(double value) { this.dewpointF = value; }

    @JsonProperty("heat_index_c")
    public double getHeatIndexC() { return heatIndexC; }
    @JsonProperty("heat_index_c")
    public void setHeatIndexC(double value) { this.heatIndexC = value; }

    @JsonProperty("heat_index_f")
    public double getHeatIndexF() { return heatIndexF; }
    @JsonProperty("heat_index_f")
    public void setHeatIndexF(double value) { this.heatIndexF = value; }

    @JsonProperty("precip_rate_inh")
    public long getPrecipRateInh() { return precipRateInh; }
    @JsonProperty("precip_rate_inh")
    public void setPrecipRateInh(long value) { this.precipRateInh = value; }

    @JsonProperty("precip_rate_mmh")
    public long getPrecipRateMmh() { return precipRateMmh; }
    @JsonProperty("precip_rate_mmh")
    public void setPrecipRateMmh(long value) { this.precipRateMmh = value; }

    @JsonProperty("precip_today_in")
    public double getPrecipTodayIn() { return precipTodayIn; }
    @JsonProperty("precip_today_in")
    public void setPrecipTodayIn(double value) { this.precipTodayIn = value; }

    @JsonProperty("precip_today_mm")
    public double getPrecipTodayMm() { return precipTodayMm; }
    @JsonProperty("precip_today_mm")
    public void setPrecipTodayMm(double value) { this.precipTodayMm = value; }

    @JsonProperty("pressure_hpa")
    public double getPressureHpa() { return pressureHpa; }
    @JsonProperty("pressure_hpa")
    public void setPressureHpa(double value) { this.pressureHpa = value; }

    @JsonProperty("pressure_inhg")
    public double getPressureInhg() { return pressureInhg; }
    @JsonProperty("pressure_inhg")
    public void setPressureInhg(double value) { this.pressureInhg = value; }

    @JsonProperty("pressure_mb")
    public double getPressureMB() { return pressureMB; }
    @JsonProperty("pressure_mb")
    public void setPressureMB(double value) { this.pressureMB = value; }

    @JsonProperty("relative_humidity")
    public long getRelativeHumidity() { return relativeHumidity; }
    @JsonProperty("relative_humidity")
    public void setRelativeHumidity(long value) { this.relativeHumidity = value; }

    @JsonProperty("report_date")
    public String getReportDate() { return reportDate; }
    @JsonProperty("report_date")
    public void setReportDate(String value) { this.reportDate = value; }

    @JsonProperty("report_date_locale")
    public String getReportDateLocale() { return reportDateLocale; }
    @JsonProperty("report_date_locale")
    public void setReportDateLocale(String value) { this.reportDateLocale = value; }

    @JsonProperty("solar_radiation")
    public double getSolarRadiation() { return solarRadiation; }
    @JsonProperty("solar_radiation")
    public void setSolarRadiation(double value) { this.solarRadiation = value; }

    @JsonProperty("temp_c")
    public double getTempC() { return tempC; }
    @JsonProperty("temp_c")
    public void setTempC(double value) { this.tempC = value; }

    @JsonProperty("temp_f")
    public double getTempF() { return tempF; }
    @JsonProperty("temp_f")
    public void setTempF(double value) { this.tempF = value; }

    @JsonProperty("uv_index")
    public long getUvIndex() { return uvIndex; }
    @JsonProperty("uv_index")
    public void setUvIndex(long value) { this.uvIndex = value; }

    @JsonProperty("wind_degrees")
    public long getWindDegrees() { return windDegrees; }
    @JsonProperty("wind_degrees")
    public void setWindDegrees(long value) { this.windDegrees = value; }

    @JsonProperty("wind_dir")
    public String getWindDir() { return windDir; }
    @JsonProperty("wind_dir")
    public void setWindDir(String value) { this.windDir = value; }

    @JsonProperty("wind_gust_kmh")
    public double getWindGustKmh() { return windGustKmh; }
    @JsonProperty("wind_gust_kmh")
    public void setWindGustKmh(double value) { this.windGustKmh = value; }

    @JsonProperty("wind_gust_mph")
    public long getWindGustMph() { return windGustMph; }
    @JsonProperty("wind_gust_mph")
    public void setWindGustMph(long value) { this.windGustMph = value; }

    @JsonProperty("wind_speed_kmh")
    public double getWindSpeedKmh() { return windSpeedKmh; }
    @JsonProperty("wind_speed_kmh")
    public void setWindSpeedKmh(double value) { this.windSpeedKmh = value; }

    @JsonProperty("wind_speed_mph")
    public double getWindSpeedMph() { return windSpeedMph; }
    @JsonProperty("wind_speed_mph")
    public void setWindSpeedMph(double value) { this.windSpeedMph = value; }

    @JsonProperty("windchill_c")
    public double getWindchillC() { return windchillC; }
    @JsonProperty("windchill_c")
    public void setWindchillC(double value) { this.windchillC = value; }

    @JsonProperty("windchill_f")
    public double getWindchillF() { return windchillF; }
    @JsonProperty("windchill_f")
    public void setWindchillF(double value) { this.windchillF = value; }
}