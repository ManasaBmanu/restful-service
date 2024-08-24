package rest.astro;

import org.springframework.web.service.annotation.GetExchange;

public interface AstroHttpInterface {
    @GetExchange("/astros.json")
    public AstroResponse receiveResponse();
}
