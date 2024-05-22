package it.uteam.uteamwebsiteserver.projection;

import it.uteam.uteamwebsiteserver.entity.Post;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customPost", types = Post.class)
public interface CustomPost {
    Integer getId();

    String getName();

    String getText();

    String getDescription();

    String getImage();
}
