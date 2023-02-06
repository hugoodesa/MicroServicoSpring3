package br.localiza.aluguelcarros.DTO;

import br.localiza.aluguelcarros.model.Alocacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlocacaoDTO {

    private AlocacoCarroDTO carro;
    private AlocacoClienteDTO cliente;

    public AlocacaoDTO(Alocacao alocacao) {
        this.carro = new AlocacoCarroDTO(alocacao.getCarro().getId());
        this.cliente = new AlocacoClienteDTO(alocacao.getCliente().getId());
    }
}
