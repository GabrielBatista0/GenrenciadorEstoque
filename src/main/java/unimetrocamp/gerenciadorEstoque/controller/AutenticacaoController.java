package unimetrocamp.gerenciadorEstoque.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unimetrocamp.gerenciadorEstoque.model.usuario.DadosAutenticacao;
import unimetrocamp.gerenciadorEstoque.model.usuario.Usuario;
import unimetrocamp.gerenciadorEstoque.seguranca.DadosTokenJWT;
import unimetrocamp.gerenciadorEstoque.seguranca.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.usuario(), dadosAutenticacao.senha());
        var autenticacao = manager.authenticate(token);
        var tokenJWT = tokenService.GerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
