package unimetrocamp.gerenciadorEstoque.model.telefoneFornecedor;

public record DadosTelefone(
        int id,
        Integer ID_fornecedor,
        Integer telefone
) {
    public DadosTelefone(Telefone telefone){
        this(telefone.getId(), telefone.getID_fornecedor().getId(),telefone.getTelefone());
    }
}
