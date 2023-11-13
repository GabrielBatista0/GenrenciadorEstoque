package unimetrocamp.gerenciadorEstoque.model.ProdutoVenda;

import jakarta.validation.constraints.NotNull;

public record DadosValidarProdutoVenda (
        @NotNull Double preco,
        @NotNull Integer quantidade,
        @NotNull Integer ID_Venda,
        @NotNull Integer ID_Produto
){
}
