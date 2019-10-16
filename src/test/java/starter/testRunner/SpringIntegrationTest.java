package starter.testRunner;

import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.atlassian.ta.wiremockpactgenerator.WireMockPactGenerator;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.modificationAdresse.springBoot.SpringBootGestionAdresse;

import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(classes = SpringBootGestionAdresse.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@AutoConfigureWireMock(port = 8190)
@ActiveProfiles("test")
public abstract class SpringIntegrationTest {

	protected RequestSpecification request;
	protected Response response;
	protected ValidatableResponse json;
	protected RestAssuredConfig config;

	@ClassRule
	public static WireMockClassRule wiremock = new WireMockClassRule(WireMockSpring.options().port(8090));

	protected Integer timeOut = 10000;

	protected String activeProfile = "dev";

	protected WireMockPactGenerator wireMockPact;

}
