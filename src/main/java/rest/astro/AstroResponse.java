package rest.astro;

import java.util.List;

public record AstroResponse(String message, Integer number, List<People> people) {
    record People(String name, String craft) {
    }
}
