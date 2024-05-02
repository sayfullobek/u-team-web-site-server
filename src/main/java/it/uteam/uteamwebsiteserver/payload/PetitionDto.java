package it.uteam.uteamwebsiteserver.payload;

import it.uteam.uteamwebsiteserver.entity.enums.PetitionStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetitionDto {
    private UUID id;
    private String FIO;
    private String phoneNumber;
    private String text;
    private PetitionStatus status;
}
