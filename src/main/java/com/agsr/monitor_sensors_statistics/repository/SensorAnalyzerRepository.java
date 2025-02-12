package com.agsr.monitor_sensors_statistics.repository;

import com.agsr.monitor_sensors_statistics.domain.SensorAnalyzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorAnalyzerRepository extends JpaRepository<SensorAnalyzer, Long> {

    List<SensorAnalyzer> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

}
