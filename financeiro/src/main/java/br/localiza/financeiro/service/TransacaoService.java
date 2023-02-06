package br.localiza.financeiro.service;

import br.localiza.financeiro.dto.TransacaoDTO;
import br.localiza.financeiro.model.Transacao;
import br.localiza.financeiro.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TransacaoService implements DefaultService<TransacaoDTO> {

    @Autowired
    private TransacaoRepository repository;

    @Override
    @Transactional
    public ResponseEntity post(TransacaoDTO transacaoDTO, UriComponentsBuilder uriBuilder) throws Exception {
        var transacao = this.repository.save(new Transacao(transacaoDTO));
        URI uri = uriBuilder.path("/transacao/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new TransacaoDTO(transacao));
    }

    @Override
    @Transactional
    public ResponseEntity delete(Long id) {
        this.repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity select(Long id) {
        var transacao = this.repository.getReferenceById(id);

        return ResponseEntity.ok(new TransacaoDTO(transacao));
    }

    @Override
    public Page<TransacaoDTO> selectAll(Pageable pageable) {
        return new PageImpl<>(this.repository.findAll(pageable).stream().map(TransacaoDTO::new).toList());
    }

    @Override
    @Transactional
    public ResponseEntity update(Long id, TransacaoDTO transacaoDTO) {
        var transacao = this.repository.getReferenceById(id);
        transacao.atualizar(transacaoDTO);

        return ResponseEntity.ok(new TransacaoDTO(transacao));
    }
}
