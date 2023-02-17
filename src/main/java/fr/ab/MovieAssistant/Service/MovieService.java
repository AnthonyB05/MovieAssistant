package fr.ab.MovieAssistant.Service;

import fr.ab.MovieAssistant.DTO.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<String> genres = List.of("Action", "Aventure", "Animation", "Comédie", "Crime", "Drame", "Familial", "Fantastique", "Histoire", "Musique", "Mystère", "Romance", "Science-Fiction", "Téléfilm", "Thriller", "Western");

    private final String API_KEY = "api_key=f5762d995d659b32a1306b4e9da16f59";
    private final String LANGUAGE = "language=fr-FR";

    private final String BASE_URL = "https://api.themoviedb.org/3";
    private final String API_genre = "/genre/movie/list";
    private final String API_discoverMovie = "/discover/movie";
    private final String API_movie = "/movie/";
    private final String API_IMAGE = "https://image.tmdb.org/t/p/original";
    private final String SITE_MOVIE_DB = "https://www.themoviedb.org/movie/";


    public WebhookReponseDTO getMovie(QueryRequestDTO queryRequestDTO) {

        if(queryRequestDTO.getQueryResult().getParameters().getGenre()==null){
            List<ContextDTO> context = queryRequestDTO.getQueryResult().getOutputContexts();
            for (ContextDTO contextDTO : context) {
                if(contextDTO.getParameters().containsKey("OPTION")) {
                    return this.getExplainMovie(contextDTO);
                }
            }
            return this.getMovieByGenre(queryRequestDTO.getQueryResult().getParameters().getGenre().toLowerCase());
        }

        if(queryRequestDTO.getQueryResult().getParameters().getGenre().equals("")){
            return this.getGenreForUser();
        }

        return this.getMovieByGenre(queryRequestDTO.getQueryResult().getParameters().getGenre().toLowerCase());

    }

    private WebhookReponseDTO getExplainMovie(ContextDTO contextDTO) {

        RestTemplate restTemplate = new RestTemplate();
        WebhookReponseDTO webhookReponseDTO = new WebhookReponseDTO();

        List<MessageDTO> messageDTOList = new ArrayList<>();
        MessageDTO messageSimpleResponse = new MessageDTO();
        messageSimpleResponse.setPlatform("ACTIONS_ON_GOOGLE");
        SimpleResponsesDTO simpleResponsesDTO = new SimpleResponsesDTO();
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO();
        simpleResponseDTO.setTextToSpeech("Voici les informations !!");
        simpleResponsesDTO.setSimpleResponses(List.of(simpleResponseDTO));
        messageSimpleResponse.setSimpleResponses(simpleResponsesDTO);
        messageDTOList.add(messageSimpleResponse);

        MessageDTO messageCard= new MessageDTO();
        messageCard.setPlatform("ACTIONS_ON_GOOGLE");
        BasicCardDTO basicCardDTO = new BasicCardDTO();

        MovieDTO movieDTO = restTemplate.getForObject(BASE_URL + API_movie + contextDTO.getParameters().get("OPTION") + "?" + API_KEY + "&" + LANGUAGE, MovieDTO.class);

        if(movieDTO.getHomepage() == null || movieDTO.getHomepage() == "") {
            movieDTO.setHomepage(SITE_MOVIE_DB + movieDTO.getId());
        }

        basicCardDTO.setTitle(movieDTO.getTitle());
        basicCardDTO.setSubtitle("Sorti le " + movieDTO.getRelease_date());
        basicCardDTO.setFormattedText(movieDTO.getOverview());
        //image
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageUri(API_IMAGE + movieDTO.getPoster_path());
        imageDTO.setAccessibilityText(movieDTO.getTitle());
        basicCardDTO.setImage(imageDTO);
        //buttons
        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setTitle("Voir le film");
        OpenUriActionDTO openUriActionDTO = new OpenUriActionDTO();
        openUriActionDTO.setUri(movieDTO.getHomepage());
        buttonDTO.setOpenUriAction(openUriActionDTO);
        basicCardDTO.setButtons(List.of(buttonDTO));

        messageCard.setBasicCard(basicCardDTO);
        messageDTOList.add(messageCard);
        webhookReponseDTO.setFulfillmentMessages(messageDTOList);

        return webhookReponseDTO;
    }

    //"Action";"Aventure";"Animation";"Comédie";"Crime";""Drame";"Familial";
    // "Fantastique";"Histoire";""Musique";"Mystère";"Romance";"Science-Fiction";
    // "Téléfilm";"Thriller";""Western"
    private WebhookReponseDTO getMovieByGenre(String genre) {
        RestTemplate restTemplate = new RestTemplate();
        WebhookReponseDTO webhookReponseDTO = new WebhookReponseDTO();

        List<MessageDTO> messageDTOList = new ArrayList<>();
        MessageDTO messageSimpleResponse = new MessageDTO();
        messageSimpleResponse.setPlatform("ACTIONS_ON_GOOGLE");
        SimpleResponsesDTO simpleResponsesDTO = new SimpleResponsesDTO();
        SimpleResponseDTO simpleResponseDTO = new SimpleResponseDTO();
        simpleResponseDTO.setTextToSpeech("Voici les films que je te propose !!");
        simpleResponsesDTO.setSimpleResponses(List.of(simpleResponseDTO));
        messageSimpleResponse.setSimpleResponses(simpleResponsesDTO);
        messageDTOList.add(messageSimpleResponse);

        MessageDTO messageCarousel = new MessageDTO();
        messageCarousel.setPlatform("ACTIONS_ON_GOOGLE");
        CarouselSelectDTO carouselSelectDTO = new CarouselSelectDTO();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        Long idGenre = 0L;

        GenreMovieDbDTO genres = restTemplate.getForObject(BASE_URL + API_genre + "?" + API_KEY + "&" + LANGUAGE, GenreMovieDbDTO.class);

        for (GenreDTO genreDTO : genres.getGenres()) {
            if (genreDTO.getName().toLowerCase().equals(genre)) {
                idGenre = genreDTO.getId();

                ResultDiscoverMovie resultDM = restTemplate.getForObject(BASE_URL + API_discoverMovie + "?" + API_KEY + "&" + LANGUAGE + "&with_genres=" + idGenre, ResultDiscoverMovie.class);

                for (DiscoverMovieDTO discoverMovieDTO : resultDM.getResults()) {
                    ItemDTO itemDTO = new ItemDTO();
                    SelectItemInfoDTO selectItemInfoDTO = new SelectItemInfoDTO();
                    selectItemInfoDTO.setKey(discoverMovieDTO.getId().toString());
                    selectItemInfoDTO.setSynonyms(List.of(discoverMovieDTO.getTitle()));
                    itemDTO.setInfo(selectItemInfoDTO);
                    itemDTO.setTitle(discoverMovieDTO.getTitle());
                    itemDTO.setDescription(discoverMovieDTO.getOverview());
                    ImageDTO imageDTO = new ImageDTO();
                    imageDTO.setImageUri(API_IMAGE + discoverMovieDTO.getPoster_path());
                    imageDTO.setAccessibilityText(discoverMovieDTO.getTitle());
                    itemDTO.setImage(imageDTO);
                    itemDTOList.add(itemDTO);
                }

                carouselSelectDTO.setItems(itemDTOList.subList(0, 3));
                messageCarousel.setCarouselSelect(carouselSelectDTO);
                messageDTOList.add(messageCarousel);

                webhookReponseDTO.setFulfillmentMessages(messageDTOList);

                return webhookReponseDTO;
            }
        }

        if (idGenre == 0L) {
            simpleResponseDTO.setTextToSpeech("Je n'ai pas compris votre demande");
            return webhookReponseDTO;
        }

        return webhookReponseDTO;
    }

    private WebhookReponseDTO getGenreForUser() {

        WebhookReponseDTO webhookReponseDTO = new WebhookReponseDTO();
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

        return webhookReponseDTO;
    }
}
