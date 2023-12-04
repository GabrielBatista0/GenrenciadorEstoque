package unimetrocamp.gerenciadorEstoque.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.DadosFornecedor;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.DadosValidarFornecedor;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.Fornecedor;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.FornecedorRepository;

@RestController
@RequestMapping("/fornecedores")
@CrossOrigin("*") //Consumir via codigo
public class FornecedorController {
    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarFornecedor(@RequestBody @Valid DadosValidarFornecedor dadosValidarFornecedor, UriComponentsBuilder uriComponentsBuilder){
        var fornecedor = new Fornecedor(dadosValidarFornecedor);
        repository.save(fornecedor);
        var uri =uriComponentsBuilder.path("/fornecedor/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosFornecedor(fornecedor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosFornecedor>>pegarFornecedoresAtivos(Pageable pageable){
        var fornecedores =repository.findAllByAtivoTrue(pageable).map(DadosFornecedor::new);
        return  ResponseEntity.ok(fornecedores);
    }
    @GetMapping("/todos")
    public ResponseEntity<Page<DadosFornecedor>>pegarTodosFornecedores(Pageable pageable){
        var fornecedores =repository.findAll(pageable).map(DadosFornecedor::new);
        return  ResponseEntity.ok(fornecedores);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarFornecedor (@RequestBody @Valid DadosFornecedor dadosFornecedor, @PathVariable int id){
        var fornecedor = repository.getReferenceById(id);
        fornecedor.atualizarInfo(dadosFornecedor);
        return ResponseEntity.ok(new DadosFornecedor(fornecedor));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity desativarFornecedor( @PathVariable int id){
        var fornecedor = repository.getReferenceById(id);
        fornecedor.desativar();
        return ResponseEntity.noContent().build();
    }
}
