package br.com.giorni.giorniclientesgerenciamento.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Endereco {

    @Id
    @Column(unique = true, nullable = false, name = "ID_Endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "CEP", length = 10)
    private String cep;
    @Column(nullable = false, name = "Rua", length = 100)
    private String rua;
    @Column(nullable = false, name = "Bairro", length = 100)
    private String bairro;
    @Column(nullable = false, name = "Cidade", length = 50)
    private String cidade;
    @Column(nullable = false, name = "Estado", length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente")
    private Cliente cliente;
}
