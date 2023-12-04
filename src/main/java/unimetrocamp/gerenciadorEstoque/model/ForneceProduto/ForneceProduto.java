package unimetrocamp.gerenciadorEstoque.model.ForneceProduto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.Fornecedor;
import unimetrocamp.gerenciadorEstoque.model.produto.Produto;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.DadosTelefone;
import unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor.DadosValidarTelefone;

import java.util.Date;

@Entity(name = "ForneceProduto")
@Table(name = "Fornecimento_produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ForneceProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dataEntrada;
    private Double valorCompra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Produto")
    private Produto ID_Produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Fornecedor")
    private Fornecedor ID_Fornecedor;

    public ForneceProduto(DadosValidarForneceProduto dadosValidarForneceProduto, Fornecedor fornecedor,Produto produto) {
        this.dataEntrada = dadosValidarForneceProduto.dataEntrada();
        this.ID_Fornecedor = fornecedor;
        this.ID_Produto = produto;
        this.valorCompra = dadosValidarForneceProduto.valorCompra();
    }

    public void atualizarInfo(DadosForneceProduto dadosForneceProduto, Fornecedor fornecedor,Produto produto){
        if (dadosForneceProduto.valorCompra() != null){
            this.valorCompra = dadosForneceProduto.valorCompra();
        }
        if (dadosForneceProduto.dataEntrada() != null){
            this.dataEntrada = dadosForneceProduto.dataEntrada();
        }
        if (dadosForneceProduto.ID_Fornecedor() != null){
            this.ID_Fornecedor = fornecedor;
        }
        if (dadosForneceProduto.ID_Produto() != null){
            this.ID_Produto = produto;
        }
    }

}
