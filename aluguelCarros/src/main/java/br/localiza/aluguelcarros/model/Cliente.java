package br.localiza.aluguelcarros.model;

import br.localiza.aluguelcarros.DTO.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "clientes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valorPagar;

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.getNome();
        this.valorPagar = clienteDTO.getValorPagar();
    }

    public Boolean isClienteSemDividas (){
        return this.valorPagar.compareTo(BigDecimal.ZERO) == 0;
    }

    public void atualizar(ClienteDTO clienteDto) {
        this.nome = clienteDto.getNome();
        this.valorPagar = clienteDto.getValorPagar();
    }
}
