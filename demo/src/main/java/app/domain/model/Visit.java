
package app.domain.model;

import java.sql.Date;

public class Visit {
    private Patient patientToVisit;
    private Date visitDate;
    private Double bloodPressure;
    private Double temperature;
    private Double heartRate;
    private Double bloodOxigenLevel;

    public Patient getPatientToVisit() {
        return patientToVisit;
    }

    public void setPatientToVisit(Patient patientToVisit) {
        this.patientToVisit = patientToVisit;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }

    public Double getBloodOxigenLevel() {
        return bloodOxigenLevel;
    }

    public void setBloodOxigenLevel(Double bloodOxigenLevel) {
        this.bloodOxigenLevel = bloodOxigenLevel;
    }
    
    
}
