package fr.ab.MovieAssistant.DTO;

public class MessageDTO {
    private String platform;
    private SuggestionDTO suggestion;

    public SuggestionDTO getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionDTO suggestion) {
        this.suggestion = suggestion;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "platform='" + platform + '\'' +
                ", suggestion=" + suggestion +
                '}';
    }
}


