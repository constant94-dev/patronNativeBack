package digital.patron.patronnativebackend;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PatronNativeBackendApplicationTests {

    @PersistenceContext
    EntityManager entityManager; // 스프링데이터 jpa에서 자동 빈 주입 , @Autowired 사용시 빈등록 코드를 별도로 직접 작성하여 주입해야한다.

    @Test
    void contextLoads() {
        Hello hello = new Hello();
        entityManager.persist(hello);
        JPAQueryFactory query = new JPAQueryFactory(entityManager); QHello qHello = new QHello("hello");
        Hello result = query
                .selectFrom(qHello)
                .fetchOne();

        Assertions.assertThat(result).isEqualTo(hello); //Querydsl Q타입이 정상 동작하는가?
        Assertions.assertThat(result.getId()).isEqualTo(hello.getId());//롬복 @Getter확인
    }

}
