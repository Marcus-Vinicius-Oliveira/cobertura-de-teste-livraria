package com.americanas.testes.cobrerturatestes.config;

import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
public class H2Config implements CommandLineRunner {

//    @Bean
//    public DataSource dataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2).addScript("F:poloTech/java/Testes/cobrertura-testes/src/main/resources").build();
//    }
    @Autowired
    private PessoaRepository pessoaRepository;

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

    }




//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(dataSource());
//        entityManagerFactory.setPackagesToScan("com.americanas.testes.coberturatestes");
//        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactory.setJpaProperties(jpaProperties());
//        return entityManagerFactory;
//    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }

//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }

}

