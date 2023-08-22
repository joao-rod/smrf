package br.edu.ifnmg.smrf.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.entidades.Veiculo;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import br.edu.ifnmg.smrf.servicos.VeiculoRepositorio;

// @EntityScan("br.edu.ifnmg.smrf")
// @ComponentScan("br.edu.ifnmg.smrf")
// @SpringBootApplication
// @EnableJpaAuditing
public class SmrfApplication implements CommandLineRunner {
    
    // @Autowired
    // VeiculoRepositorio veiculos;

    @Autowired
    PessoaRepositorio pessoas;

    public static void main(String[] args) {
        SpringApplication.run(SmrfApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Veiculo v = new Veiculo();
        // v.setPlaca("joao");

        // veiculos.Salvar(v);

        // Veiculo vEdit = veiculos.abrirPorPlaca("joao");
        // vEdit.setPlaca("xandao");

        // veiculos.Salvar(vEdit);

        Pessoa v = new Pessoa();
        v.setNome("joao");

        pessoas.Salvar(v);

        // Pessoa vEdit = pessoas.abrirPorNome("joao");
        // vEdit.setNome("xandao");

        // pessoas.Salvar(vEdit);
    }
}
