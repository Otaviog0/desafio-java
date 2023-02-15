package com.example.demo;

import com.example.demo.domain.Denuncia;
import com.example.demo.resources.DenunciasResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DenunciaResourceTest {
    @InjectMocks
    DenunciasResource denunciasResource;

    @Test
    public void criarDenuncia() throws JsonProcessingException {
        Denuncia denuncia = createDenuncia();
        ResponseEntity<?> responseEntity = denunciasResource.insert(denuncia);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

    public Denuncia createDenuncia() throws JsonProcessingException {
        String json = "{\n" +
                "    \"latitude\": -15.789925709252136,\n" +
                "    \"longitude\": -47.887251273393815,\n" +
                "    \"denunciante\": {\n" +
                "      \"nome\": \"José da Silva\",\n" +
                "      \"cpf\": \"45616532145\"\n" +
                "    },\n" +
                "    \"denuncia\": {\n" +
                "      \"titulo\": \"Esgoto a céu aberto\",\n" +
                "      \"descricao\": \"Existe um esgoto a céu aberto nesta localidade.\"\n" +
                "    }\n" +
                "  }";
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Denuncia.class);
    }

}
