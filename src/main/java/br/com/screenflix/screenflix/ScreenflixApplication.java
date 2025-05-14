package br.com.screenflix.screenflix;

import br.com.screenflix.screenflix.menu.mainMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenflixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenflixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mainMenu menu = new mainMenu();
		menu.loadMainMenu();

	}
}
