package br.com.fiap.orbitafire.orbitafirecloudapi.dto;

import br.com.fiap.orbitafire.orbitafirecloudapi.model.RiskLevel;

import java.time.LocalDateTime;

public record AlertSimulationResponse(
        String region,
        RiskLevel riskLevel,
        String recommendation,
        LocalDateTime generatedAt
) {
}