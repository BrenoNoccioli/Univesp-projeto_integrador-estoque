package br.com.projeto_integrador.estoque.services;

import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.CategoriaResponse;
import br.com.projeto_integrador.estoque.boundaries.dto.response.ProdutoResponse;
import br.com.projeto_integrador.estoque.helpers.mappers.ProdutoMapper;
import br.com.projeto_integrador.estoque.models.CategoriaEntity;
import br.com.projeto_integrador.estoque.models.ProdutoEntity;
import br.com.projeto_integrador.estoque.repositories.CategoriaRepository;
import br.com.projeto_integrador.estoque.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {
    @Spy
    private ProdutoMapper produtoMapper;
    @Mock
    private ProdutoRepository repository;
    @Mock
    private CategoriaRepository categoriaRepository;
    @InjectMocks
    private ProdutoService service;

    @Test
    void testGetProduto() {
        Mockito.when(repository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(new ProdutoEntity(1L, "produto entity",
                        new CategoriaEntity(), BigDecimal.TEN, 10L)));

        Mockito.when(produtoMapper.toResponse(ArgumentMatchers.any(ProdutoEntity.class)))
                .thenReturn(new ProdutoResponse(1L, "teste", new CategoriaResponse(), BigDecimal.TEN, 10L));

        ProdutoResponse resp = service.getProduto(1L);

        assertNotNull(resp);
        assertEquals(1L, resp.getId());
    }

    @Test
    void testGetAllProdutos() {
        Mockito.when(repository.findAll())
                .thenReturn(List.of(new ProdutoEntity(1L, "produto entity",
                        new CategoriaEntity(), BigDecimal.TEN, 10L)));

        Mockito.when(produtoMapper.toListResponse(ArgumentMatchers.anyList()))
                .thenReturn(List.of(new ProdutoResponse(1L, "teste", new CategoriaResponse(), BigDecimal.TEN, 10L)));

        List<ProdutoResponse> resp = service.getAllProdutos();

        assertNotNull(resp);
        assertEquals(1L, resp.get(0).getId());
    }

    @Test
    void testPersistirProduto() {
        Mockito.when(categoriaRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(new CategoriaEntity(1L, "produto entity")));
        Mockito.when(repository.save(ArgumentMatchers.any(ProdutoEntity.class)))
                .thenReturn(new ProdutoEntity(1L, "produto entity",
                        new CategoriaEntity(), BigDecimal.TEN, 10L));

        Mockito.when(produtoMapper.toResponse(ArgumentMatchers.any(ProdutoEntity.class)))
                .thenReturn(new ProdutoResponse(1L, "teste", new CategoriaResponse(), BigDecimal.TEN, 10L));

        ProdutoResponse resp = service.persistirProduto(new ProdutoRequest("teste", 1L, BigDecimal.TEN, 10L));

        assertNotNull(resp);
        assertEquals(1L, resp.getId());
    }

    @Test
    void testPatchProduto() {
    }
}