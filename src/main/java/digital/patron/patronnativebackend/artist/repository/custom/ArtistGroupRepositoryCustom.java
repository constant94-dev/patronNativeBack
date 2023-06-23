package digital.patron.patronnativebackend.artist.repository.custom;

import digital.patron.patronnativebackend.artist.domain.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArtistGroupRepositoryCustom {

    Page<Artist> findArtistsByArtistGroupNameOrderByArtistArtistGroupIdAsc(String localization, Pageable pageable);
}
