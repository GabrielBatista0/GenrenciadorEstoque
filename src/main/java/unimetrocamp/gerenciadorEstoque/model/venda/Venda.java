package unimetrocamp.gerenciadorEstoque.model.venda;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Venda")
@Table(name = "Venda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double valorTotal;
    private Date dataSaida;


    public Venda(DadosVenda dadosVenda) {
        this.valorTotal = dadosVenda.valorTotal();
        this.dataSaida = dadosVenda.dataSaida();
    }
    public Venda(DadosValidacaoVenda dadosValidacaoVenda) {
        this.valorTotal = dadosValidacaoVenda.valorTotal();
        this.dataSaida = dadosValidacaoVenda.dataSaida();
    }

    public void atualizarInfo(DadosVenda dadosVenda) {
        System.out.println(dadosVenda.dataSaida()+"AAAAA");
        if(dadosVenda.dataSaida() != null){
            this.dataSaida = dadosVenda.dataSaida();
        }
        if (dadosVenda.valorTotal() != null){
            this.valorTotal = dadosVenda.valorTotal();
        }
    }
}
