package br.com.projeto_integrador.estoque.boundaries;

import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoPatchRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.CategoriaResponse;
import br.com.projeto_integrador.estoque.boundaries.dto.response.ProdutoResponse;
import br.com.projeto_integrador.estoque.services.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {

    @Mock
    private ProdutoService service;

    @InjectMocks
    private ProdutoController controller;

    @Test
    void testGetAll(){
        Mockito.when(service.getAllProdutos())
                .thenReturn(List.of(
                        new ProdutoResponse(1L, "produto teste",
                                new CategoriaResponse(), BigDecimal.TEN,
                                10L)));

        ResponseEntity<List<ProdutoResponse>> resp = controller.getAll();

        assertNotNull(resp);
        assertNotNull(resp.getBody());
        assertEquals(1L, resp.getBody().get(0).getId());
    }

    @Test
    void testGetProduto(){
        Mockito.when(service.getProduto(ArgumentMatchers.anyLong()))
                .thenReturn(new ProdutoResponse(1L, "produto teste",
                        new CategoriaResponse(), BigDecimal.TEN,
                        10L));

        ResponseEntity<ProdutoResponse> resp = controller.getProduto(1L);

        assertNotNull(resp);
        assertEquals(HttpStatusCode.valueOf(200), resp.getStatusCode());
        assertEquals(1L, resp.getBody().getId());
    }

    @Test
    void testPostProduto(){
        Mockito.when(service.persistirProduto(ArgumentMatchers.any(ProdutoRequest.class)))
                .thenReturn(new ProdutoResponse(1L, "produto teste",
                        new CategoriaResponse(), BigDecimal.TEN,
                        10L));

        ResponseEntity<ProdutoResponse> resp = controller.postProduto(new ProdutoRequest());

        assertNotNull(resp);
        assertEquals(HttpStatusCode.valueOf(201), resp.getStatusCode());
        assertEquals(1L, resp.getBody().getId());
    }

    @Test
    void testPatchProduto(){
        Mockito.when(service.patchProduto(ArgumentMatchers.anyLong(), ArgumentMatchers.any(ProdutoPatchRequest.class)))
                .thenReturn(new ProdutoResponse(1L, "produto teste",
                        new CategoriaResponse(), BigDecimal.TEN,
                        10L));

        ResponseEntity<ProdutoResponse> resp = controller.patchProduto(1L, new ProdutoPatchRequest());

        assertNotNull(resp);
        assertEquals(HttpStatusCode.valueOf(200), resp.getStatusCode());
        assertEquals(1L, resp.getBody().getId());
    }
}