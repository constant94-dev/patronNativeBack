package digital.patron.patronnativebackend.artwork.service;

import digital.patron.patronnativebackend.artwork.domain.Artwork;
import digital.patron.patronnativebackend.artwork.repository.ArtworkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArtworkServiceImpl implements ArtworkService {

    private final ArtworkRepository artworkRepository;

    @Override
    public List<Artwork> findNewlyRegisteredArtworks(String localization) {
        List<Artwork> artworkList = artworkRepository.findArtworksByIsApproveAndIsShowingOrderByRegisteredAtDesc(localization);
        return artworkList;
    }
}
