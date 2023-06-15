package digital.patron.patronnativebackend.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class MemberLikedArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
