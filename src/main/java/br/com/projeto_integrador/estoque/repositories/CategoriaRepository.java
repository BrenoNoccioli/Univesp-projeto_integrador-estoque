package br.com.projeto_integrador.estoque.repositories;

import br.com.projeto_integrador.estoque.models.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
