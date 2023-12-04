package unimetrocamp.gerenciadorEstoque.model.ForneceProduto;

import java.util.Date;

public record DadosForneceProduto (
        int id,
        Date dataEntrada,
        Double valorCompra,
        Integer ID_Produto,
        Integer ID_Fornecedor
){
    public DadosForneceProduto(ForneceProduto forneceProduto){
        this(forneceProduto.getId(),forneceProduto.getDataEntrada(), forneceProduto.getValorCompra(), forneceProduto.getID_Produto().getId(),forneceProduto.getID_Fornecedor().getId());
    }
}
