package it.uteam.uteamwebsiteserver.entity;

import it.uteam.uteamwebsiteserver.entity.templates.AbsNameEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Projects extends AbsNameEntity {
    private String image;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

    private String githubUrl;
}
