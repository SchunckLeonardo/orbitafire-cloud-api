package br.com.fiap.orbitafire.orbitafirecloudapi.controller;

import br.com.fiap.orbitafire.orbitafirecloudapi.dto.AlertSimulationRequest;
import br.com.fiap.orbitafire.orbitafirecloudapi.dto.AlertSimulationResponse;
import br.com.fiap.orbitafire.orbitafirecloudapi.service.RegionRiskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final RegionRiskService regionRiskService;
    private final Logger logger = LoggerFactory.getLogger(AlertController.class);

    public AlertController(RegionRiskService regionRiskService) {
        this.regionRiskService = regionRiskService;
    }

    @PostMapping("/simulate")
    public AlertSimulationResponse simulate(@RequestBody @Valid AlertSimulationRequest request) {
        logger.info("Received alert simulation request: {}", request);
        return regionRiskService.simulateAlert(request);
    }
}