package cane.brothers.spring.json.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "source", path = "source")
public interface SourceRepository extends JpaRepository<Source, String> {

}