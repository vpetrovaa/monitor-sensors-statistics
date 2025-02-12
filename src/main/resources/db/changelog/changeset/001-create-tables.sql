--liquibase formatted sql

--changeset vpetrovaa:001-create-table

create table sensor_statistics (
    id bigserial primary key,
    sensor_type varchar(255) not null,
    sensor_count int not null,
    created_at timestamp not null default current_timestamp
);

CREATE INDEX idx_created_at ON sensor_statistics (created_at);