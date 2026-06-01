package br.com.fiap.orbitafire.orbitafirecloudapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "application", "OrbitaFire Cloud API",
                "status", "running",
                "message", "API para monitoramento de risco de queimadas com dados orbitais",
                "timestamp", LocalDateTime.now()
        );
    }

    @GetMapping("/api/health")
    public Map<String, Object> health() {
        return Map.of(
                "status", "UP",
                "service", "orbitafire-cloud-api",
                "timestamp", LocalDateTime.now()
        );
    }
}
