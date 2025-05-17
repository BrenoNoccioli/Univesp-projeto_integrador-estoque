package br.com.projeto_integrador.estoque.repositories;

import br.com.projeto_integrador.estoque.models.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
