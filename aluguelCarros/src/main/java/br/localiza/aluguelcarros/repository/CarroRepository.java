package br.localiza.aluguelcarros.repository;

import br.localiza.aluguelcarros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}