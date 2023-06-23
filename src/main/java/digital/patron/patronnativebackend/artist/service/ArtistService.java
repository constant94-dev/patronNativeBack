package digital.patron.patronnativebackend.artist.service;

import digital.patron.patronnativebackend.artist.domain.Artist;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArtistService {

    List<Artist> findArtistsByArtistGroupName(String localization, Pageable pageable);
}
