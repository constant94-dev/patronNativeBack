package digital.patron.patronnativebackend.exhibition.repository;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import digital.patron.patronnativebackend.exhibition.domain.ExhibitionGroup;
import digital.patron.patronnativebackend.exhibition.repository.custom.ExhibitionGroupRepositoryCustom;
import digital.patron.patronnativebackend.exhibition.repository.custom.ExhibitionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionGroupRepository extends JpaRepository<ExhibitionGroup, Long>, ExhibitionGroupRepositoryCustom {
}
