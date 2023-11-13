package unimetrocamp.gerenciadorEstoque.model.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Produto")
@Table(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Integer quantidade;
    private Double valorUnitario;
    private Date dataValidade;
    private String codBarraProduto;


    public Produto(DadosProduto dadosProduto) {
        this.nome = dadosProduto.nome();
        this.quantidade = dadosProduto.quantidade();
        this.valorUnitario = dadosProduto.valorUnitario();
        this.dataValidade = dadosProduto.dataValidade();
        this.codBarraProduto = dadosProduto.codBarraProduto();
    }

    public Produto(DadosValidacaoProduto dadosValidacaoProduto) {
        this.nome = dadosValidacaoProduto.nome();
        this.quantidade = dadosValidacaoProduto.quantidade();
        this.valorUnitario = dadosValidacaoProduto.valorUnitario();
        this.dataValidade = dadosValidacaoProduto.dataValidade();
        this.codBarraProduto = dadosValidacaoProduto.codBarraProduto();
    }

    public void atualizarInfo(DadosProduto dadosProduto) {
        if (dadosProduto.nome() != null){
            this.nome = dadosProduto.nome();
        }
        if (dadosProduto.quantidade() != null){
            this.quantidade= dadosProduto.quantidade();
        }
        if (dadosProduto.codBarraProduto() != null){
            this.codBarraProduto = dadosProduto.codBarraProduto();
        }
        if (dadosProduto.dataValidade() != null){
            this.dataValidade = dadosProduto.dataValidade();
        }
        if (dadosProduto.valorUnitario() != null){
            this.valorUnitario = dadosProduto.valorUnitario();
        }
    }
}
