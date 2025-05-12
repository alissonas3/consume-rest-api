package br.com.screenflix.screenflix;

import br.com.screenflix.screenflix.model.EpisodeInfo;
import br.com.screenflix.screenflix.model.SeasonInfo;
import br.com.screenflix.screenflix.model.SerieInfo;
import br.com.screenflix.screenflix.service.ConvertData;
import br.com.screenflix.screenflix.service.RequestsAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

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

		System.out.println("------------------");

		ConvertData convert = new ConvertData();
		SerieInfo data = convert.getData(responseData, SerieInfo.class);
		System.out.println(data);

		System.out.println("------------------");

		responseData = request.getData("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=849866d8");
		EpisodeInfo episode = convert.getData(responseData, EpisodeInfo.class);
		System.out.println(episode);

		System.out.println("------------------");

		responseData = request.getData("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=849866d8");
		SeasonInfo season = convert.getData(responseData, SeasonInfo.class);
		System.out.println(season);

//		for(int i = 1; i <= responseData.totalSeasons(); i++) {
//			responseData = convert.getData("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c")
//		}


	}
}
