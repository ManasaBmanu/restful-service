package rest.astro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Service
public class AstroService {

    @Autowired
    AstroHttpInterface astroHttpInterface;

//    public AstroService(AstroHttpInterface astroHttpInterface) {
//        this.astroHttpInterface = astroHttpInterface;
//    }

    @Bean
    public AstroHttpInterface astroHttpInterface(@Value("${astro.url}") String baseUrl) {
        RestClient restClient = RestClient.builder().baseUrl(baseUrl).build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(AstroHttpInterface.class);
    }

    public AstroResponse getAstros() {
        return astroHttpInterface.receiveResponse();
    }
}
