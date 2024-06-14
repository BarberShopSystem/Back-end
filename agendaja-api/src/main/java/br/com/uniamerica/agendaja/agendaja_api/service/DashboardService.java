package br.com.uniamerica.agendaja.agendaja_api.service;

import br.com.uniamerica.agendaja.agendaja_api.entity.Dashboard;
import br.com.uniamerica.agendaja.agendaja_api.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public List<Dashboard> findAll() {
        return dashboardRepository.findAll();
    }

    public Optional<Dashboard> findById(Long id) {
        return dashboardRepository.findById(id);
    }

    public Dashboard save(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    public void deleteById(Long id) {
        dashboardRepository.deleteById(id);
    }
}