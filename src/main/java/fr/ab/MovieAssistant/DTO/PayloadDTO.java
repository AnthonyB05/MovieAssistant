package fr.ab.MovieAssistant.DTO;

import java.io.Serializable;

public class PayloadDTO  implements Serializable {

    private String type ;
    private OptionDTO options;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OptionDTO getOptions() {
        return options;
    }

    public void setOptions(OptionDTO options) {
        this.options = options;
    }
}
