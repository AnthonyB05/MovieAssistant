package fr.ab.MovieAssistant.DTO;

public class MessageDTO {
    private String platform;
    private SimpleResponsesDTO simpleResponses;
    private SuggestionsDTO suggestions;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public SimpleResponsesDTO getSimpleResponses() {
        return simpleResponses;
    }

    public void setSimpleResponses(SimpleResponsesDTO simpleResponses) {
        this.simpleResponses = simpleResponses;
    }

    public SuggestionsDTO getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(SuggestionsDTO suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "platform='" + platform + '\'' +
                ", simpleResponses=" + simpleResponses +
                ", suggestions=" + suggestions +
                '}';
    }
}


