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
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenflixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenflixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var request = new RequestsAPI();
		var responseData = request.getData("https://www.omdbapi.com/?t=the+last+of+us&apikey=849866d8");
		System.out.println(responseData);

		ConvertData convert = new ConvertData();

		SerieInfo serie = convert.getData(responseData, SerieInfo.class);
		System.out.println("Some details from serie: " + serie);

		System.out.println("------------------");

		responseData = request.getData("https://omdbapi.com/?t=the+last+of+us&season=1&episode=2&apikey=849866d8");
		EpisodeInfo episode = convert.getData(responseData, EpisodeInfo.class);
		System.out.println("Some details from a specific episode: " + episode);

		System.out.println("------------------");

		List<SeasonInfo> seasons = new ArrayList<>();

		for(int i = 1; i <= serie.seasons(); i++) {
			responseData = request.getData("https://www.omdbapi.com/?t=the+last+of+us&season=" + i + "&apikey=849866d8");
			SeasonInfo season = convert.getData(responseData, SeasonInfo.class);
			seasons.add(season);
		}
		seasons.forEach(System.out::println);


	}
}
