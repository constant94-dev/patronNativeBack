package digital.patron.patronnativebackend.exhibition.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ExhibitionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 10)
    private String language;

    @OneToMany(mappedBy = "exhibitionTag")
    private Set<ExhibitionExhibitionTag> exhibitionExhibitionTags = new HashSet<>();

    protected ExhibitionTag(){}
}
