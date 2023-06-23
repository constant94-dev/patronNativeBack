package digital.patron.patronnativebackend.artist.repository;

import digital.patron.patronnativebackend.artist.domain.ArtistGroup;
import digital.patron.patronnativebackend.artist.repository.custom.ArtistGroupRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistGroupRepository extends JpaRepository<ArtistGroup, Long>, ArtistGroupRepositoryCustom {
}
