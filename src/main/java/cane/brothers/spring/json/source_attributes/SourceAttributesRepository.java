package cane.brothers.spring.json.source_attributes;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "source_attributes", path = "source_attributes")
public interface SourceAttributesRepository extends JpaRepository<SourceAttributes, String> {

  @RestResource(path = "bySource", rel = "findBySourceKey")
  Optional<List<SourceAttributes>> findBySourceSourceKey(@Param("SOURCE_KEY") String sourceKey);
}