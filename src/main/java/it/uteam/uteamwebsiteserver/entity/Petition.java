package it.uteam.uteamwebsiteserver.entity;

import it.uteam.uteamwebsiteserver.entity.enums.PetitionStatus;
import it.uteam.uteamwebsiteserver.entity.templates.AbsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Petition extends AbsEntity { //ariza
    @Column(nullable = false)
    private String FIO;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String text;

    @Enumerated(value = EnumType.STRING)
    private PetitionStatus status;
}
