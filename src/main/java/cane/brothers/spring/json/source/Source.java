package cane.brothers.spring.json.source;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SOURCE")
public class Source {
  @Id
  @GenericGenerator(name = "seq_source_key", strategy = "cane.brothers.spring.json.source.SourceKeyGenerator")
  @GeneratedValue(generator = "seq_source_key")
  @Column(unique = true, nullable = false, length = 13)
  private String sourceKey;

  @NotNull
  @Column(nullable = false)
  private String sourceId;
}
