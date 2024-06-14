package br.com.uniamerica.agendaja.agendaja_api.controller;

import br.com.uniamerica.agendaja.agendaja_api.entity.Dashboard;
import br.com.uniamerica.agendaja.agendaja_api.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dashboards")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public List<Dashboard> getAllDashboards() {
        return dashboardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dashboard> getDashboardById(@PathVariable Long id) {
        Optional<Dashboard> dashboard = dashboardService.findById(id);
        return dashboard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dashboard createDashboard(@RequestBody Dashboard dashboard) {
        return dashboardService.save(dashboard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dashboard> updateDashboard(@PathVariable Long id, @RequestBody Dashboard dashboardDetails) {
        Optional<Dashboard> dashboardOptional = dashboardService.findById(id);
        if (!dashboardOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Dashboard dashboard = dashboardOptional.get();
        // Atualize os campos do dashboard conforme necessário
        dashboard.setAdministrador(dashboardDetails.getAdministrador());

        Dashboard updatedDashboard = dashboardService.save(dashboard);
        return ResponseEntity.ok(updatedDashboard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable Long id) {
        Optional<Dashboard> dashboard = dashboardService.findById(id);
        if (!dashboard.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        dashboardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}