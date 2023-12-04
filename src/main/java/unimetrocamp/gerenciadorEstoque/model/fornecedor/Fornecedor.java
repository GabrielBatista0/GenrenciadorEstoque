package unimetrocamp.gerenciadorEstoque.model.fornecedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Fornecedor")
@Table(name = "Fornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cidade;
    private String logradouro;
    private String CEP;
    private int numero;
    private String uf;
    private String bairro;
    private String email;
    private String ramoAtuacao;
    private boolean ativo;


    public Fornecedor(DadosFornecedor dadosFornecedor) {
        this.nome = dadosFornecedor.nome();
        this.cidade = dadosFornecedor.cidade();
        this.logradouro = dadosFornecedor.logradouro();
        this.CEP = dadosFornecedor.CEP();
        this.numero = dadosFornecedor.numero();
        this.uf = dadosFornecedor.uf();
        this.bairro = dadosFornecedor.bairro();
        this.email = dadosFornecedor.email();
        this.ramoAtuacao = dadosFornecedor.ramoAtuacao();
        this.ativo = true;
    }

    public Fornecedor(DadosValidarFornecedor dadosValidarFornecedor) {
        this.nome = dadosValidarFornecedor.nome();
        this.cidade = dadosValidarFornecedor.cidade();
        this.logradouro = dadosValidarFornecedor.logradouro();
        this.CEP = dadosValidarFornecedor.CEP();
        this.numero = dadosValidarFornecedor.numero();
        this.uf = dadosValidarFornecedor.uf();
        this.bairro = dadosValidarFornecedor.bairro();
        this.email = dadosValidarFornecedor.email();
        this.ramoAtuacao = dadosValidarFornecedor.ramoAtuacao();
        this.ativo = true;
    }

    public void atualizarInfo(DadosFornecedor dadosFornecedor) {
        if (dadosFornecedor.nome() != null ){
            this.nome = dadosFornecedor.nome();
        }
        if (dadosFornecedor.cidade() != null){
            this.cidade = dadosFornecedor.cidade();
        }
        if (dadosFornecedor.logradouro() != null){
            this.logradouro = dadosFornecedor.logradouro();
        }
        if (dadosFornecedor.CEP() != null){
            this.CEP = dadosFornecedor.CEP();
        }
        if (dadosFornecedor.numero() >=0){
            this.numero = dadosFornecedor.numero();
        }
        if (dadosFornecedor.uf() != null){
            this.uf = dadosFornecedor.uf();
        }
        if (dadosFornecedor.bairro() != null){
            this.bairro = dadosFornecedor.bairro();
        }
        if (dadosFornecedor.email() != null){
            this.email = dadosFornecedor.email();
        }if (dadosFornecedor.ramoAtuacao() != null) {
            this.ramoAtuacao = dadosFornecedor.ramoAtuacao();
        }

    }

    public void desativar() {
        this.ativo = false;
    }
}
