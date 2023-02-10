package fr.ab.MovieAssistant.DTO;

public class QueryRequestDTO {
    private QueryResultDTO queryResult;

    public QueryResultDTO getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResultDTO queryResult) {
        this.queryResult = queryResult;
    }

    @Override
    public String toString() {
        return "QueryRequestDTO{" +
                "queryResult=" + queryResult +
                '}';
    }
}
