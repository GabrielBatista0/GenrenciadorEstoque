package unimetrocamp.gerenciadorEstoque.model.venda;

import java.util.Date;

public record DadosVenda(
        int id,
        Double valorTotal,
        Date dataSaida
){
    public DadosVenda(Venda venda){
        this(venda.getId(), venda.getValorTotal(), venda.getDataSaida());
    }
}
