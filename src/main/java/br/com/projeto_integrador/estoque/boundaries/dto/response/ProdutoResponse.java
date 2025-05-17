package br.com.projeto_integrador.estoque.boundaries.dto.response;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
public class ProdutoResponse {
    private Long id;
    private String nome;
    private CategoriaResponse categoria;
    private BigDecimal valor;
    private Long quantidade;

    public ProdutoResponse(Long id, String nome, CategoriaResponse categoria, BigDecimal valor, Long quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaResponse getCategoria() {
        return categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
