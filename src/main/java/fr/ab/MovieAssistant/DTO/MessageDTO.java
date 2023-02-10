package fr.ab.MovieAssistant.DTO;

public class MessageDTO {
    private SuggestionDTO suggestion;

    public SuggestionDTO getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionDTO suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "suggestion=" + suggestion +
                '}';
    }
}
