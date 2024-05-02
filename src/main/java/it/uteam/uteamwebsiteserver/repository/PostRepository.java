package it.uteam.uteamwebsiteserver.repository;

import it.uteam.uteamwebsiteserver.entity.Post;
import it.uteam.uteamwebsiteserver.projection.CustomPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@RepositoryRestResource(path = "post", collectionResourceRel = "list", excerptProjection = CustomPost.class)
@CrossOrigin
public interface PostRepository extends JpaRepository<Post, UUID> {
}
