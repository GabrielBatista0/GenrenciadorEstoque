package unimetrocamp.gerenciadorEstoque.model.ProdutoVenda;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import unimetrocamp.gerenciadorEstoque.model.ForneceProduto.DadosValidarForneceProduto;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.Fornecedor;
import unimetrocamp.gerenciadorEstoque.model.produto.Produto;
import unimetrocamp.gerenciadorEstoque.model.venda.Venda;

@Entity(name = "ProdutoVenda")
@Table(name = "ProdutoVenda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double preco;
    private Integer quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Produto")
    private Produto ID_Produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Venda")
    private Venda ID_Venda;

    public ProdutoVenda(DadosValidarProdutoVenda dadosValidarProdutoVenda, Produto produto, Venda venda) {
        this.preco = dadosValidarProdutoVenda.preco();
        this.quantidade = dadosValidarProdutoVenda.quantidade();
        this.ID_Venda = venda;
        this.ID_Produto = produto;
    }
    public void atualizarInfo(DadosProdutoVenda dadosProdutoVenda, Produto produto, Venda venda) {
        if (dadosProdutoVenda.preco() != null){
            this.preco = dadosProdutoVenda.preco();
        }
        if (dadosProdutoVenda.quantidade() != null){
            this.quantidade = dadosProdutoVenda.quantidade();
        }
        if (dadosProdutoVenda.ID_Venda() != null){
            this.ID_Venda = venda;
        }
        if (dadosProdutoVenda.ID_Produto() != null) {
            this.ID_Produto = produto;
        }
    }
}
