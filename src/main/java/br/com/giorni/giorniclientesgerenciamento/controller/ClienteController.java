package br.com.giorni.giorniclientesgerenciamento.controller;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Cliente;
import br.com.giorni.giorniclientesgerenciamento.domain.entities.dto.ClienteDTO;
import br.com.giorni.giorniclientesgerenciamento.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO cliente = clienteService.createCliente(clienteDTO);
        ClienteDTO clienteCriado = clienteService.getClienteById(cliente.getId());
        return ResponseEntity.ok(modelMapper.map(clienteCriado, ClienteDTO.class));
    }

    @GetMapping
    public ResponseEntity<?> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO updateCliente = clienteService.updateCliente(clienteDTO);
        return ResponseEntity.ok(updateCliente);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteClienteById(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }
}
