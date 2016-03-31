package momentous.resto.test.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import momentous.resto.RestoApplication;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestoApplication.class)
@IntegrationTest({ "server.port=0" })
public class DummyControllerTest {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		template = new TestRestTemplate();
	}

	@Test
	public void dummy() throws Exception {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/resto/dummy",
				String.class);
		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}
}
