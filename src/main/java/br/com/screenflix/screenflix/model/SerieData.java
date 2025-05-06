package br.com.screenflix.screenflix.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record SerieData(@JsonAlias("Title") String title, @JsonAlias("totalSeasons") int seasons, @JsonAlias("imdbRating") String review) {

}
