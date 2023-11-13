package unimetrocamp.gerenciadorEstoque.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import unimetrocamp.gerenciadorEstoque.model.produto.DadosProduto;
import unimetrocamp.gerenciadorEstoque.model.produto.DadosValidacaoProduto;
import unimetrocamp.gerenciadorEstoque.model.produto.Produto;
import unimetrocamp.gerenciadorEstoque.model.produto.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*") //Consumir via codigo
public class ProdutoController {
    @Autowired
    private ProdutosRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProdutos(@RequestBody @Valid DadosValidacaoProduto dadosValidacaoProduto, UriComponentsBuilder uriComponentsBuilder){
        var produtos = new Produto(dadosValidacaoProduto);
        repository.save(produtos);
        var uri =uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produtos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosProduto(produtos));
    }

    @GetMapping
    public ResponseEntity<Page<DadosProduto>>pegarTodosProdutos(Pageable pageable){
        var produtos =repository.findAll(pageable).map(DadosProduto::new);
        return  ResponseEntity.ok(produtos);
    }
//    @GetMapping("/")
//    public ResponseEntity<Page<DadosFornecedor>>pegarTodosFornecedores(Pageable pageable){
//        var fornecedores =repository.findAll(pageable).map(DadosFornecedor::new);
//        return  ResponseEntity.ok(fornecedores);
//    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarProduto (@RequestBody @Valid DadosProduto dadosProduto, @PathVariable int id){
        var produto = repository.getReferenceById(id);
        produto.atualizarInfo(dadosProduto);
        return ResponseEntity.ok(new DadosProduto(produto));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity apagarProduto( @PathVariable int id){
        var produto = repository.getReferenceById(id);
        repository.delete(produto);
        return ResponseEntity.noContent().build();
    }
}
