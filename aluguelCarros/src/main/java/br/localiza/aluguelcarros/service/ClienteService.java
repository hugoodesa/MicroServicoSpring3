package br.localiza.aluguelcarros.service;

import br.localiza.aluguelcarros.DTO.ClienteDTO;
import br.localiza.aluguelcarros.model.Cliente;
import br.localiza.aluguelcarros.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ClienteService implements BasicService<ClienteDTO> {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    @Transactional
    public ResponseEntity post(ClienteDTO body, UriComponentsBuilder uriBuilder) {
        var cliente = clienteRepository.save(new Cliente(body));
        URI uri = uriBuilder.path("clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @Override
    @Transactional
    public ResponseEntity delete(Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity select(Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    @Override
    public Page<ClienteDTO> selectAll(@PageableDefault(size = 10 ,sort = {"placa"}) Pageable page) {
        var clientes = this.clienteRepository.findAll();

        return new PageImpl<>(clientes.stream().map(ClienteDTO::new).toList());
    }

    @Override
    @Transactional
    public ResponseEntity put(Long id, ClienteDTO clienteDto) {

        Cliente cliente = this.clienteRepository.getReferenceById(id);
        cliente.atualizar(clienteDto);

        return ResponseEntity.ok(new ClienteDTO(cliente));
    }
}
