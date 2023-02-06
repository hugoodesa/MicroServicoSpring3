package br.localiza.financeiro.model;

import br.localiza.financeiro.dto.TransacaoDTO;
import br.localiza.financeiro.enums.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,timezone = "Brazil/East",locale = "pt-BR",pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;


    public Transacao(TransacaoDTO transacaoDTO) {
        this.valor = transacaoDTO.getValor();
        this.data = transacaoDTO.getData();
        this.tipoTransacao = transacaoDTO.getTipoTransacao();
    }

    public void atualizar(TransacaoDTO transacaoDTO) {
        this.valor = transacaoDTO.getValor();
        this.data = transacaoDTO.getData();
        this.tipoTransacao = transacaoDTO.getTipoTransacao();
    }
}
