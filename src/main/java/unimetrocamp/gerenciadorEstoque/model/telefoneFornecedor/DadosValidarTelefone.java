package unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor;

import jakarta.validation.constraints.NotNull;

public record DadosValidarTelefone (
        @NotNull Integer ID_fornecedor,
        @NotNull Integer telefone
)
{
}
