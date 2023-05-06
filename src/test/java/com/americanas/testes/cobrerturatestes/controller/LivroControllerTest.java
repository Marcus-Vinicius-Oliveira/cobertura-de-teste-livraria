package com.americanas.testes.cobrerturatestes.controller;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.services.LivroService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class LivroControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LivroService livroService;

    private final String baseUri = "/livros";


    @BeforeEach
    public void setup() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Test
    public void testSalvarLivro() throws Exception {
        Livro livro = new Livro(1L,"A Cabana", "Ed. 3",
                "William P. Young", BigDecimal.valueOf(50.00).setScale(2), 20);
        String json = mapper.writeValueAsString(livro);

        mockMvc.perform(post(baseUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(result -> {
                    String responseJson = result.getResponse().getContentAsString();
                    JSONAssert.assertEquals(json, responseJson, false);
                });
    }


    @Test
    void testBuscarLivroPorId() throws Exception {
        Livro livro = livroService.salvarLivro(new Livro(1L,"A Cabana", "Ed. 3",
                "William P. Young", BigDecimal.valueOf(50.00).setScale(2), 20));

        mockMvc.perform(MockMvcRequestBuilders.get(baseUri + "/{id}", livro.getId()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(livro)));
    }

    @Test
    void testListarLivros() throws Exception {
        Livro livro1 = livroService.salvarLivro(new Livro(1L,"A Cabana", "Ed. 3",
                "William P. Young", BigDecimal.valueOf(50.00).setScale(2), 20));
        Livro livro2 = livroService.salvarLivro(new Livro(2L,"O Alto da Compadecida", "Ed. 5",
                "Ariano Suassuna", BigDecimal.valueOf(30.00).setScale(2), 10));
        Livro livro3 = livroService.salvarLivro(new Livro(3L, "A Bíblia Sagrada", "Ed. 28ª",
                "Versão King James", BigDecimal.valueOf(380.00).setScale(2),30));
        List<Livro> livros = Arrays.asList(livro1, livro2, livro3);

        mockMvc.perform(MockMvcRequestBuilders.get(baseUri))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(livros)));
    }


    @Test
    void testAtualizarLivro() throws Exception {
        Livro livro = livroService.salvarLivro(new Livro(1L,"A Cabana", "Ed. 3",
                "William P. Young", BigDecimal.valueOf(50.00).setScale(2), 20));
        livro.setNome("Livro Atualizado");
        String json = mapper.writeValueAsString(livro);

        mockMvc.perform(MockMvcRequestBuilders.put(baseUri + "/{id}", livro.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(json));
    }

    @Test
    void testExcluirLivro() throws Exception {
        Livro livro = livroService.salvarLivro(new Livro(1L,"A Cabana", "Ed. 3",
                "William P. Young", BigDecimal.valueOf(50.00).setScale(2), 20));

        mockMvc.perform(MockMvcRequestBuilders.delete(baseUri + "/{id}", livro.getId()))
                .andExpect(status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}



