package com.agsr.monitor_sensors_statistics.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorAnalyzerDto {

    private Long id;
    private String sensorType;
    private Long sensorCount;
    private LocalDateTime createdAt;

}
