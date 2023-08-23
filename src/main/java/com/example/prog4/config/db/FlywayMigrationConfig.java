package com.example.prog4.config.db;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class FlywayMigrationConfig {

    private final DataSource cnapsDataSource;
    private final DataSource employeeDataSource;

    public FlywayMigrationConfig(DataSource employeeDataSource, @Qualifier("cnapsEmployeeDataSource") DataSource cnapsDataSource) {
        this.cnapsDataSource = cnapsDataSource;
        this.employeeDataSource = employeeDataSource;
    }

    @PostConstruct
    public void migrate() {
        runFlywayMigration(this.employeeDataSource, "classpath:/db/migration/employee");
        runFlywayMigration(this.cnapsDataSource, "classpath:/db/migration/cnaps");
    }

    private void runFlywayMigration(DataSource dataSource, String location) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations(location)
                .load();
        flyway.migrate();
    }
}