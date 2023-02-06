package br.localiza.aluguelcarros.model;

import br.localiza.aluguelcarros.DTO.AlocacaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Alocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_carro")
    private Carro carro;

    @Enumerated(EnumType.STRING)
    private StatusAlocacao statusAlocaco = StatusAlocacao.ABERTA;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Alocacao(AlocacaoDTO alocacaoDTO) {
        this.carro = new Carro(alocacaoDTO.getCarro().getId());
        this.cliente = new Cliente(alocacaoDTO.getCliente().getId());
    }

    public void atualizar(AlocacaoDTO alocacaoDto) {
        this.carro = new Carro(alocacaoDto.getCarro().getId());
        this.cliente = new Cliente(alocacaoDto.getCarro().getId());
    }
}
