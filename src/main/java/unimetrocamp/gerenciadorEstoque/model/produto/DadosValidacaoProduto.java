package unimetrocamp.gerenciadorEstoque.model.produto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosValidacaoProduto (
        @NotBlank String nome,
        @NotNull Integer quantidade,
        @NotNull Double valorUnitario,
        @NotNull @Future  Date dataValidade,
        @NotBlank String codBarraProduto
){
}
