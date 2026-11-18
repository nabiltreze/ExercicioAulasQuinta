package br.edu.senac.recursos;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest @AutoConfigureMockMvc
class ReservaControllerTest {
 @Autowired MockMvc mvc;
 @Test void cadastraViaApi() throws Exception {
  mvc.perform(post("/api/reservas").contentType(MediaType.APPLICATION_JSON)
   .content("{"recursoId":"sala-api","inicio":"2026-11-18T10:00:00","fim":"2026-11-18T11:00:00"}"))
   .andExpect(status().isCreated()).andExpect(jsonPath("$.recursoId").value("sala-api"));
 }
 @Test void invalidoRetorna400() throws Exception {
  mvc.perform(post("/api/reservas").contentType(MediaType.APPLICATION_JSON)
   .content("{"recursoId":"sala-invalida","inicio":"2026-11-18T11:00:00","fim":"2026-11-18T10:00:00"}"))
   .andExpect(status().isBadRequest());
 }
}
