package br.localiza.aluguelcarros.DTO;

import br.localiza.aluguelcarros.enums.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransacaoFinaceiraDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",locale = "pt-BR")
    private LocalDate data;
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;

}
