package br.com.giorni.giorniclientesgerenciamento.controller;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Endereco;
import br.com.giorni.giorniclientesgerenciamento.domain.entities.dto.EnderecoDTO;
import br.com.giorni.giorniclientesgerenciamento.service.EnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<EnderecoDTO> salvarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoDTO = enderecoService.criarEndereco(enderecoDTO);
        return ResponseEntity.ok(enderecoDTO);
    }

    @GetMapping
    public ResponseEntity<?> listarEnderecos() {
        List<EnderecoDTO> allEnderecos = enderecoService.listarTodosOsEnderecos();
        return ResponseEntity.ok(allEnderecos);
    }

    @PutMapping
    public ResponseEntity<?> atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoDTO = enderecoService.atualizarEndereco(enderecoDTO);
        return ResponseEntity.ok(enderecoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEndereco(@PathVariable long id) {
        enderecoService.excluirEndereco(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> listarEnderecosPorClientes(@PathVariable long id) {
        List<EnderecoDTO> enderecoDTOS = enderecoService.listarEnderecosPorCliente(id);
        return ResponseEntity.ok(enderecoDTOS);
    }
}
