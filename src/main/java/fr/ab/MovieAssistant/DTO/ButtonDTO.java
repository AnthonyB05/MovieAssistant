package fr.ab.MovieAssistant.DTO;

public class ButtonDTO {
    private String title;
    private OpenUrlActionDTO openUrlAction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OpenUrlActionDTO getOpenUrlAction() {
        return openUrlAction;
    }

    public void setOpenUrlAction(OpenUrlActionDTO openUrlAction) {
        this.openUrlAction = openUrlAction;
    }
}
