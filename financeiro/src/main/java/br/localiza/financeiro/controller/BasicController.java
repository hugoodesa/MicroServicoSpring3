package br.localiza.financeiro.controller;

import br.localiza.financeiro.service.DefaultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class BasicController<DTO> {

    private DefaultService service;

    public BasicController(DefaultService service) {
        this.service = service;
    }

    public ResponseEntity post(DTO dto, UriComponentsBuilder uriBuilder) throws Exception{
        return this.service.post(dto, uriBuilder);
    };

    public ResponseEntity delete(Long id){
        return this.service.delete(id);
    };

    public ResponseEntity select(Long id){
        return this.service.select(id);
    };

    public Page<DTO> selectAll(Pageable pageable){
        return this.service.selectAll(pageable);
    };

    public ResponseEntity update(Long id,DTO dto){
        return this.service.update(id,dto);
    };
}
