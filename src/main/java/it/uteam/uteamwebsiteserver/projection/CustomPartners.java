package it.uteam.uteamwebsiteserver.projection;

import it.uteam.uteamwebsiteserver.entity.Partners;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customPartners", types = Partners.class)
public interface CustomPartners {
    Integer getId();

    String getName();

    String getLogo();
}
