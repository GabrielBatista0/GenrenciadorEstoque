package unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import unimetrocamp.gerenciadorEstoque.model.fornecedor.Fornecedor;


@Entity(name = "Telefone")
@Table(name = "Fornecedor_telefone")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_fornecedor")
    private Fornecedor ID_fornecedor;

    private Integer telefone;


    public Telefone(DadosValidarTelefone dadosValidarTelefone, Fornecedor fornecedor) {
        this.ID_fornecedor = fornecedor;
        this.telefone = dadosValidarTelefone.telefone();
    }
    public void atualizarInfo(DadosTelefone dadosTelefone, Fornecedor fornecedor){
        if (dadosTelefone.telefone() != null){
            this.telefone = dadosTelefone.telefone();
        }
        if (dadosTelefone.ID_fornecedor() != null){
            this.ID_fornecedor = fornecedor;
        }
    }
}
