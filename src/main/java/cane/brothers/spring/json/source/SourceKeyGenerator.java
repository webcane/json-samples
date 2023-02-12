package cane.brothers.spring.json.source;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SourceKeyGenerator implements IdentifierGenerator {
  private static AtomicLong idCounter = new AtomicLong(1);

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
    return String.format("%s%09d", "SRC", idCounter.getAndIncrement());
  }
}
