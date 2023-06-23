package digital.patron.patronnativebackend.artist.service;

import digital.patron.patronnativebackend.artist.domain.Artist;
import digital.patron.patronnativebackend.artist.repository.ArtistGroupRepository;
import digital.patron.patronnativebackend.artist.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService{
    private final ArtistGroupRepository artistGroupRepository;

    @Override
    public List<Artist> findArtistsByArtistGroupName(String localization, Pageable pageable) {
        List<Artist> artistList = artistGroupRepository.findArtistsByArtistGroupNameOrderByArtistArtistGroupIdAsc(localization, pageable).getContent();
        return artistList;
    }
}
