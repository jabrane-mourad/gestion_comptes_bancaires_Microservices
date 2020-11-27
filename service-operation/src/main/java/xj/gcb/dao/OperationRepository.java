package xj.gcb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xj.gcb.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
