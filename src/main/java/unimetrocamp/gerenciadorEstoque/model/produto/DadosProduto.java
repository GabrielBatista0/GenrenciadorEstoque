package unimetrocamp.gerenciadorEstoque.model.produto;

import java.awt.color.ProfileDataException;
import java.util.Date;

public record DadosProduto (
        int id,
        String nome,
        Integer quantidade,
        Double valorUnitario,
        Date dataValidade,
        String codBarraProduto
){
    public DadosProduto (Produto produto){
        this(
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getValorUnitario(),
                produto.getDataValidade(),
                produto.getCodBarraProduto()
        );
    }
}
