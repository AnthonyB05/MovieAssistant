package fr.ab.MovieAssistant.Controller;

import fr.ab.MovieAssistant.DTO.*;
import fr.ab.MovieAssistant.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
            List<MessageDTO> messageDTOList = new ArrayList<>();

            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setPlatform("ACTIONS_ON_GOOGLE");
            SimpleResponsesDTO simpleResponsesDTO = new SimpleResponsesDTO();
            SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO();
            simpleResponseDTO.setTextToSpeech("Quel genre de film cherchez-vous ?");
            simpleResponsesDTO.setSimpleResponses(List.of(simpleResponseDTO));
            messageDTO.setSimpleResponses(simpleResponsesDTO);
            messageDTOList.add(messageDTO);


            MessageDTO messageDTO2 = new MessageDTO();
            messageDTO2.setPlatform("ACTIONS_ON_GOOGLE");
            SuggestionsDTO suggestionsDTO = new SuggestionsDTO();
            for (String genre : genres) {
                SuggestionDTO suggestionDTO = new SuggestionDTO();
                suggestionDTO.setTitle(genre);
                suggestionsDTO.addSuggestion(suggestionDTO);
            }
            messageDTO2.setSuggestions(suggestionsDTO);
            messageDTOList.add(messageDTO2);

            webhookReponseDTO.setFulfillmentMessages(messageDTOList);

        }else{
            webhookReponseDTO = movieService.getMovie(queryRequestDTO.getQueryResult().getParameters().getGenre().toLowerCase());
        }

        return  ResponseEntity.ok(webhookReponseDTO);
    }

}
