package br.com.projeto_integrador.estoque.helpers.mappers;

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
public interface ProdutoMapper {

    @Named("toResponse")
    @Mapping(source = "categoria", target = "categoria", qualifiedByName = "categoriaToResponse")
    ProdutoResponse toResponse(ProdutoEntity entity);

    @IterableMapping(qualifiedByName = "toResponse")
    List<ProdutoResponse> toListResponse(List<ProdutoEntity> entity);

    ProdutoEntity requestToEntity(ProdutoRequest request);

    @Named("categoriaToResponse")
    CategoriaResponse categoriaToResponse(CategoriaEntity entity);

}
