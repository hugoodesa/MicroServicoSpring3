package br.localiza.financeiro.controller;

import br.localiza.financeiro.dto.TransacaoDTO;
import br.localiza.financeiro.dto.TransacaoFinaceiraDTO;
import br.localiza.financeiro.service.DefaultService;
import br.localiza.financeiro.service.TransacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController extends BasicController<TransacaoDTO> {

    @Autowired
    TransacaoService transacaoService;

    public FinanceiroController(DefaultService service) {
        super(service);
    }

    @Override
    @PostMapping
    public ResponseEntity post(@RequestBody TransacaoDTO transacaoDTO, UriComponentsBuilder uriBuilder) throws Exception {
        return super.post(transacaoDTO, uriBuilder);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @GetMapping
    public Page selectAll(@PageableDefault(sort = "data" , size = 10 ,direction = Sort.Direction.ASC) Pageable pageable) {
        return super.selectAll(pageable);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity select(@PathVariable Long id) {
        return super.select(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody TransacaoDTO transacaoDTO) {
        return super.update(id, transacaoDTO);
    }

    @PostMapping("/contaReceber")
    @Transactional
    public ResponseEntity cadastrarContaReceber(@RequestBody TransacaoFinaceiraDTO transacaoFinaceiraDTO){
        return ResponseEntity.noContent().build();
    }

}
