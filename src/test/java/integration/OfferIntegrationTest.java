package integration;

import com.example.auctionservice.AuctionServiceApplication;
import com.example.auctionservice.dto.OfferDTO;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.repository.OfferRepository;
import com.example.auctionservice.service.OfferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuctionServiceApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OfferIntegrationTest extends OfferIntegrationTestSetup {

    private OfferService offerService;
    @BeforeEach
    void setup(@Autowired OfferRepository offerRepository) {
        offerService= new OfferService(offerRepository);
    }

    @LocalServerPort
    private int port;
    private static final String PATH_OFFERS = "/offers";

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @Test
    void shouldReturnOfferWhenOfferDtoIsSent() throws JsonProcessingException {
        ExtractableResponse<Response> extract = given()
                .body(createOfferDto())
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .post(PATH_OFFERS)
                .then()
                .extract();

        String string = extract.body().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        OfferDTO offerDTO = objectMapper.readValue(string, new TypeReference<>() {
        });
        Offer offerById = offerService.getOfferById(offerDTO.getId());
        assertEquals(offerDTO.getId(), offerById.getId());
    }

    @Test
    void shouldReturnOfferWhenOfferDtoIsSentThenThrowsException() throws JsonProcessingException {
        ExtractableResponse<Response> extract = given()
                .accept(ContentType.JSON)
                .get(PATH_OFFERS)
                .then()
                .extract();


        String responseBody = extract.body().asPrettyString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        List<Offer> offers = objectMapper.readValue(responseBody, new TypeReference<>() {
        });

        assertEquals(200, extract.statusCode());
        assertEquals(6, offers.size());
        assertEquals(offers.get(0).getId(), 1L);
        assertEquals(offers.get(0).getProduct().getName(), "BICYCLE");
//        assertEquals(offers.get(1).getId(), 2L);
//        assertEquals(offers.get(2).getId(), 3L);
    }
}

// endpoint gdzie podajesz id ogloszenia