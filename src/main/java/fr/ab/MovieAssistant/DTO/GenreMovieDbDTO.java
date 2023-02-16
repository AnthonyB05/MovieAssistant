package fr.ab.MovieAssistant.DTO;

import java.util.List;
import java.util.Map;

public class GenreMovieDbDTO {
    private List<GenreDTO> genres;

    public List<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDTO> genres) {
        this.genres = genres;
    }

}
