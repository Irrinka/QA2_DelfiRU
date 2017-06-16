package backendTesting;

import model.Response;
import org.apache.regexp.RE;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

public class WeatherRequester {
    private String URL = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";


    public Response getWeather() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Response response = mapper.readValue(new URL(URL), Response.class);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String jsonResponse = responseEntity.getBody();
        Response response = mapper.readValue(jsonResponse, Response.class);
        return response;
    }


}
