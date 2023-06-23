package digital.patron.patronnativebackend.artwork.repository;

import digital.patron.patronnativebackend.artwork.domain.ArtworkGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkGroupRepository extends JpaRepository<ArtworkGroup, Long> {
}