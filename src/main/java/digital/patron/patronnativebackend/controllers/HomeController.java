package digital.patron.patronnativebackend.controllers;

import digital.patron.patronnativebackend.artist.domain.Artist;
import digital.patron.patronnativebackend.artist.domain.ArtistDetail;
import digital.patron.patronnativebackend.artist.service.ArtistService;
import digital.patron.patronnativebackend.artwork.domain.Artwork;
import digital.patron.patronnativebackend.artwork.domain.ArtworkDetail;
import digital.patron.patronnativebackend.artwork.service.ArtworkService;
import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import digital.patron.patronnativebackend.exhibition.domain.ExhibitionDetail;
import digital.patron.patronnativebackend.exhibition.service.ExhibitionService;
import digital.patron.patronnativebackend.integrate.domain.ArtworkExhibition;
import digital.patron.patronnativebackend.integrate.dto.HomeContentsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private static final String MAIN_EXHIBITION = "메인전시";
    private static final String WAITING_EXHIBITION = "전시그룹";
    private static final String HOME_THEME_1 = "테마1";
    private static final String HOME_THEME_2 = "테마2";
    private static final String HOME_THEME_3 = "테마3";
    private static final String HOME_THEME_4 = "테마4";
    private static final String HOME_THEME_5 = "테마5";

    private final ExhibitionService exhibitionService;
    private final ArtworkService artworkService;
    private final ArtistService artistService;


    @GetMapping("/home")
    public ResponseEntity<?> home() {
        log.info("client 에서 요청이 정상적으로 들어왔습니다.");

        Pageable pageable = PageRequest.ofSize(15);

        List<Exhibition> mainExhibitions = exhibitionService.findExhibitionsByGroupName(MAIN_EXHIBITION, "kr", "ko");
        List<Exhibition> waitExhibitions = exhibitionService.findExhibitionsByGroupName(WAITING_EXHIBITION, "kr", "ko");
        List<Artwork> newlyRegisteredArtworks = artworkService.findNewlyRegisteredArtworks("kr");
        Exhibition theme1 = exhibitionService.findExhibitionByGroupName(HOME_THEME_1, "kr", "ko");
        Exhibition theme2 = exhibitionService.findExhibitionByGroupName(HOME_THEME_2, "kr", "ko");
        Exhibition theme3 = exhibitionService.findExhibitionByGroupName(HOME_THEME_3, "kr", "ko");
        Exhibition theme4 = exhibitionService.findExhibitionByGroupName(HOME_THEME_4, "kr", "ko");
        Exhibition theme5 = exhibitionService.findExhibitionByGroupName(HOME_THEME_5, "kr", "ko");
        List<Artist> artists = artistService.findArtistsByArtistGroupName("kr", pageable);

        HomeContentsDto homeContentsDto = new HomeContentsDto(
                mainExhibitions.stream().map(e -> e.getId())
                        .collect(Collectors.toList()),
                mainExhibitions.stream().map(e -> e.getArtworkExhibitions().stream()
                                .findFirst().orElseGet(ArtworkExhibition::new).getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                mainExhibitions.stream().map(e -> e.getExhibitionDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                mainExhibitions.stream().map(e -> e.getArtistExhibitions().stream()
                        .map(a -> a.getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName()).limit(3)
                        .collect(Collectors.joining(", "))).collect(Collectors.toList()),
                mainExhibitions.stream().map(e -> e.getArtistExhibitions().size() - 3).collect(Collectors.toList()),
                waitExhibitions.stream().map(e -> e.getArtworkExhibitions().stream()
                                .findFirst().orElseGet(ArtworkExhibition::new).getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                waitExhibitions.stream().map(e -> e.getExhibitionDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                waitExhibitions.stream().map(e -> e.getArtistExhibitions().stream()
                        .map(a -> a.getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName()).limit(3)
                        .collect(Collectors.joining(", "))).collect(Collectors.toList()),
                waitExhibitions.stream().map(e -> e.getArtistExhibitions().size() - 3).collect(Collectors.toList()),
                newlyRegisteredArtworks.stream().map(a -> a.getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                theme1.getExhibitionDetails().stream().filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault)
                        .getName(),
                theme1.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                theme1.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtworkDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtworkDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme1.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme2.getExhibitionDetails().stream().filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault)
                        .getName(),
                theme2.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                theme2.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtworkDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtworkDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme2.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme3.getExhibitionDetails().stream().filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault)
                        .getName(),
                theme3.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                theme3.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtworkDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtworkDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme3.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme4.getExhibitionDetails().stream().filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault)
                        .getName(),
                theme4.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                theme4.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtworkDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtworkDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme4.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme5.getExhibitionDetails().stream().filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ExhibitionDetail::createDefault)
                        .getName(),
                theme5.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getContentsThumbnail().getDefaultImg())
                        .collect(Collectors.toList()),
                theme5.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtworkDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtworkDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                theme5.getArtworkExhibitions().stream().map(aer -> aer.getArtwork().getArtist().getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName())
                        .collect(Collectors.toList()),
                artists.stream().map(a -> a.getProfileImg())
                        .collect(Collectors.toList()),
                artists.stream().map(a -> a.getArtistDetails().stream()
                                .filter(f -> f.getLanguage().equals("ko")).findFirst().orElseGet(ArtistDetail::createDefault).getName())
                        .collect(Collectors.toList())
        );
        return ResponseEntity.status(HttpStatus.OK).body(homeContentsDto);
    }
}

