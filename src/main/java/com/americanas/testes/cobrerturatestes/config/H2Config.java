package com.americanas.testes.cobrerturatestes.config;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.repository.LivroRepository;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
public class H2Config implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa(null,"Marcus","23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com",
                "21 96428-5551", 300.00);

        Pessoa p2 = new Pessoa(null,"Vinícius","05/01/1999",
                "125.996.577-30", "mmendoncajus@gmail.com",
                "21 97422-8643", 400.00);

        Pessoa p3 = new Pessoa(null,"Bruna","04/09/1989",
                "134.956.987-32", "solldesouza@gmail.com",
                "21 96328-4481", 550.00);

        pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));


        Livro l1 = new Livro(null, "A Bíblia Sagrada", "Ed. 28ª",
                "Versão King James", 380.00,30);

        Livro l2 = new Livro(null,"O Alto da Compadecida", "Ed. 5ª",
                "Ariano Suassuna", 30.00, 10);

        Livro l3 = new Livro(null,"A Cabana", "Ed. 3ª",
                "William P. Young", 50.00, 20);

        livroRepository.saveAll(Arrays.asList(l1, l2, l3));

    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }

}

