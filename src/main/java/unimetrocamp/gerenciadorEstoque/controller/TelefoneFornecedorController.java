package unimetrocamp.gerenciadorEstoque.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import unimetrocamp.gerenciadorEstoque.model.fornecedor.Fornecedor;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.FornecedorRepository;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.DadosTelefone;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.DadosValidarTelefone;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.Telefone;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.TelefoneRepository;

@RestController
@RequestMapping("/telefones")
@CrossOrigin("*") //Consumir via codigo
public class TelefoneFornecedorController {
    @Autowired
    private TelefoneRepository repository;

    @Autowired
    private FornecedorRepository fornecedorrepository;



    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTelefone(@RequestBody @Valid DadosValidarTelefone dadosValidarTelefone, UriComponentsBuilder uriComponentsBuilder){
        var fornecedor = fornecedorrepository.getReferenceById(dadosValidarTelefone.ID_fornecedor());
        var telefone = new Telefone(dadosValidarTelefone, fornecedor);
        repository.save(telefone);
        var uri =uriComponentsBuilder.path("/telefone/{id}").buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosTelefone(telefone));
    }

    @GetMapping
    public ResponseEntity<Page<DadosTelefone>>pegarTelefonesAtivos(Pageable pageable){
        var telefones =repository.findAll(pageable).map(DadosTelefone::new);
        return  ResponseEntity.ok(telefones);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTelefone (@RequestBody @Valid DadosTelefone dadosTelefone, @PathVariable int id){
        var telefone = repository.getReferenceById(id);
        var fornecedor = fornecedorrepository.getReferenceById(dadosTelefone.ID_fornecedor());
        telefone.atualizarInfo(dadosTelefone,fornecedor);
        return ResponseEntity.ok(new DadosTelefone(telefone));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity apagarTelefone( @PathVariable int id){
        var telefone = repository.getReferenceById(id);
        repository.delete(telefone);
        return ResponseEntity.noContent().build();
    }
}
