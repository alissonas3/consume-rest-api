package br.com.screenflix.screenflix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonInfo(@JsonAlias("Season") Integer number, List<EpisodeInfo> episodes) { }
