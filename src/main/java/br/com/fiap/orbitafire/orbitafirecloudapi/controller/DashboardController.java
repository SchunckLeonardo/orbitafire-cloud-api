package br.com.fiap.orbitafire.orbitafirecloudapi.controller;

import br.com.fiap.orbitafire.orbitafirecloudapi.model.RiskLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class DashboardController {

    @GetMapping("/api/dashboard")
    public Map<String, Object> dashboard() {
        return Map.of(
                "monitoredRegions", 3,
                "highRiskRegions", 1,
                "criticalRiskRegions", 1,
                "mainRisk", RiskLevel.CRITICAL,
                "satelliteSources", 3,
                "cloudProvider", "AWS",
                "service", "Elastic Beanstalk",
                "lastUpdate", LocalDateTime.now()
        );
    }
}