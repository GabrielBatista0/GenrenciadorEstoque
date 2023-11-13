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
import unimetrocamp.gerenciadorEstoque.model.ForneceProduto.DadosValidarForneceProduto;
import unimetrocamp.gerenciadorEstoque.model.ForneceProduto.ForneceProduto;
import unimetrocamp.gerenciadorEstoque.model.ForneceProduto.ForneceProdutoRepository;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.FornecedorRepository;
import unimetrocamp.gerenciadorEstoque.model.produto.ProdutosRepository;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.DadosTelefone;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.DadosValidarTelefone;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.Telefone;

@RestController
@RequestMapping("/forneceProduto")
@CrossOrigin("*") //Consumir via codigo
public class ForneceProdutoController {

    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private ForneceProdutoRepository forneceProdutoRepository;
    @Autowired
    private FornecedorRepository fornecedorrepository;



    @PostMapping
    @Transactional
    public ResponseEntity cadastrarFornecimento(@RequestBody @Valid DadosValidarForneceProduto dadosValidarForneceProduto, UriComponentsBuilder uriComponentsBuilder){
        var fornecedor = fornecedorrepository.getReferenceById(dadosValidarForneceProduto.ID_Fornecedor());
        var produto = produtosRepository.getReferenceById(dadosValidarForneceProduto.ID_Produto());
        var fornecedorProduto = new ForneceProduto(dadosValidarForneceProduto,fornecedor,produto);
        forneceProdutoRepository.save(fornecedorProduto);
        var uri =uriComponentsBuilder.path("/telefone/{id}").buildAndExpand(fornecedorProduto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosForneceProduto(fornecedorProduto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosForneceProduto>>pegarFornecedorProduto(Pageable pageable){
        var fornecedorProdutos =forneceProdutoRepository.findAll(pageable).map(DadosForneceProduto::new);
        return  ResponseEntity.ok(fornecedorProdutos);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarFornecimento (@RequestBody @Valid DadosForneceProduto dadosForneceProduto, @PathVariable int id){
        var fornecedorProduto = forneceProdutoRepository.getReferenceById(id);
        var fornecedor = fornecedorrepository.getReferenceById(dadosForneceProduto.ID_Fornecedor());
        var produto = produtosRepository.getReferenceById(dadosForneceProduto.ID_Produto());
        fornecedorProduto.atualizarInfo(dadosForneceProduto,fornecedor,produto);
        return ResponseEntity.ok(new DadosForneceProduto(fornecedorProduto));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity apagarRegistroFornecimento( @PathVariable int id){
        var fornecedorProduto = fornecedorrepository.getReferenceById(id);
        fornecedorrepository.delete(fornecedorProduto);
        return ResponseEntity.noContent().build();
    }
}
