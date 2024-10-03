package br.com.giorni.giorniclientesgerenciamento.domain.repository;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
