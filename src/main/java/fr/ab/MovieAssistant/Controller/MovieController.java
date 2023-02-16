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

    @Autowired
    private MovieService movieService;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/request")
    public ResponseEntity<WebhookReponseDTO> postRequest(@RequestBody QueryRequestDTO queryRequestDTO) {

        // Check if queryRequest is correct
        if(queryRequestDTO.getQueryResult()==null || queryRequestDTO.getQueryResult().getQueryText()==null || queryRequestDTO.getQueryResult().getQueryText().equals("") || queryRequestDTO.getQueryResult().getParameters()==null ) {
            WebhookReponseDTO webhookReponseDTO = new WebhookReponseDTO();
            webhookReponseDTO.setFulfillmentText("Je n'ai pas compris votre demande");
            return ResponseEntity.ok(webhookReponseDTO);
        }

        return ResponseEntity.ok(movieService.getMovie(queryRequestDTO));
    }

}
