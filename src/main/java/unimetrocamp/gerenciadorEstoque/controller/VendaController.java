package unimetrocamp.gerenciadorEstoque.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import unimetrocamp.gerenciadorEstoque.model.venda.DadosValidacaoVenda;
import unimetrocamp.gerenciadorEstoque.model.venda.DadosVenda;
import unimetrocamp.gerenciadorEstoque.model.venda.Venda;
import unimetrocamp.gerenciadorEstoque.model.venda.VendaRepository;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private VendaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarVenda(@RequestBody @Valid DadosValidacaoVenda dadosValidacaoVenda, UriComponentsBuilder uriComponentsBuilder){
        var venda = new Venda(dadosValidacaoVenda);
        repository.save(venda);
        var uri =uriComponentsBuilder.path("/venda/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosVenda(venda));
    }

    @GetMapping
    public ResponseEntity<Page<DadosVenda>>pegarTodasVendas(Pageable pageable){
        var vendas =repository.findAll(pageable).map(DadosVenda::new);
        return  ResponseEntity.ok(vendas);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarVenda (@RequestBody @Valid DadosVenda dadosVenda, @PathVariable int id){
        var venda = repository.getReferenceById(id);
        venda.atualizarInfo(dadosVenda);
        return ResponseEntity.ok(new DadosVenda(venda));
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity apagarVenda( @PathVariable int id){
        var venda = repository.getReferenceById(id);
        repository.delete(venda);
        return ResponseEntity.noContent().build();
    }
}
