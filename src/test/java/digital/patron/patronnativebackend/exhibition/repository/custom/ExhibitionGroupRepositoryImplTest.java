package digital.patron.patronnativebackend.exhibition.repository.custom;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static digital.patron.patronnativebackend.exhibition.domain.QExhibition.exhibition;
import static digital.patron.patronnativebackend.exhibition.domain.QExhibitionExhibitionGroup.exhibitionExhibitionGroup;
import static digital.patron.patronnativebackend.exhibition.domain.QExhibitionGroup.exhibitionGroup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ExhibitionGroupRepositoryImplTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ExhibitionGroupRepositoryImpl exhibitionGroupRepository;

    @Test
    public void basicTest() {
        List<Exhibition> result = exhibitionGroupRepository.findExhibitionsByExhibitionGroupNameAndLocalization("메인전시", "kr");
        assertThat(result).isNotNull();


    }
}