package br.com.uniamerica.agendaja.agendaja_api.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.uniamerica.agendaja.agendaja_api.entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Long>{
    
    @Query("SELECT administrador FROM Administrador administrador WHERE administrador.ativo = true")
    public List<Administrador> findByAdministradoresAtivos();

}