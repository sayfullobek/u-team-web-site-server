package it.uteam.uteamwebsiteserver.repository;

import it.uteam.uteamwebsiteserver.entity.Petition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetitionRepository extends JpaRepository<Petition, UUID> {
}
