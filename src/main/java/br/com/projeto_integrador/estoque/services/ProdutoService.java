package br.com.projeto_integrador.estoque.services;

import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoPatchRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.request.ProdutoRequest;
import br.com.projeto_integrador.estoque.boundaries.dto.response.ProdutoResponse;
import br.com.projeto_integrador.estoque.exceptions.CategoriaNotFoundException;
import br.com.projeto_integrador.estoque.exceptions.ProdutoNotFoundException;
import br.com.projeto_integrador.estoque.helpers.mappers.ProdutoMapper;
import br.com.projeto_integrador.estoque.models.CategoriaEntity;
import br.com.projeto_integrador.estoque.models.ProdutoEntity;
import br.com.projeto_integrador.estoque.repositories.CategoriaRepository;
import br.com.projeto_integrador.estoque.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoMapper produtoMapper;
    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;


    public ProdutoResponse getProduto(Long id){
        Optional<ProdutoEntity> produto = repository.findById(id);

        if (produto.isEmpty()){
            throw ProdutoNotFoundException.create("Produto não encontrado");
        }

        return produtoMapper.toResponse(produto.get());
    }

    public List<ProdutoResponse> getAllProdutos() {
        List<ProdutoEntity> produtos = repository.findAll();
        return produtoMapper.toListResponse(produtos);
    }

    public ProdutoResponse persistirProduto(ProdutoRequest request) {
        Optional<CategoriaEntity> optionalCategoria = categoriaRepository.findById(request.getCategoriaId());

        if (optionalCategoria.isEmpty()){
            throw CategoriaNotFoundException.create("Categoria não encontrada");
        }

        CategoriaEntity categoria = optionalCategoria.get();
        ProdutoEntity produto = produtoMapper.requestToEntity(request);
        produto.setCategoria(categoria);
        ProdutoEntity persistido = repository.save(produto);

        return produtoMapper.toResponse(persistido);
    }

    public ProdutoResponse patchProduto(Long id, ProdutoPatchRequest request) {
        Optional<ProdutoEntity> old = repository.findById(id);
        if (old.isEmpty()){
            throw ProdutoNotFoundException.create("Produto não encontrado");
        }

        ProdutoEntity novo = patchProduto(old.get(), request);
        return produtoMapper.toResponse(novo);
    }

    private ProdutoEntity patchProduto(ProdutoEntity old, ProdutoPatchRequest novoProduto){
        old.setNome(novoProduto.getNome().isBlank() ? old.getNome() : novoProduto.getNome());
        old.setValor(Objects.isNull(novoProduto.getValor()) ? old.getValor() : novoProduto.getValor());
        old.setQuantidade(Objects.isNull(novoProduto.getQuantidade()) ? old.getQuantidade() : novoProduto.getQuantidade());

        return old;
    }
}
