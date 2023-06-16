package digital.patron.patronnativebackend.common;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

@Configuration
public class JpaQueryFactoryConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory JpaQueryFactoryConfig() {
        return new JPAQueryFactory(entityManager);
    }
}
