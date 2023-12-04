package unimetrocamp.gerenciadorEstoque.model.venda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosValidacaoVenda(
        @NotNull Double valorTotal,
        @NotNull Date dataSaida
        ) {
}
