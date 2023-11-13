package unimetrocamp.gerenciadorEstoque.model.venda;

import com.fasterxml.jackson.databind.node.ValueNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Integer> {
}
