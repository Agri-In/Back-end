package com.audit.agriin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class AgriInApplication {

    public static void main(String[] args) {

        createLogsDirectory();
        SpringApplication.run(AgriInApplication.class, args);
    }

    private static void createLogsDirectory() {
        Path path = Paths.get("logs");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
