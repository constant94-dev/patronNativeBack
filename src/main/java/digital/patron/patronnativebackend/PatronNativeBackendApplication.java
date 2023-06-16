package digital.patron.patronnativebackend;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatronNativeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatronNativeBackendApplication.class, args);
    }
}
