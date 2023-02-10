package fr.ab.MovieAssistant.DTO;

import java.io.Serializable;

public class ParameterDTO  implements Serializable {
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
