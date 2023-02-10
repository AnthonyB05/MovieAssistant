package fr.ab.MovieAssistant.DTO;

import java.io.Serializable;

public class QueryResultDTO  implements Serializable {
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
