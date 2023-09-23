package com.train.reservation.reservation.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.train.reservation.reservation.model.AuthRequest;
import com.train.reservation.reservation.model.AuthResponseResponse;
import com.train.reservation.reservation.model.Train;
import com.train.reservation.reservation.model.Trains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrainController {
    public static final String url = "http://20.244.56.144/train/trains";

    @Autowired
    AuthenticationController authenticationController;

    public List<Train> getAllTrains() throws JsonProcessingException {
        AuthRequest authRequest = new AuthRequest("Train Central", "0ece2b82-f39d-4a57-91c3-cdcb93888ad7", "Sourav", "souravbhardwaj5678@gmail.com", "20J41A6949", "HFsWIyKuYYUbsYtS");
        AuthResponseResponse token = authenticationController.getToken(authRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getAccess_token());
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE); // Assuming you expect JSON

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String responseBody = response.getBody();
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Train> objects = objectMapper.readValue(responseBody, new TypeReference<List<Train>>() {});
        return responseBody;
    }

    @GetMapping(value="/trains")
    @CrossOrigin
    public  List<Train> getTrains() throws JsonProcessingException {
        return getAllTrains();
//        List<Train>trains= new ArrayList<>();
//        Train train = new Train();
//        train.setTrainName("name");
//        train.setTrainNumber("1234");
//        trains.add(train);
////        return trains;
//        return filteredResult(trains);
    }

    private List<Train> filteredResult(List<Train> trains){
        // Add your train objects here
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Train> filteredTrains = new ArrayList<>();

        for (Train train : trains) {
            LocalDateTime departureTime = LocalDateTime.of(currentDateTime.getYear(), currentDateTime.getMonthValue(),
                    currentDateTime.getDayOfMonth(), train.getDepartureTime().getHours(),
                    train.getDepartureTime().getMinutes(), train.getDepartureTime().getSeconds());

            long minutesUntilDeparture = ChronoUnit.MINUTES.between(currentDateTime, departureTime);

            if (minutesUntilDeparture >= 0 && minutesUntilDeparture <= 720 && train.getDelayedBy() <= 30) {
                filteredTrains.add(train);
            }
        }

//        filteredTrains.sort(Comparator.comparingInt(train -> train.price.get("AC"))
//                .thenComparing(Train::getDepartureTime).reversed());

        return filteredTrains;
    }
}
