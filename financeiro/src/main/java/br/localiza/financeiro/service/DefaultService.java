package br.localiza.financeiro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface DefaultService<DTO> {

    public ResponseEntity post(DTO dto, UriComponentsBuilder uriBuilder) throws Exception;

    public ResponseEntity delete(Long id);

    public ResponseEntity select(Long id);

    public Page<DTO> selectAll(Pageable pageable);

    public ResponseEntity update(Long id,DTO dto);

}
