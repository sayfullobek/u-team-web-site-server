package it.uteam.uteamwebsiteserver.service;

import it.uteam.uteamwebsiteserver.entity.Petition;
import it.uteam.uteamwebsiteserver.entity.enums.PetitionStatus;
import it.uteam.uteamwebsiteserver.payload.ApiResponse;
import it.uteam.uteamwebsiteserver.payload.PetitionDto;
import it.uteam.uteamwebsiteserver.repository.PetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetitionService {
    private final PetitionRepository petitionRepository;

    public Page<Petition> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return petitionRepository.findAll(pageable);
    }

    public ApiResponse addPetition(PetitionDto petitionDto) {
        if (petitionDto.getFIO().trim().isEmpty()) {
            return sendMessage("F.I.O bo'lishi shart", false, 400);
        }
        try {
            Long.parseLong(petitionDto.getPhoneNumber());
        } catch (NumberFormatException e) {
            sendMessage("Iltimos telefon raqamda harf ishlatmang", false, 400);
        }
        if (petitionDto.getPhoneNumber().length() != 9) {
            return sendMessage("Iltimos telefon raqamingizni to'g'ti kiriting", false, 400);
        }
        if (petitionDto.getText().trim().isEmpty()) {
            return sendMessage("Iltimos izohni to'liq qoldiring", false, 400);
        }
        petitionRepository.save(
                Petition.builder()
                        .FIO(petitionDto.getFIO())
                        .phoneNumber(petitionDto.getPhoneNumber())
                        .text(petitionDto.getText())
                        .status(PetitionStatus.REGISTER)
                        .build()
        );
        return sendMessage("Ariza muvaffaqiyatli yuborildi", true, 200);
    }

    public ApiResponse changeStatus(UUID id, PetitionDto petitionDto) {
        Petition petition = petitionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bunday ariza topilmadi"));
        petition.setStatus(petition.getStatus());
        petitionRepository.save(petition);
        return sendMessage("Muvaffaqiyatli status almashtirildi", true, 200);
    }

    public ApiResponse sendMessage(String message, boolean success, Integer status) {
        return ApiResponse.builder()
                .message(message)
                .success(success)
                .status(status)
                .build();
    }
}
