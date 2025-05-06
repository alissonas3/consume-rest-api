package br.com.screenflix.screenflix;

import br.com.screenflix.screenflix.service.RequestsAPI;
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
		var request = new RequestsAPI();

		var responseData = request.getData("https://www.omdbapi.com/?t=titanic&apikey=849866d8");

		System.out.println(responseData);

	}
}
