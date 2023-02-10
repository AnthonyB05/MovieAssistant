package fr.ab.MovieAssistant.Controller;

import fr.ab.MovieAssistant.DTO.*;
import fr.ab.MovieAssistant.Service.MovieService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    private final List<String> genres = List.of("action", "horreur", "comédie", "drame", "romance", "aventure");

    @Autowired
    private MovieService movieService;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/request")
    public ResponseEntity<WebhookReponseDTO> postRequest(@RequestBody QueryRequestDTO queryRequestDTO) {

        WebhookReponseDTO webhookReponseDTO = new WebhookReponseDTO();

        if(queryRequestDTO.getQueryResult()==null || queryRequestDTO.getQueryResult().getQueryText()==null || queryRequestDTO.getQueryResult().getQueryText().equals("") || queryRequestDTO.getQueryResult().getParameters()==null ) {
            webhookReponseDTO.setFulfillmentText("Je n'ai pas compris votre demande");
            return  ResponseEntity.ok(webhookReponseDTO);
        }

        if(queryRequestDTO.getQueryResult().getParameters().getGenre().equals("")) {
            webhookReponseDTO.setFulfillmentText("Quel genre de film cherchez-vous ?");
            List<MessageDTO> messageDTOList = new ArrayList<>();
            for (String genre : genres) {
                MessageDTO messageDTO = new MessageDTO();
                messageDTO.setPlatform("ACTIONS_ON_GOOGLE");
                SuggestionDTO suggestionDTO = new SuggestionDTO();
                suggestionDTO.setTitle(genre);
                messageDTO.setSuggestion(suggestionDTO);
                messageDTOList.add(messageDTO);
            }

            webhookReponseDTO.setFulfillmentMessages(messageDTOList);

        }else{
            webhookReponseDTO = movieService.getMovie(queryRequestDTO.getQueryResult().getParameters().getGenre().toLowerCase());
        }

        return  ResponseEntity.ok(webhookReponseDTO);
    }

}
