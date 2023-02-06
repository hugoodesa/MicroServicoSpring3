package br.localiza.aluguelcarros.service;

import br.localiza.aluguelcarros.DTO.CarroDTO;
import br.localiza.aluguelcarros.model.Carro;
import br.localiza.aluguelcarros.repository.CarroRepository;
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

@Service
public class CarroService implements BasicService<CarroDTO> {

    @Autowired
    CarroRepository carroRepository;


    @Override
    @Transactional
    public ResponseEntity post(CarroDTO body, UriComponentsBuilder uriBuilder) {
        var carro = carroRepository.save(new Carro(body));
        URI uri = uriBuilder.path("carros/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).body(new CarroDTO(carro));
    }

    @Override
    @Transactional
    public ResponseEntity delete(Long id) {
        carroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity select(Long id) {
        var carro = carroRepository.getReferenceById(id);
        return ResponseEntity.ok(new CarroDTO(carro));
    }

    @Override
    public Page<CarroDTO> selectAll(@PageableDefault(size = 10 ,sort = {"placa"}) Pageable page) {
        var carros = this.carroRepository.findAll();

        return new PageImpl<>(carros.stream().map(CarroDTO::new).toList());
    }

    @Override
    @Transactional
    public ResponseEntity put(Long id, CarroDTO carroDto) {

        Carro carro = this.carroRepository.getReferenceById(id);
        carro.atualizar(carroDto);

        return ResponseEntity.ok(new CarroDTO(carro));
    }
}
