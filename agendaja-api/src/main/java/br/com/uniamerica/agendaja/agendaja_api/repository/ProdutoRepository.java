package br.com.uniamerica.agendaja.agendaja_api.repository;

import br.com.uniamerica.agendaja.agendaja_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}