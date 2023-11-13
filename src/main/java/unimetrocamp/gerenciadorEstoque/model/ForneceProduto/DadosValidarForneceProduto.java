package unimetrocamp.gerenciadorEstoque.model.ForneceProduto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosValidarForneceProduto(
        @NotNull Date dataEntrada,
        @NotNull Double valorCompra,
        @NotNull Integer ID_Produto,
        @NotNull Integer ID_Fornecedor
        ){
}
