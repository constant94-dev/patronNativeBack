package digital.patron.patronnativebackend.artwork.repository;

import digital.patron.patronnativebackend.artwork.domain.Artwork;
import digital.patron.patronnativebackend.artwork.repository.custom.ArtworkRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long>, ArtworkRepositoryCustom {
}
