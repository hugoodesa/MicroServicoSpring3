package br.localiza.aluguelcarros.repository;

import br.localiza.aluguelcarros.model.Alocacao;
import br.localiza.aluguelcarros.model.StatusAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

    //Duas maneiras de fazer a busca com Refence e JPQL
    //List<Optional<Alocacao>> findByCarro_IdAndStatusAlocaco(Long idCarro, StatusAlocacao statusAlocaco);

    @Query(value = "SELECT A FROM Alocacao A WHERE A.carro.id = ?1 AND cast(A.statusAlocaco as string ) ilike ?2")
    List<Optional<Alocacao>> buscarCarroPorAlocacao(Long idCarro, String statusAlocaco);
}