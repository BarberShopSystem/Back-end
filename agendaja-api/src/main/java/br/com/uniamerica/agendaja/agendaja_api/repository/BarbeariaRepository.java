package br.com.uniamerica.agendaja.agendaja_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.uniamerica.agendaja.agendaja_api.entity.Barbearia;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
    
    @Query("SELECT barbearia FROM Barbearia barbearia WHERE barbearia.ativo = true")
    public List<Barbearia> findByBarbeariasAtivas();

    @Query(value = "select * from agendaja.tb_barbearias where id = id", nativeQuery = true)
    public Optional<Barbearia> findById(@Param("id") final Long id);
}
