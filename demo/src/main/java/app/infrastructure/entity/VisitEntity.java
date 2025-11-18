package app.infrastructure.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "visit")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long patientToVisitDocument;

    @Column(nullable = false)
    private Date visitDate;

    @Column
    private Double bloodPressure;

    @Column
    private Double temperature;

    @Column
    private Double heartRate;

    @Column
    private Double bloodOxigenLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientToVisitDocument() {
        return patientToVisitDocument;
    }

    public void setPatientToVisitDocument(Long patientToVisitDocument) {
        this.patientToVisitDocument = patientToVisitDocument;
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
