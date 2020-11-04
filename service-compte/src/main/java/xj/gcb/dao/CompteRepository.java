package xj.gcb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import xj.gcb.entities.Compte;

//@Repository
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,String> {
}
