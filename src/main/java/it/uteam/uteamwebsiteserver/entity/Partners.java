package it.uteam.uteamwebsiteserver.entity;

import it.uteam.uteamwebsiteserver.entity.templates.AbsNameEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
public class Partners extends AbsNameEntity {
    private String logo;
}
