package br.localiza.aluguelcarros.repository;

import br.localiza.aluguelcarros.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}