package com.agsr.monitor_sensors_statistics.service.impl;

import com.agsr.monitor_sensors_statistics.domain.Sensor;
import com.agsr.monitor_sensors_statistics.domain.SensorAnalyzer;
import com.agsr.monitor_sensors_statistics.repository.SensorAnalyzerRepository;
import com.agsr.monitor_sensors_statistics.service.SensorAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorAnalyzerServiceImpl implements SensorAnalyzerService {

    private final SensorAnalyzerRepository sensorAnalyzerRepository;

    @Override
    public List<SensorAnalyzer> generateStatistics(List<Sensor> sensors) {
        Map<String, Long> sensorCountByType = sensors.stream()
                .collect(Collectors.groupingBy(sensor ->
                        sensor.getType().getName(), Collectors.counting())
                );
        List<SensorAnalyzer> statistics = new ArrayList<>();
        sensorCountByType.forEach((type, count) -> {
            SensorAnalyzer analyzer = new SensorAnalyzer();
            analyzer.setSensorType(type);
            analyzer.setSensorCount(count);
            analyzer.setCreatedAt(LocalDateTime.now());
            analyzer = sensorAnalyzerRepository.save(analyzer);
            statistics.add(analyzer);
        });
        SensorAnalyzer totalAnalyzer = new SensorAnalyzer();
        totalAnalyzer.setSensorType("Total");
        totalAnalyzer.setSensorCount((long) sensors.size());
        totalAnalyzer.setCreatedAt(LocalDateTime.now());
        totalAnalyzer = sensorAnalyzerRepository.save(totalAnalyzer);
        statistics.add(totalAnalyzer);
        return statistics;
    }

    @Override
    public List<SensorAnalyzer> findByCreatedAtBetween(LocalDateTime startDate,
                                                     LocalDateTime endDate) {
        return sensorAnalyzerRepository.findByCreatedAtBetween(startDate, endDate);
    }

}
