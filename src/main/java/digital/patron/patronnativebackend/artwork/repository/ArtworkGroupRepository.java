package digital.patron.patronnativebackend.artwork.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ArtworkGroupRepository {

    @PersistenceContext
    private EntityManager em;


}