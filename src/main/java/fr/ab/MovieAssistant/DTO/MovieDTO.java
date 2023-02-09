package fr.ab.MovieAssistant.DTO;

import lombok.Data;

import java.io.Serializable;


public class MovieDTO implements Serializable {
    private String title;
    private String director;
    private String genre;
    private String releaseDate;
    private String summary;
    private String poster;
    private String trailer;
    private String rating;
    private String duration;
    private String language;
    private String country;
    private String budget;
    private String gross;
    private String actors;

    public MovieDTO() {
    }

    public MovieDTO(String title, String director, String genre, String releaseDate, String summary, String poster, String trailer, String rating, String duration, String language, String country, String budget, String gross, String actors) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.summary = summary;
        this.poster = poster;
        this.trailer = trailer;
        this.rating = rating;
        this.duration = duration;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.gross = gross;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", summary='" + summary + '\'' +
                ", poster='" + poster + '\'' +
                ", trailer='" + trailer + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", budget='" + budget + '\'' +
                ", gross='" + gross + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }
}
