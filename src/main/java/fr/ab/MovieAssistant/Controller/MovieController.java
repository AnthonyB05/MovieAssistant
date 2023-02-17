package fr.ab.MovieAssistant.Controller;

import fr.ab.MovieAssistant.DTO.*;
import fr.ab.MovieAssistant.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    //private static Logger logger = LoggerFactory.getLogger(Slf4j.class);

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/request")
    public ResponseEntity<WebhookReponseDTO> postRequest(@RequestBody QueryRequestDTO queryRequestDTO) {

        //logger.info("queryRequestDTO : " + queryRequestDTO);
        // Check if queryRequest is correct
        if(queryRequestDTO.getQueryResult()==null || queryRequestDTO.getQueryResult().getQueryText()==null || queryRequestDTO.getQueryResult().getQueryText().equals("") || queryRequestDTO.getQueryResult().getParameters()==null ) {
            WebhookReponseDTO webhookReponseDTO = movieService.getGenreForUser(true);
            return ResponseEntity.ok(webhookReponseDTO);
        }

        return ResponseEntity.ok(movieService.getMovie(queryRequestDTO));
    }

}
