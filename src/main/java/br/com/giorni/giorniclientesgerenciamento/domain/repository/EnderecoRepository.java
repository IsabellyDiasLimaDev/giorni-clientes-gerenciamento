package br.com.giorni.giorniclientesgerenciamento.domain.repository;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Cliente;
import br.com.giorni.giorniclientesgerenciamento.domain.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByCliente(Cliente cliente);
}
