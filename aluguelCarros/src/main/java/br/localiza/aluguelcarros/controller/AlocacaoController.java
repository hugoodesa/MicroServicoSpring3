package br.localiza.aluguelcarros.controller;

import br.localiza.aluguelcarros.DTO.AlocacaoDTO;
import br.localiza.aluguelcarros.DTO.TransacaoFinaceiraDTO;
import br.localiza.aluguelcarros.enums.TipoTransacao;
import br.localiza.aluguelcarros.model.StatusAlocacao;
import br.localiza.aluguelcarros.service.AlocacaoService;
import br.localiza.aluguelcarros.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/alocacao")
public class AlocacaoController extends BasicController<AlocacaoDTO> {

    @Autowired
    private AlocacaoService service;

    public AlocacaoController(ClienteService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody AlocacaoDTO body, UriComponentsBuilder uriBuilder){
        this.service.registrarTransacao(new TransacaoFinaceiraDTO(LocalDate.now(),new BigDecimal(1200.0),TipoTransacao.ENTRADA));
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
    public Page<AlocacaoDTO> selectAll(Pageable page){
        return this.service.selectAll(page);
    };

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody AlocacaoDTO body){
        return this.service.put(id, body);
    };
}
