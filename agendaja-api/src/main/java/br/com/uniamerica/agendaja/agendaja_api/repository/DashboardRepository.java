package br.com.uniamerica.agendaja.agendaja_api.repository;

import br.com.uniamerica.agendaja.agendaja_api.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

}