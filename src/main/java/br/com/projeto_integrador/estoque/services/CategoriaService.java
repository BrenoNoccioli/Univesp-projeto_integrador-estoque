package br.com.projeto_integrador.estoque.services;

import br.com.projeto_integrador.estoque.boundaries.dto.request.CategoriaRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.CategoriaResponse;
import br.com.projeto_integrador.estoque.helpers.mappers.CategoriaMapper;
import br.com.projeto_integrador.estoque.models.CategoriaEntity;
import br.com.projeto_integrador.estoque.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaService {
    private  CategoriaRepository repository;
    private  CategoriaMapper mapper;

    public CategoriaResponse persistirCategoria(CategoriaRequest request){
        CategoriaEntity entity = mapper.toEntity(request);

        CategoriaEntity created = repository.save(entity);

        return mapper.categoriaToResponse(created);
    }
}
