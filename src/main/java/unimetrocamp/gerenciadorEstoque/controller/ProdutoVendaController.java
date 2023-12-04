package unimetrocamp.gerenciadorEstoque.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import unimetrocamp.gerenciadorEstoque.model.ForneceProduto.DadosForneceProduto;

import unimetrocamp.gerenciadorEstoque.model.ProdutoVenda.DadosProdutoVenda;
import unimetrocamp.gerenciadorEstoque.model.ProdutoVenda.DadosValidarProdutoVenda;
import unimetrocamp.gerenciadorEstoque.model.ProdutoVenda.ProdutoVenda;
import unimetrocamp.gerenciadorEstoque.model.ProdutoVenda.ProdutoVendaRepository;
import unimetrocamp.gerenciadorEstoque.model.produto.ProdutosRepository;
import unimetrocamp.gerenciadorEstoque.model.venda.VendaRepository;

@RestController
@RequestMapping("/produtoVenda")
@CrossOrigin("*") //Consumir via codigo
public class ProdutoVendaController {
    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;
    @Autowired
    private VendaRepository vendaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProdutoVenda(@RequestBody @Valid DadosValidarProdutoVenda dadosValidarProdutoVenda, UriComponentsBuilder uriComponentsBuilder){
        var venda = vendaRepository.getReferenceById(dadosValidarProdutoVenda.ID_Venda());
        var produto = produtosRepository.getReferenceById(dadosValidarProdutoVenda.ID_Produto());
        var produtoVenda = new ProdutoVenda(dadosValidarProdutoVenda,produto,venda);
        produtoVendaRepository.save(produtoVenda);
        var uri =uriComponentsBuilder.path("/telefone/{id}").buildAndExpand(produtoVenda.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosProdutoVenda(produtoVenda));
    }

    @GetMapping
    public ResponseEntity<Page<DadosProdutoVenda>>pegarProdutoVenda(Pageable pageable){
        var produtoVendas =produtoVendaRepository.findAll(pageable).map(DadosProdutoVenda::new);
        return  ResponseEntity.ok(produtoVendas);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarProdutoVenda (@RequestBody @Valid DadosProdutoVenda dadosProdutoVenda, @PathVariable int id){
        var produtoVenda = produtoVendaRepository.getReferenceById(id);
        var venda = vendaRepository.getReferenceById(dadosProdutoVenda.ID_Venda());
        var produto = produtosRepository.getReferenceById(dadosProdutoVenda.ID_Produto());
        produtoVenda.atualizarInfo(dadosProdutoVenda,produto,venda);
        return ResponseEntity.ok(new DadosProdutoVenda(produtoVenda));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity apagarRegistroProdutoVenda( @PathVariable int id){
        var produtoVenda = produtoVendaRepository.getReferenceById(id);
        produtoVendaRepository.delete(produtoVenda);
        return ResponseEntity.noContent().build();
    }

}
