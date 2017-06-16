package backendTesting;


import model.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class WeatherTest {

    @Test
    public void weatherTest() throws IOException {
        WeatherRequester requester = new WeatherRequester();
        //Get Response from server

        Response response = requester.getWeather();
        //Check response

        Assert.assertEquals("Wrong LON: ", BigDecimal.valueOf(-0.13), response.getCoord().getLon());
        Assert.assertEquals("Wrong LAT: ",  BigDecimal.valueOf(51.51), response.getCoord().getLat());
    }
}
