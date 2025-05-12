package br.com.screenflix.screenflix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieInfo(@JsonAlias("Title") String title, @JsonAlias("totalSeasons") int seasons, @JsonAlias("imdbRating") String review) { }
