package br.localiza.financeiro.dto;

import br.localiza.financeiro.enums.TipoTransacao;
import br.localiza.financeiro.model.Transacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransacaoDTO {

    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,locale = "pt-BR",pattern = "dd/MM/yyyy")
    private LocalDate data;

    private TipoTransacao tipoTransacao;

    public TransacaoDTO(Transacao transacao) {
        this.valor = transacao.getValor();
        this.data = transacao.getData();
        this.tipoTransacao = transacao.getTipoTransacao();
    }

}
