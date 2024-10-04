package br.com.giorni.giorniclientesgerenciamento.service;

import br.com.giorni.giorniclientesgerenciamento.domain.entities.Cliente;
import br.com.giorni.giorniclientesgerenciamento.domain.entities.Endereco;
import br.com.giorni.giorniclientesgerenciamento.domain.entities.dto.EnderecoDTO;
import br.com.giorni.giorniclientesgerenciamento.domain.repository.ClienteRepository;
import br.com.giorni.giorniclientesgerenciamento.domain.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {


    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        return modelMapper.map(enderecoRepository.save(endereco), EnderecoDTO.class);
    }

    public List<EnderecoDTO> listarTodosOsEnderecos() {
        ModelMapper modelMapper = new ModelMapper();
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOs = new ArrayList<>();
        enderecos.forEach(endereco -> {
            enderecoDTOs.add(modelMapper.map(endereco, EnderecoDTO.class));
        });
        return enderecoDTOs;
    }

    public EnderecoDTO listarEndereco(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Endereco endereco = enderecoRepository.findById(id).get();
        return modelMapper.map(endereco, EnderecoDTO.class);
    }

    public EnderecoDTO atualizarEndereco(EnderecoDTO enderecoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Endereco endereco = enderecoRepository.findById(enderecoDTO.getId()).get();
        modelMapper.map(enderecoDTO, endereco);
        return modelMapper.map(enderecoRepository.save(endereco), EnderecoDTO.class);
    }

    public void excluirEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public List<EnderecoDTO> listarEnderecosPorCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        List<Endereco> enderecos = enderecoRepository.findByCliente(cliente);
        List<EnderecoDTO> enderecoDTOs = new ArrayList<>();
        enderecos.forEach(endereco -> {
            ModelMapper modelMapper = new ModelMapper();
            EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
            enderecoDTOs.add(enderecoDTO);
        });
        return enderecoDTOs;
    }

}
