package cane.brothers.spring.json.source_attributes;

import cane.brothers.spring.json.source.Source;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SOURCE_ATTRIBUTES")
public class SourceAttributes {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_attr_gen")
  @SequenceGenerator(name = "source_attr_gen", sequenceName = "SOURCE_ATTRIBUTES_PK_SEQ", allocationSize = 1)
  @Column(unique = true, nullable = false, columnDefinition = "serial")
  private Long id;

  @Column(name = "ATTRIBUTE_NAME", nullable = false)
  private String name;

  @Column(name = "ATTRIBUTE_VALUE", nullable = false)
  private String value;

  @ManyToOne(targetEntity = Source.class, optional = false)
  @JoinColumn(name = "SOURCE_KEY", referencedColumnName = "sourceKey", nullable = false,
      foreignKey = @ForeignKey(name = "FK_sourceKey"))
  private Source source;

  @Column(name = "SOURCE_KEY", insertable = false, updatable = false)
  private String sourceKey;
}
