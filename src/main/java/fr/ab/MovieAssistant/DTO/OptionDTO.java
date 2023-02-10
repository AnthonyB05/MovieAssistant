package fr.ab.MovieAssistant.DTO;

import java.io.Serializable;
import java.util.List;

public class OptionDTO  implements Serializable {
    private List<String> text;

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
