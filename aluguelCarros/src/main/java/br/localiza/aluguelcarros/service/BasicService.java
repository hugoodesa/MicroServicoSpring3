package br.localiza.aluguelcarros.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface BasicService <DTO>{

    public ResponseEntity post(DTO body, UriComponentsBuilder uriBuilder);

    public ResponseEntity delete(Long id);

    public ResponseEntity select(Long id);

    public Page<DTO> selectAll(Pageable page);

    public ResponseEntity put(Long id, DTO body);

}
