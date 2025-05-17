package br.com.projeto_integrador.estoque.helpers.mappers;

import br.com.projeto_integrador.estoque.boundaries.dto.request.CategoriaRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.CategoriaResponse;
import br.com.projeto_integrador.estoque.boundaries.dto.response.ProdutoResponse;
import br.com.projeto_integrador.estoque.models.CategoriaEntity;
import br.com.projeto_integrador.estoque.models.ProdutoEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface CategoriaMapper {

    CategoriaEntity toEntity(CategoriaRequest request);

    CategoriaResponse categoriaToResponse(CategoriaEntity entity);
}
