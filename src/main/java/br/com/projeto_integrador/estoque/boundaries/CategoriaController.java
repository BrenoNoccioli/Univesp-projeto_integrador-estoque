package br.com.projeto_integrador.estoque.boundaries;

import br.com.projeto_integrador.estoque.boundaries.dto.request.CategoriaRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.CategoriaResponse;
import br.com.projeto_integrador.estoque.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaResponse> postCategoria(@RequestBody CategoriaRequest request){
        CategoriaResponse categoria = service.persistirCategoria(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }
}
