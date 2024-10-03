package br.com.giorni.giorniclientesgerenciamento.service;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Cliente;
import br.com.giorni.giorniclientesgerenciamento.domain.entities.dto.ClienteDTO;
import br.com.giorni.giorniclientesgerenciamento.domain.repository.ClienteRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    private ModelMapper modelMapper;

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        try {
            modelMapper = new ModelMapper();
            Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
            cliente = clienteRepository.save(cliente);
            return modelMapper.map(cliente, ClienteDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar cliente: " + e.getMessage());
        }
    }


    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        clientes.forEach(cliente -> {
            ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
            clienteDTOs.add(clienteDTO);
        });
        return clienteDTOs;
    }

    public ClienteDTO getClienteById(Long id) {
        modelMapper = new ModelMapper();
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).orElse(null);
    }

    public ClienteDTO updateCliente(ClienteDTO clienteDTO) {
        modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteDTO.getId());
        if (clienteOptional.isPresent()) {
            modelMapper.map(cliente, clienteDTO);
            cliente = clienteRepository.save(cliente);
            return modelMapper.map(cliente, ClienteDTO.class);
        }
        return null;
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
