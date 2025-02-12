package com.agsr.monitor_sensors_statistics.scheduler;

import com.agsr.monitor_sensors_statistics.service.SensorAnalyzerService;
import com.agsr.monitor_sensors_statistics.service.client.SensorClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = "schedulers.sensors.enabled")
public class StatisticsScheduler {

    private final SensorClient sensorClient;
    private final SensorAnalyzerService sensorAnalyzerService;

    @Scheduled(cron = "${schedulers.sensors.statistics.every_day_2_am_cron}",
            zone = "${schedulers.sensors.statistics.zone}")
    public void generateStatistics() {
        sensorAnalyzerService.generateStatistics(sensorClient.findAll());
    }

}
