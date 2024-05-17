package it.uteam.uteamwebsiteserver.entity;

import it.uteam.uteamwebsiteserver.entity.templates.AbsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post extends AbsEntity {
    @Column(nullable = false)
    private String text;

    @Column(nullable = false, length = 10000)
    private String description;

    @Column
    private String image;

}
