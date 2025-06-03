package br.com.screenflix.screenflix.model;

import java.time.LocalDate;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeNumber;
//    private Double review;
    private LocalDate realeasedDate;

    public Episode(Integer numberSeason, EpisodeInfo episodeInfo) {
        this.season = numberSeason;
        this.title = episodeInfo.title();
        this.episodeNumber = episodeInfo.number();
        this.realeasedDate = LocalDate.parse(episodeInfo.releasedDate());
    }


    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public LocalDate getRealeasedDate() {
        return realeasedDate;
    }

    public void setRealeasedDate(LocalDate realeasedDate) {
        this.realeasedDate = realeasedDate;
    }

    @Override
    public String toString() {
        return "season=" + season +
                ", title='" + title + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", realeasedDate=" + realeasedDate;
    }
}
