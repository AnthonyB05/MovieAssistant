package fr.ab.MovieAssistant.Service;

import fr.ab.MovieAssistant.DTO.WebhookReponseDTO;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public WebhookReponseDTO getMovie(String genre) {
        WebhookReponseDTO webhookReponseDTO = new WebhookReponseDTO();

        if(genre.equals("action")) {
            webhookReponseDTO.setFulfillmentText("Avenger");
        } else if(genre.equals("horreur")) {
            webhookReponseDTO.setFulfillmentText("Halloween");
        } else if(genre.equals("comédie")) {
            webhookReponseDTO.setFulfillmentText("Le père noël est une ordure");
        } else if(genre.equals("drame")) {
            webhookReponseDTO.setFulfillmentText("Le loup de Wall Street");
        } else if(genre.equals("romance")) {
            webhookReponseDTO.setFulfillmentText("Titanic");
        } else if(genre.equals("aventure")) {
            webhookReponseDTO.setFulfillmentText("Indiana Jones");
        } else {
            webhookReponseDTO.setFulfillmentText("Je ne connais pas de film de ce genre");
        }

        return webhookReponseDTO;
    }
}
