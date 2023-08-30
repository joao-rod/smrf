package br.edu.ifnmg.smrf.Apresentacao.Desktop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javafx.application.Application;

@EntityScan("br.edu.ifnmg.smrf")
@ComponentScan({"br.edu.ifnmg.smrf", "net.rgielen.fxweaver"})
@SpringBootApplication
@EnableJpaAuditing
public class AplicacaoSpring {
	public static void main(String[] args) {
		Application.launch(AplicacaoJavaFX.class, args);
	}
}
