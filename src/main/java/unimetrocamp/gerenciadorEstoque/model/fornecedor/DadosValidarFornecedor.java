package unimetrocamp.gerenciadorEstoque.model.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosValidarFornecedor(
        @NotBlank String nome,
        @NotBlank String cidade,
        @NotBlank String logradouro,
        @NotBlank String CEP,
        @NotNull int numero,
        @NotNull String uf,
        @NotBlank String bairro,
        @NotBlank String email,
        @NotBlank String ramoAtuacao

) {
}
