package digital.patron.patronnativebackend.exhibition.dto;

import digital.patron.patronnativebackend.artist.domain.Artist;
import digital.patron.patronnativebackend.artwork.domain.Artwork;
import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExhibitionDto {
    private List<Long> id;
    private List<String> curationThumbName;
//    private List<String> exhibitionArtistNationality;
    private List<String> curationArtistName;
    private List<Integer> curationArtistCount;
//    private List<Integer> artworksCount;
//    private List<String> durationTime;
    private List<String> curationThumbnail;
    private List<String> newlyArtworks;
//    private List<Long> dDay;
    private List<String> artistProfileImage;
    private List<String> recommendArtistName;
}