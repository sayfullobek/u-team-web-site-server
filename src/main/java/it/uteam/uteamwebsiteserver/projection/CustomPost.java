package it.uteam.uteamwebsiteserver.projection;

import it.uteam.uteamwebsiteserver.entity.Post;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name = "customPost", types = Post.class)
public interface CustomPost {
    UUID getId();

    String getText();

    String getDescription();

    String getImage();
}
