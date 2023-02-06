package br.localiza.aluguelcarros.service;

import br.localiza.aluguelcarros.DTO.AlocacaoDTO;
import br.localiza.aluguelcarros.DTO.TransacaoFinaceiraDTO;
import br.localiza.aluguelcarros.client.FinanceiroClient;
import br.localiza.aluguelcarros.model.Alocacao;
import br.localiza.aluguelcarros.model.StatusAlocacao;
import br.localiza.aluguelcarros.repository.AlocacaoRepository;
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
import java.util.List;
import java.util.Optional;

@Service
public class AlocacaoService implements BasicService<AlocacaoDTO> {

    @Autowired
    AlocacaoRepository alocacaoRepository;

    @Autowired
    FinanceiroClient financeiroClient;


    @Override
    @Transactional
    public ResponseEntity post(AlocacaoDTO body, UriComponentsBuilder uriBuilder) {

        List<Optional<Alocacao>> buscaAlocacao = alocacaoRepository.buscarCarroPorAlocacao(body.getCarro().getId(), StatusAlocacao.ABERTA.getValor());

        if(!buscaAlocacao.isEmpty() && buscaAlocacao.stream().findFirst().get().isPresent()){
            return ResponseEntity.badRequest().body("O carro já se encontra alocado");
        }


        var alocacao = alocacaoRepository.save(new Alocacao(body));
        URI uri = uriBuilder.path("alocacaos/{id}").buildAndExpand(alocacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlocacaoDTO(alocacao));
    }

    @Override
    @Transactional
    public ResponseEntity delete(Long id) {
        alocacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity select(Long id) {
        var alocacao = alocacaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new AlocacaoDTO(alocacao));
    }

    @Override
    public Page<AlocacaoDTO> selectAll(@PageableDefault(size = 10) Pageable page) {
        var alocacaos = this.alocacaoRepository.findAll();

        return new PageImpl<>(alocacaos.stream().map(AlocacaoDTO::new).toList());
    }

    @Override
    @Transactional
    public ResponseEntity put(Long id, AlocacaoDTO alocacaoDto) {

        Alocacao alocacao = this.alocacaoRepository.getReferenceById(id);
        alocacao.atualizar(alocacaoDto);

        return ResponseEntity.ok(new AlocacaoDTO(alocacao));
    }

    @Transactional
    public ResponseEntity registrarTransacao(TransacaoFinaceiraDTO valor){
        financeiroClient.cadastrarTransacao(valor);
        return ResponseEntity.ok().build();
    }
}
