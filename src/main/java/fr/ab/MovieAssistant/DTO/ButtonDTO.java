package fr.ab.MovieAssistant.DTO;

public class ButtonDTO {
    private String title;
    private OpenUrlActionDTO openUriAction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OpenUrlActionDTO getOpenUrlAction() {
        return openUriAction;
    }

    public void setOpenUrlAction(OpenUrlActionDTO openUriAction) {
        this.openUriAction = openUriAction;
    }
}
