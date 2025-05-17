package br.com.projeto_integrador.estoque.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    public CategoriaEntity(){}

    public CategoriaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
