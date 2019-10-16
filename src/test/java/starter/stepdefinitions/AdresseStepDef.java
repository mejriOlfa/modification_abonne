package starter.stepdefinitions;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.atlassian.ta.wiremockpactgenerator.WireMockPactGenerator;

import cucumber.api.java.Before;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import net.thucydides.core.annotations.Step;
import starter.testRunner.SpringIntegrationTest;

public class AdresseStepDef extends SpringIntegrationTest {

	private String basePath = "/api/getConnectedUser/";
	private String adressePath = "/api/modifierAdresse/";
	private String adresseContractPath = "/api/getContractAdress/";
	private String ligneMvtPath = "/api/getligneMvt/";
	private String baseURI = "http://localhost:8090";

	private String adresse;
	private String status;

	@Before
	public void setUp() {
		if (activeProfile != null && activeProfile.equalsIgnoreCase("dev")) {
			wireMockPact = WireMockPactGenerator.builder("userService", "canalService")
					.withRequestPathWhitelist(basePath + ".*").build();
			wiremock.addMockServiceRequestListener(wireMockPact);
			wiremock.stubFor(get(urlMatching(basePath + ".*")).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "application/json").withBodyFile("mocks/user.json")));
			wiremock.stubFor(get(urlMatching(adressePath + ".*")).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "application/json").withBodyFile("mocks/adresse.json")));
			wiremock.stubFor(get(urlMatching(adresseContractPath + ".*")).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "application/json").withBodyFile("mocks/contractAdress.json")));
			wiremock.stubFor(get(urlMatching(ligneMvtPath + ".*")).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "application/json").withBodyFile("mocks/mvt.json")));
		}
		config = RestAssured.config()
				.httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", timeOut)
						.setParam("http.socket.timeout", timeOut).setParam("http.connection-manager.timeout", timeOut));
		wiremock.start();
	}

	@Step("get the current number")
	@Etantdonné("un abonne avec une adresse principale (.*) en (.*)")
	public void adressePrincipale(String active, String pays) {
		Assert.assertEquals(pays, "France");
	}

	@Lorsque("le conseiller connecte a (.*) modifie l'adresse de l'abonne (.*)")
	public void modificationAdresseAbonne(String canal, String condition) {
		request = given().baseUri(baseURI).config(config);
		response = request.when().get(basePath + 1 + "/");
		json = response.then().statusCode(200);
		json.body("canal", equalTo(canal));

		response = request.when().get(adressePath);
		json = response.then().statusCode(200);
		json.body("status", equalTo(condition));
		adresse = json.extract().path("adresse");
		status = json.extract().path("status");
		System.out.println("response: " + response.prettyPrint());

	}

	@Alors("l'adresse de l'abonne modifiee est enregistree sur l'ensemble des contrats de l'abonne")
	public void ladresse_de_labonne_modifiee_est_enregistree_sur_lensemble_des_contrats_de_labonne() {
		request = given().baseUri(baseURI).config(config);
		response = request.when().get(adresseContractPath);
		Assert.assertEquals(response.getStatusCode(), 200);
		json = response.then().statusCode(200);
		List<Map<String, Object>> adresseList = response.jsonPath().getList("adresses");
		for (Map<String, Object> map : adresseList) {
			assertEquals(map.get("adresse"), adresse);
			assertEquals(map.get("status"), status);
		}
		System.out.println(adresseList.toString());
		
	}

	@Alors("un mouvement de modification d'adresse est cree")
	public void un_mouvement_de_modification_d_adresse_est_cree() {
		request = given().baseUri(baseURI).config(config);
		response = request.when().get(ligneMvtPath);
		Assert.assertEquals(response.getStatusCode(), 200);
		wiremock.stop();
	}

}
