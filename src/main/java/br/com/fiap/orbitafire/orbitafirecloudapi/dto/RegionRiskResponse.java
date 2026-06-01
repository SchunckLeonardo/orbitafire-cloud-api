package br.com.fiap.orbitafire.orbitafirecloudapi.dto;

import br.com.fiap.orbitafire.orbitafirecloudapi.model.RiskLevel;

import java.time.LocalDateTime;
import java.util.List;

public record RegionRiskResponse(
        Long id,
        String region,
        String satelliteSource,
        Double temperature,
        Integer humidity,
        Double vegetationIndex,
        RiskLevel riskLevel,
        List<String> ods,
        LocalDateTime analyzedAt
) {
}
