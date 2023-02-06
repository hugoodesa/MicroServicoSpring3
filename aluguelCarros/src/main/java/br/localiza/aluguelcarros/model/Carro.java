package br.localiza.aluguelcarros.model;

import br.localiza.aluguelcarros.DTO.CarroDTO;
import br.localiza.aluguelcarros.enums.StatusCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "carros")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private BigDecimal kilometragem;

    @Enumerated(EnumType.STRING)
    private StatusCarro status;

    public Carro(Long id) {
        this.id = id;
    }

    public Carro(CarroDTO carroDTO) {
        this.placa = carroDTO.getPlaca();
        this.marca = carroDTO.getMarca();
        this.modelo = carroDTO.getModelo();
        this.kilometragem = carroDTO.getKilometragem();
        this.status = carroDTO.getStatus();
    }

    public void alterarKilometragem(BigDecimal valorRodado) {
        this.kilometragem = this.kilometragem.add(valorRodado);
    }

    public Boolean isCarroDisponivel() {
        return this.status.equals(StatusCarro.DISPONIVEL);
    }

    public void atualizar(CarroDTO carroDto) {
        this.kilometragem = carroDto.getKilometragem();
        this.marca = carroDto.getMarca();
        this.modelo = carroDto.getModelo();
        this.placa = carroDto.getPlaca();
        this.status = carroDto.getStatus();
    }
}
