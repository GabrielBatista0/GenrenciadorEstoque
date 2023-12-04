package unimetrocamp.gerenciadorEstoque.model.fornecedor;

public record DadosFornecedor (int id,
                                String nome,
                                String cidade,
                                String logradouro,
                                String CEP,
                                int numero,
                                String uf,
                                String bairro,
                                String email,
                                String ramoAtuacao,
                               boolean ativo) {
    public DadosFornecedor(Fornecedor fornecedor) {
        this( fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getCidade(),
                fornecedor.getLogradouro(),
                fornecedor.getCEP(),
                fornecedor.getNumero(),
                fornecedor.getUf(),
                fornecedor.getBairro(),
                fornecedor.getEmail(),
                fornecedor.getRamoAtuacao(),
                fornecedor.isAtivo());
    }
}
