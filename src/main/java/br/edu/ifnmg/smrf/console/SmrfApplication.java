package br.edu.ifnmg.smrf.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;

@EntityScan("br.edu.ifnmg.smrf")
@ComponentScan("br.edu.ifnmg.smrf")
@SpringBootApplication
public class SmrfApplication implements CommandLineRunner{
  @Autowired
  PessoaRepositorio pessoas;
  
  public static void main(String[] args) {
    SpringApplication.run(SmrfApplication.class, args);
  }

  @Override
	public void run(String... args) throws Exception {
    Pessoa p = new Pessoa();
    p.setNome("yasmin");
    p.setCpf("12345678911");
    p.setRg("12321545");

    pessoas.Salvar(p);
  } 
}
