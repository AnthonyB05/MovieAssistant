package fr.ab.MovieAssistant.DTO;

public class QueryResultDTO {
    private String queryText;
    private ParameterDTO parameters;

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public ParameterDTO getParameters() {
        return parameters;
    }

    public void setParameters(ParameterDTO parameters) {
        this.parameters = parameters;
    }
}
