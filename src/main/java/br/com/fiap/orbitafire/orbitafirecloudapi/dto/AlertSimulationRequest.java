package br.com.fiap.orbitafire.orbitafirecloudapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlertSimulationRequest(
        @NotBlank
        String region,

        @NotNull
        Double temperature,

        @NotNull
        @Min(0)
        @Max(100)
        Integer humidity,

        @NotNull
        @Min(0)
        @Max(1)
        Double vegetationIndex
) {
}