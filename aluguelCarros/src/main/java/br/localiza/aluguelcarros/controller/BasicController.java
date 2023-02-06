package br.localiza.aluguelcarros.controller;

import br.localiza.aluguelcarros.service.BasicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class BasicController <DTO>{

    private BasicService service;

    public BasicController(BasicService service) {
        this.service = service;
    }

    public ResponseEntity post(DTO body, UriComponentsBuilder uriBuilder){
        return this.service.post(body, uriBuilder);
    };

    public ResponseEntity delete(Long id){
        return this.service.delete(id);
    };

    public ResponseEntity select(Long id){
        return this.service.select(id);
    };

    public Page<DTO> selectAll(Pageable page){
        return this.service.selectAll(page);
    };

    public ResponseEntity put(Long id, DTO body){
        return this.service.put(id, body);
    };


}
