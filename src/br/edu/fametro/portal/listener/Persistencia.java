package br.edu.fametro.portal.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.model.atores.Secretario;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.Genero;

/**
 * Application Lifecycle Listener implementation class Persistencia
 *
 */
@WebListener
public class Persistencia implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public Persistencia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent contexto) {
		// TODO Auto-generated method stub
		System.out.println("Finalizando aplicação!");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent contexto) {
		// TODO Auto-generated method stub
		System.out.println("Iniciando aplicação...");
		System.out.println("Gerando persistencia...");
		
		System.out.println("Listando enums...");
		Curso bancoCursos[] = Curso.values( );
		Disciplina bancoDisciplinas[] = Disciplina.values();

		System.out.println("Instanciando banco...");
		SecretarioBusiness bancoSecretario = new SecretarioBusiness();
		
		System.out.println("Adicionando o primeiro elemento...");
		bancoSecretario.adicionar(new Secretario(bancoSecretario.getSize(), "Secretario Tester", "123456789", "123.456.789-00",
				new Date(), Genero.MASCULINO));

		// Teste
		System.out.println("Secretários (" + bancoSecretario.getSize() + "):");
		for (Secretario s : bancoSecretario.getBanco()) {
			System.out.println("----------");
			System.out.println(s);
		}
		System.out.println("----------\n");

		System.out.println("Colocando banco no contexto da aplicação...");
		contexto.getServletContext().setAttribute("bancoSecretario", bancoSecretario);
		
		System.out.println("Inicialização concluída...");
	}

}