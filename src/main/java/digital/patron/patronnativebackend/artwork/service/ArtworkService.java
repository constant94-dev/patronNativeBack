package digital.patron.patronnativebackend.artwork.service;

import digital.patron.patronnativebackend.artwork.domain.Artwork;

import java.util.List;

public interface ArtworkService {

    List<Artwork> findNewlyRegisteredArtworks(String localization);
}
