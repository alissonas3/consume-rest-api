package br.com.screenflix.screenflix.menu;
import br.com.screenflix.screenflix.model.EpisodeInfo;
import br.com.screenflix.screenflix.model.SeasonInfo;
import br.com.screenflix.screenflix.model.SerieInfo;
import br.com.screenflix.screenflix.service.ConvertData;
import br.com.screenflix.screenflix.service.RequestsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mainMenu {

    private Scanner reader = new Scanner(System.in);
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=849866d8";

    public void loadMainMenu() {

        System.out.println("Search your favorite serie: ");
        var serie = reader.nextLine();

        var request = new RequestsAPI();
        var responseData = request.getData(URL + serie.replace(" ", "+") + API_KEY);
        System.out.println(responseData);

        ConvertData convert = new ConvertData();
        SerieInfo serieDetail = convert.getData(responseData, SerieInfo.class);
        System.out.println("Some details from serie: " + serieDetail);
		System.out.println("------------------");

//		responseData = request.getData("https://omdbapi.com/?t=the+last+of+us&season=1&episode=2&apikey=849866d8");
//		EpisodeInfo episode = convert.getData(responseData, EpisodeInfo.class);
//		System.out.println("Some details from a specific episode: " + episode);

		List<SeasonInfo> seasons = new ArrayList<>();
		for(int i = 1; i <= serieDetail.seasons(); i++) {
			responseData = request.getData(URL + serie.replace(" ", "+") + "&season=" + i + API_KEY);
			SeasonInfo season = convert.getData(responseData, SeasonInfo.class);
			seasons.add(season);
		}
		seasons.forEach(System.out::println);
        seasons.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));


        System.out.println("TOP 5 EPISODES!");
        List<EpisodeInfo> episodeInfo = seasons.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());

        episodeInfo.stream()
//                .filter(e -> !e.number().equals("N/A"))
                        .sorted(Comparator.comparing(EpisodeInfo::number).reversed())
                        .limit(5)
                .forEach(System.out::println);

//        episodeInfo.forEach(System.out::println);

    }

}
