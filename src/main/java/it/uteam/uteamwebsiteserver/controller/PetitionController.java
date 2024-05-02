package it.uteam.uteamwebsiteserver.controller;

import it.uteam.uteamwebsiteserver.payload.ApiResponse;
import it.uteam.uteamwebsiteserver.payload.PetitionDto;
import it.uteam.uteamwebsiteserver.repository.PetitionRepository;
import it.uteam.uteamwebsiteserver.service.PetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/petition")
@RequiredArgsConstructor
@CrossOrigin
public class PetitionController {
    private final PetitionService petitionService;
    private final PetitionRepository petitionRepository;

    @GetMapping
    public HttpEntity<?> getPetitions(
            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(petitionService.findAll(pageNo, pageSize));
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOnePetition(@PathVariable UUID id) {
        return ResponseEntity.ok(
                petitionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bunday ariza topilmadi"))
        );
    }

    @PostMapping
    public HttpEntity<?> addPetition(@RequestBody PetitionDto petitionDto) {
        ApiResponse apiResponse = petitionService.addPetition(petitionDto);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PutMapping("/change-status/{id}")
    public HttpEntity<?> changeStatus(@PathVariable("id") UUID id, @RequestBody PetitionDto petitionDto) {
        ApiResponse apiResponse = petitionService.changeStatus(id, petitionDto);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
