package br.localiza.aluguelcarros.DTO;

import br.localiza.aluguelcarros.enums.StatusCarro;
import br.localiza.aluguelcarros.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private String placa;
    private String marca;
    private String modelo;
    private BigDecimal kilometragem;
    private StatusCarro status;

    public CarroDTO(Carro carro) {
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.kilometragem = carro.getKilometragem();
        this.status = carro.getStatus();
    }

}
