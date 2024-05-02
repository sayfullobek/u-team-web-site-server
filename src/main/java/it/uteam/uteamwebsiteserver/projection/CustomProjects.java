package it.uteam.uteamwebsiteserver.projection;

import it.uteam.uteamwebsiteserver.entity.Projects;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customProjects", types = Projects.class)
public interface CustomProjects {
    Integer getId();

    String getName();

    String getImage();

    String getDescription();

    String getUrl();

    String getGithubUrl();
}
