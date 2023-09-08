package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javafx.application.Application;

@SpringBootApplication
@EntityScan("br.edu.ifnmg.smrf")
@ComponentScan({"br.edu.ifnmg.smrf", "net.rgielen.fxweaver"})
@EnableJpaAuditing
public class AplicacaoSpring {
	private static ConfigurableApplicationContext contextoSpring;

	public static void main(String[] args) {
		contextoSpring = SpringApplication.run(AplicacaoSpring.class, args);
		Application.launch(AplicacaoJavaFX.class, args);
	}

	public static ConfigurableApplicationContext getContextoSpring() {
        return contextoSpring;
    }
}
