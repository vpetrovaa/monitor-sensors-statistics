package com.agsr.monitor_sensors_statistics.service;

import com.agsr.monitor_sensors_statistics.domain.Sensor;
import com.agsr.monitor_sensors_statistics.domain.SensorAnalyzer;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorAnalyzerService {

    List<SensorAnalyzer> generateStatistics(List<Sensor> sensors);

    List<SensorAnalyzer> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
