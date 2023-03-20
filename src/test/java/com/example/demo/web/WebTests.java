package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Statistique;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

	@MockBean
	Statistique statistique;

	@Autowired
	MockMvc mockMvc;

	@Test
	void testZeroVoiture() throws Exception {
		mockMvc.perform(get("/statistique")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	void ajouterVoiture() throws Exception {
		mockMvc.perform(post("/voiture")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{ \"marque\": \"Ferrari\", \"prix\": 5000 }")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	void statistique1Voiture() throws Exception {

		//statistique.ajouter(new Voiture("Ferrari", 5000));

		//mockMvc.perform(get("/statistique")).andReturn().getResponse().getOutputStream().println();

		//System.out.println("oooookkkkkkk = " + mockMvc.perform(get("/statistique")).andReturn().getResponse().getOutputStream().println(););

		/*mockMvc.perform(get("/statistique")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("nombreDeVoitures").value("1"));
			//.andExpect(jsonPath("prixMoyen").value("5000"));*/

		//when(statistique.ajouter(new Voiture("Ferrari", 5000)));

		doNothing().when(statistique).ajouter(new Voiture("Ferrari", 5000));

		/*mockMvc.perform(get("/statistique")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{'nombreDeVoitures':'1','prixMoyen':'5000'}"));*/
	}

}
