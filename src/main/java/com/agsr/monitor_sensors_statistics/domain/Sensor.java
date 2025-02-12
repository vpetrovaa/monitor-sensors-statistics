package com.agsr.monitor_sensors_statistics.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    private Long id;
    private String name;
    private String model;
    private Integer rangeFrom;
    private Integer rangeTo;
    private Type type;
    private Unit unit;
    private String location;
    private String description;

}
