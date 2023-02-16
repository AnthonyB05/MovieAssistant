package fr.ab.MovieAssistant.DTO;

import java.util.List;

public class ResultDiscoverMovie {

    private List<DiscoverMovieDTO> results;

    public List<DiscoverMovieDTO> getResults() {
        return results;
    }

    public void setResults(List<DiscoverMovieDTO> results) {
        this.results = results;
    }
}
