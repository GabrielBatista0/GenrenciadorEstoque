package unimetrocamp.gerenciadorEstoque.model.fornecedor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {
    Page<Fornecedor> findAllByAtivoTrue(Pageable pageable);
}
