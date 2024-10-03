package br.com.giorni.giorniclientesgerenciamento.domain.repository;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
