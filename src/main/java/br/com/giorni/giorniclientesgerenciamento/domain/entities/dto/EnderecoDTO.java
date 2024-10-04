package br.com.giorni.giorniclientesgerenciamento.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnderecoDTO {
    private Long id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private int idCliente;
}
