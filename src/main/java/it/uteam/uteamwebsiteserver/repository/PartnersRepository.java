package it.uteam.uteamwebsiteserver.repository;

import it.uteam.uteamwebsiteserver.entity.Partners;
import it.uteam.uteamwebsiteserver.projection.CustomProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "partner", collectionResourceRel = "list", excerptProjection = CustomProjects.class)
@CrossOrigin
public interface PartnersRepository extends JpaRepository<Partners, Integer> {
}
