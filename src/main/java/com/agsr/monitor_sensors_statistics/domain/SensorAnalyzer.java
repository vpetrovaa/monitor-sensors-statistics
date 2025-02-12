package com.agsr.monitor_sensors_statistics.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensor_statistics")
public class SensorAnalyzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sensor_type", nullable = false)
    private String sensorType;

    @Column(name = "sensor_count", nullable = false)
    private Long sensorCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
