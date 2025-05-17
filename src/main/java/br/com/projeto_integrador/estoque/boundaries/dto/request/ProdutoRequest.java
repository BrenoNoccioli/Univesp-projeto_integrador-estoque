package br.com.projeto_integrador.estoque.boundaries.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
public class ProdutoRequest {
    @NotBlank
    private String nome;

    @NotNull
    private Long categoriaId;

    @Positive
    @NotNull
    private BigDecimal valor;

    @NotNull
    private Long quantidade;

    public ProdutoRequest(){}

    public ProdutoRequest(String nome, Long categoriaId, BigDecimal valor, Long quantidade) {
        this.nome = nome;
        this.categoriaId = categoriaId;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Long getQuantidade() {
        return quantidade;
    }


}