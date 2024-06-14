package br.com.uniamerica.agendaja.agendaja_api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.uniamerica.agendaja.agendaja_api.entity.Barbeiro;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {

    @Query("SELECT barbeiro FROM Barbeiro barbeiro WHERE barbeiro.ativo = true")
    public List<Barbeiro> findByBarbeirosAtivos();

    @Query(value = "select * from agendaja.tb_barbeiros where id = id", nativeQuery = true)
    public Optional<Barbeiro> findById(@Param("id") final Long id);
}
