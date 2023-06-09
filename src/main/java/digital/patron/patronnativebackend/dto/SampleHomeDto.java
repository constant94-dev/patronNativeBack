package digital.patron.patronnativebackend.dto;

import digital.patron.patronnativebackend.entitry.Artist;
import digital.patron.patronnativebackend.entitry.Artwork;
import digital.patron.patronnativebackend.entitry.Exhibition;
import digital.patron.patronnativebackend.entitry.GeneralMember;

import java.util.List;
import java.util.Optional;

public class SampleHomeDto {
    String provider;
    List<Artwork> watchedArtworks;
    List<Artwork> likedArtworks;
    List<Boolean> alreadyWaiting;
    List<Long> leftTimeTillExhibition;
    Optional<Exhibition> theme1;
    String theme1DurationTime;
    Optional<Exhibition> theme2;
    String theme2DurationTime;
    Optional<Exhibition> theme3;
    String theme3DurationTime;
    Optional<Exhibition> theme4;
    String theme4DurationTime;
    Optional<Exhibition> theme5;
    String theme5DurationTime;
    List<String> exhibitionDuration;
    List<Exhibition> mainExhibitions;
    List<Exhibition> exhibitions;
    List<String> exhibitionsDurationTime;
    List<Artwork> newlyRegisteredArtworks;
    GeneralMember generalMember;
    List<Artist> artists;
    String deviceId;
    String language;

    SampleHomeDto(
            String provider,
            List<Artwork> watchedArtworks,
            List<Artwork> likedArtworks,
            List<Boolean> alreadyWaiting,
            List<Long> leftTimeTillExhibition,
            Optional<Exhibition> theme1,
            String theme1DurationTime,
            Optional<Exhibition> theme2,
            String theme2DurationTime,
            Optional<Exhibition> theme3,
            String theme3DurationTime,
            Optional<Exhibition> theme4,
            String theme4DurationTime,
            Optional<Exhibition> theme5,
            String theme5DurationTime,
            List<String> exhibitionDuration,
            List<Exhibition> mainExhibitions,
            List<Exhibition> exhibitions,
            List<String> exhibitionsDurationTime,
            List<Artwork> newlyRegisteredArtworks,
            GeneralMember generalMember,
            List<Artist> artists,
            String deviceId,
            String language
    ) {
        this.artists = artists;
        this.exhibitions = exhibitions;
        this.mainExhibitions = mainExhibitions;
        this.exhibitionDuration = exhibitionDuration;
        this.exhibitionsDurationTime = exhibitionsDurationTime;
        this.alreadyWaiting = alreadyWaiting;
        this.newlyRegisteredArtworks = newlyRegisteredArtworks;
        this.leftTimeTillExhibition = leftTimeTillExhibition;
        this.deviceId = deviceId;
        this.language = language;
        this.provider = provider;
        this.likedArtworks = likedArtworks;
        this.watchedArtworks = watchedArtworks;
        this.generalMember = generalMember;
        this.theme1 = theme1;
        this.theme1DurationTime = theme1DurationTime;
        this.theme2 = theme2;
        this.theme2DurationTime = theme2DurationTime;
        this.theme3 = theme3;
        this.theme3DurationTime = theme3DurationTime;
        this.theme4 = theme4;
        this.theme4DurationTime = theme4DurationTime;
        this.theme5 = theme5;
        this.theme5DurationTime = theme5DurationTime;

    }
}
