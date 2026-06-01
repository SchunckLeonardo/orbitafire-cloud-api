package br.com.fiap.orbitafire.orbitafirecloudapi.controller;

import br.com.fiap.orbitafire.orbitafirecloudapi.dto.RegionRiskResponse;
import br.com.fiap.orbitafire.orbitafirecloudapi.service.RegionRiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionRiskService regionRiskService;

    public RegionController(RegionRiskService regionRiskService) {
        this.regionRiskService = regionRiskService;
    }

    @GetMapping
    public List<RegionRiskResponse> findAll() {
        return regionRiskService.findAllRegions();
    }

    @GetMapping("/{id}")
    public RegionRiskResponse findById(@PathVariable Long id) {
        return regionRiskService.findById(id);
    }
}