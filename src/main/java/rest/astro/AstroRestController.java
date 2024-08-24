package rest.astro;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/astros")
public class AstroRestController {
    private final AstroService astroService;

    public AstroRestController(AstroService astroService) {
        this.astroService = astroService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AstroResponse> getAstros() {
        return ResponseEntity.ok(astroService.getAstros());
    }
}
