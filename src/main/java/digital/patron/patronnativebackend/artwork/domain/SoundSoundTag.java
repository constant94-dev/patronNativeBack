package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "sound_sound_tag_relation")
public class SoundSoundTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sound sound;

    @ManyToOne(fetch = FetchType.LAZY)
    private SoundTag soundTag;
}