package unimetrocamp.gerenciadorEstoque.model.ProdutoVenda;

import unimetrocamp.gerenciadorEstoque.model.produto.Produto;

public record DadosProdutoVenda(
        int id,
        Double preco,
        Integer quantidade,
        Integer ID_Venda,
        Integer ID_Produto
) {
    public DadosProdutoVenda(ProdutoVenda produtoVenda){
        this(produtoVenda.getId(), produtoVenda.getPreco(), produtoVenda.getQuantidade(),produtoVenda.getID_Venda().getId(),produtoVenda.getID_Produto().getId());
    }
}
