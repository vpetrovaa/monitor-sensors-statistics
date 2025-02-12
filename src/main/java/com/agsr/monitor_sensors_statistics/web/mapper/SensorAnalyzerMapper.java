package com.agsr.monitor_sensors_statistics.web.mapper;

import com.agsr.monitor_sensors_statistics.domain.Sensor;
import com.agsr.monitor_sensors_statistics.web.dto.SensorAnalyzerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorAnalyzerMapper {

    List<SensorAnalyzerDto> toDtoList(List<Sensor> sensors);

}
