package fr.ab.MovieAssistant.DTO;

public class BasicCardDTO {

    private String title;
    private String subtitle;
    private String formattedText;
    private ImageDTO image;
    private ButtonDTO buttons;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }

    public ButtonDTO getButton() {
        return buttons;
    }

    public void setButton(ButtonDTO buttons) {
        this.buttons = buttons;
    }

}
