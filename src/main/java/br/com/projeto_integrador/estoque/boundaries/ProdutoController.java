package br.com.projeto_integrador.estoque.boundaries;

import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoPatchRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.ProdutoResponse;
import br.com.projeto_integrador.estoque.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getAll(){
        List<ProdutoResponse> produtos = service.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{produto_id}")
    public ResponseEntity<ProdutoResponse> getProduto(@RequestParam("produto_id") Long id){
        ProdutoResponse produto = service.getProduto(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> postProduto(@RequestBody ProdutoRequest request){
        ProdutoResponse produto = service.persistirProduto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PatchMapping("/{produto_id}")
    public ResponseEntity<ProdutoResponse> patchProduto(@RequestParam("produto_id") Long id,
                                                        @RequestBody ProdutoPatchRequest request){
        ProdutoResponse produto = service.patchProduto(id, request);
        return ResponseEntity.ok(produto);
    }
}
