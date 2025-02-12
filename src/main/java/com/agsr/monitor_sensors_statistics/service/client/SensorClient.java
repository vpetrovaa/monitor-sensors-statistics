package com.agsr.monitor_sensors_statistics.service.client;

import com.agsr.monitor_sensors_statistics.config.FeignConfig;
import com.agsr.monitor_sensors_statistics.domain.Sensor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "sensor", url = "http://${open.feign.host}/api/v1/sensors",
        configuration = FeignConfig.class)
public interface SensorClient {

    @GetMapping
    List<Sensor> findAll();

}
