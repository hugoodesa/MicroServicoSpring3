package br.localiza.aluguelcarros.DTO;

import br.localiza.aluguelcarros.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String nome;
    private BigDecimal valorPagar;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.valorPagar = cliente.getValorPagar();
    }
}
