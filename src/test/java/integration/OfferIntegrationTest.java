package integration;

import com.example.auctionservice.AuctionServiceApplication;
import com.example.auctionservice.model.Offer;
import com.example.auctionservice.service.OfferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AuctionServiceApplication.class})
class OfferIntegrationTest extends OfferIntegrationTestSetup {
    @InjectMocks
    private OfferService offerService;
    private static final String LOCAL_URL_OFFERS = "/offers";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 443;
    }
    @Test
    void shouldReturnOfferWhenOfferDtoIsSent() throws JsonProcessingException {
        ExtractableResponse<Response> extract = given()
                .body(createOfferDto())
                .accept(ContentType.JSON)
                .post(LOCAL_URL_OFFERS)
                .then()
                .extract();

        String string = extract.body().asString();
        Offer offer = new ObjectMapper().readValue(string, new TypeReference<>() {
        });
        Offer offerById = offerService.getOfferById(offer.getId());
        assertEquals(offer.getId(), offerById.getId());
    }

    @Test
    void shouldReturnOfferWhenOfferDtoIsSentThenThrowsException() throws JsonProcessingException {
        ExtractableResponse<Response> extract = given()
                .accept(ContentType.JSON)
                .get(LOCAL_URL_OFFERS)
                .then()
                .extract();

        String string = extract.body().asString();
        Offer offer = new ObjectMapper().readValue(string, new TypeReference<>() {
        });
        Offer offerById = offerService.getOfferById(offer.getId());
        assertEquals(offer.getId(), offerById.getId());
    }
}
