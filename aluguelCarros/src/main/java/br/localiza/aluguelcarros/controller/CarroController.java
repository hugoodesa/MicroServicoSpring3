package br.localiza.aluguelcarros.controller;

import br.localiza.aluguelcarros.DTO.CarroDTO;
import br.localiza.aluguelcarros.service.BasicService;
import br.localiza.aluguelcarros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/carros")
public class CarroController extends BasicController<CarroDTO> {

    @Autowired
    CarroService service;

    public CarroController(CarroService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CarroDTO body, UriComponentsBuilder uriBuilder){
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
    public Page<CarroDTO> selectAll(Pageable page){
        return this.service.selectAll(page);
    };

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody CarroDTO body){
        return this.service.put(id, body);
    };
}
