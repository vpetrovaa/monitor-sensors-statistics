package com.agsr.monitor_sensors_statistics.web.controller;

import com.agsr.monitor_sensors_statistics.domain.SensorAnalyzer;
import com.agsr.monitor_sensors_statistics.service.SensorAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistics")
public class SensorAnalyzerController {

    private final SensorAnalyzerService sensorAnalyzerService;

    @GetMapping("/range")
    public List<SensorAnalyzer> getStatistics(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate) {
        return sensorAnalyzerService.findByCreatedAtBetween(startDate, endDate);
    }

}
