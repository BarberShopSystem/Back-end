package br.com.uniamerica.agendaja.agendaja_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.uniamerica.agendaja.agendaja_api.entity.Administrador;
import br.com.uniamerica.agendaja.agendaja_api.repository.AdministradorRepository;
import jakarta.transaction.Transactional;

@Service
public class AdministradorService {
 
    @Autowired
    public AdministradorRepository administradorRepository;

    @Transactional
    public Administrador save(Administrador administrador){
        return this.administradorRepository.save(administrador);
    }

    public List<Administrador> findAll(){
        return this.administradorRepository.findByAdministradoresAtivos();
    }

    @Transactional
    public void atualizarGeral(final Long id,final Administrador administrador) {
        if (id.equals(administrador.getId()) && !this.administradorRepository.findById(id).isEmpty()) {
            this.administradorRepository.save(administrador);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id){
        if (!this.administradorRepository.findById(id).isEmpty()){
            this.administradorRepository.deleteById(id);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}