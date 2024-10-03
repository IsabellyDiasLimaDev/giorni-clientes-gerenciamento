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
public class Cliente {

    @Id
    @Column(unique = true, nullable = false, name = "ID_Cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, name = "Nome", nullable = false)
    private String nome;

    @Column(length = 15, nullable = true, name = "Telefone")
    private String telefone;

    @Column(length = 100, nullable = true, name = "Email")
    private String email;


}
