package com.elpiu.socialgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



/**
 * Classe che definisce il caricamento delle configurazioni nel caso di build
 * war non eseguibile. Garantisce il corretto funzionamento dell'applicazione
 * anche per il tradizionale deploy su applications server esterni.
 *
 * @author Elpidio Mazza
 */
@SpringBootApplication
public class SocialgameApplication extends SpringBootServletInitializer {

	/**
	 * Metodo necessario a Spring Boot per l'avvio dell'applicazione nel caso in cui
	 * si costruisca un jar/war eseguibile con server embedded.
	 *
	 * @param args classici parametri di inizializzazione
	 */
	public static void main(String[] args) {
		SpringApplication.run(SocialgameApplication.class, args);
	}

	/**
	 * Definisce il caricamento delle configurazioni nel caso di build
	 * war non eseguibile. Garantisce il corretto funzionamento dell'applicazione
	 * anche per il tradizionale deploy su applications server esterni.
	 *
	 * @author Elpidio Mazza
	 *
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SocialgameApplication.class);
	}

	/**
	 * In caso di altri file di configurazione
	 * */
	/*
	@Bean
	@Primary
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
				new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("application.yml"));
		propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
		return propertySourcesPlaceholderConfigurer;
	}
	 */

}
