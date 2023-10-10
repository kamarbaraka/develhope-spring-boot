package com.develhope.develhopespringboot.app.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * implementation of the weather API.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class WeatherAPIImpl implements WeatherAPI {

    private final RestTemplate restTemplate;


    /**
     * send the request*/
    @Override
    public String getWeatherFor(double lat, double lon) {

        /*set the url and parameter if present*/
        String apiKey = "9dacb2a6ca831866fa7bc5ce5daea813";
        String url = "https://api.openweathermap.org/data/2.5/weather";
        String urlToHit = url + "?" + "lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        /*set the request*/
        ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(urlToHit, WeatherDTO.class);
        /*get the body and return weather*/
        return response.getBody().getMain();
    }
}
