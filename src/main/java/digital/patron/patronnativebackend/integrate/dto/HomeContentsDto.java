package digital.patron.patronnativebackend.integrate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeContentsDto {
    private List<Long> id;

    //    private List<String> exhibitionArtistNationality;
    private List<String> curationThumbnail;
    private List<String> curationThumbArtworkTitle;
    private List<String> curationArtistName;
    private List<Integer> curationArtistCount;
    //    private List<Integer> artworksCount;
    //    private List<String> durationTime;

    private List<String> waitingThumbnail;
    private List<String> waitingThumbArtworkTitle;
    private List<String> waitingArtistName;
    private List<Integer> waitingArtistCount;

    private List<String> newlyArtworks;
    //    private List<Long> dDay;
    private String theme1ExhibitionTitle;
    private List<String> theme1Thumbnail;
    private List<String> theme1ThumbArtworkTitle;
    private List<String> theme1ThumbArtistTitle;

    private String theme2ExhibitionTitle;
    private List<String> theme2Thumbnail;
    private List<String> theme2ThumbArtworkTitle;
    private List<String> theme2ThumbArtistTitle;

    private String theme3ExhibitionTitle;
    private List<String> theme3Thumbnail;
    private List<String> theme3ThumbArtworkTitle;
    private List<String> theme3ThumbArtistTitle;

    private String theme4ExhibitionTitle;
    private List<String> theme4Thumbnail;
    private List<String> theme4ThumbArtworkTitle;
    private List<String> theme4ThumbArtistTitle;

    private String theme5ExhibitionTitle;
    private List<String> theme5Thumbnail;
    private List<String> theme5ThumbArtworkTitle;
    private List<String> theme5ThumbArtistTitle;

    private List<String> artistProfileImage;
    private List<String> artistNameRecommend;
}
