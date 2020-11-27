package xj.gcb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import xj.gcb.entities.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {
}
