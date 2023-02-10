package fr.ab.MovieAssistant.Controller;

import fr.ab.MovieAssistant.DTO.*;
import fr.ab.MovieAssistant.Service.MovieService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/movie")
public class MovieController {

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
            PayloadDTO payloadDTO = new PayloadDTO();
            payloadDTO.setType("chips");
            OptionDTO optionDTO = new OptionDTO();
            optionDTO.setText(List.of("action", "horreur", "comédie", "drame", "romance", "aventure"));
            payloadDTO.setOptions(optionDTO);
            webhookReponseDTO.setPayload(payloadDTO);

        }else{
            webhookReponseDTO = movieService.getMovie(queryRequestDTO.getQueryResult().getParameters().getGenre().toLowerCase());
        }

        return  ResponseEntity.ok(webhookReponseDTO);
    }

}
