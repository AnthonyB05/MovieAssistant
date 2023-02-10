package fr.ab.MovieAssistant.Controller;

import fr.ab.MovieAssistant.DTO.QueryRequestDTO;
import fr.ab.MovieAssistant.DTO.QueryResultDTO;
import fr.ab.MovieAssistant.DTO.WebhookReponseDTO;
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

        if(queryRequestDTO.getQueryResult()==null ||queryRequestDTO.getQueryResult().getQueryText()==null || queryRequestDTO.getQueryResult().getParameters()==null || queryRequestDTO.getQueryResult().getParameters().getGenre()==null ) {
            return ResponseEntity.ok(movieService.getMovie("Je n'ai pas compris"));
        }

        return  ResponseEntity.ok(movieService.getMovie(queryRequestDTO.getQueryResult().getParameters().getGenre().toLowerCase()));
    }

}
