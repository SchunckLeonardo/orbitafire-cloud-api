package br.com.fiap.orbitafire.orbitafirecloudapi.service;

import br.com.fiap.orbitafire.orbitafirecloudapi.dto.AlertSimulationRequest;
import br.com.fiap.orbitafire.orbitafirecloudapi.dto.AlertSimulationResponse;
import br.com.fiap.orbitafire.orbitafirecloudapi.dto.RegionRiskResponse;
import br.com.fiap.orbitafire.orbitafirecloudapi.model.RiskLevel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegionRiskService {

    public List<RegionRiskResponse> findAllRegions() {
        return List.of(
                new RegionRiskResponse(
                        1L,
                        "Amazônia - Setor Norte",
                        "Sentinel-2 / NASA FIRMS",
                        38.5,
                        22,
                        0.31,
                        RiskLevel.HIGH,
                        List.of("ODS 13", "ODS 11", "ODS 9"),
                        LocalDateTime.now()
                ),
                new RegionRiskResponse(
                        2L,
                        "Cerrado - Setor Central",
                        "INPE / CBERS",
                        41.2,
                        18,
                        0.22,
                        RiskLevel.CRITICAL,
                        List.of("ODS 13", "ODS 15", "ODS 9"),
                        LocalDateTime.now()
                ),
                new RegionRiskResponse(
                        3L,
                        "Mata Atlântica - Setor Sul",
                        "Copernicus Sentinel",
                        27.4,
                        64,
                        0.72,
                        RiskLevel.LOW,
                        List.of("ODS 13", "ODS 11"),
                        LocalDateTime.now()
                )
        );
    }

    public RegionRiskResponse findById(Long id) {
        return findAllRegions()
                .stream()
                .filter(region -> region.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Região não encontrada"));
    }

    public AlertSimulationResponse simulateAlert(AlertSimulationRequest request) {
        RiskLevel riskLevel = calculateRisk(
                request.temperature(),
                request.humidity(),
                request.vegetationIndex()
        );

        String recommendation = switch (riskLevel) {
            case LOW -> "Monitoramento normal. Nenhuma ação imediata necessária.";
            case MEDIUM -> "Acompanhar evolução climática e manter região em observação.";
            case HIGH -> "Emitir alerta preventivo para equipes ambientais.";
            case CRITICAL -> "Acionar protocolo emergencial de resposta a queimadas.";
        };

        return new AlertSimulationResponse(
                request.region(),
                riskLevel,
                recommendation,
                LocalDateTime.now()
        );
    }

    private RiskLevel calculateRisk(Double temperature, Integer humidity, Double vegetationIndex) {
        if (temperature >= 40 && humidity <= 20 && vegetationIndex <= 0.30) {
            return RiskLevel.CRITICAL;
        }

        if (temperature >= 35 && humidity <= 30 && vegetationIndex <= 0.45) {
            return RiskLevel.HIGH;
        }

        if (temperature >= 30 && humidity <= 45) {
            return RiskLevel.MEDIUM;
        }

        return RiskLevel.LOW;
    }
}