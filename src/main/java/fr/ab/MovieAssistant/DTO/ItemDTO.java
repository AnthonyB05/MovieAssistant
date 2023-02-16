package fr.ab.MovieAssistant.DTO;

public class ItemDTO {

    private SelectItemInfoDTO openUriAction;
    private String title;
    private String description;
    private ImageDTO image;

    public SelectItemInfoDTO getOpenUriAction() {
        return openUriAction;
    }

    public void setOpenUriAction(SelectItemInfoDTO openUriAction) {
        this.openUriAction = openUriAction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }
}
