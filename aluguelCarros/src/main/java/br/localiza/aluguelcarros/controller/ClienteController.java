package br.localiza.aluguelcarros.controller;

import br.localiza.aluguelcarros.DTO.ClienteDTO;
import br.localiza.aluguelcarros.service.BasicService;
import br.localiza.aluguelcarros.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends BasicController<ClienteDTO> {

    @Autowired
    private ClienteService service;

    public ClienteController(ClienteService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ClienteDTO body, UriComponentsBuilder uriBuilder){
        return this.service.post(body, uriBuilder);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return this.service.delete(id);
    };

    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Long id){
        return this.service.select(id);
    };

    @GetMapping
    public Page<ClienteDTO> selectAll(Pageable page){
        return this.service.selectAll(page);
    };

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody ClienteDTO body){
        return this.service.put(id, body);
    };
}
