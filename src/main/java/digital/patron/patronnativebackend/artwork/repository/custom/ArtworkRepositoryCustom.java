package digital.patron.patronnativebackend.artwork.repository.custom;

import digital.patron.patronnativebackend.artwork.domain.Artwork;

import java.util.List;

public interface ArtworkRepositoryCustom {
    List<Artwork> findArtworksByIsApproveAndIsShowingOrderByRegisteredAtDesc(String localization);
}
