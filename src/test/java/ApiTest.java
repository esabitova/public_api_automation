import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;
import utils.TestBase;
import utils.PropertiesLoader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest extends TestBase {

    HttpGet getRequest;
    HttpResponse response;

    String baseURL = PropertiesLoader.loadProperty("url");


    @Test
    public void testEntries_valid() throws IOException {
        getRequest = new HttpGet(baseURL+ Constants.ENTRIES+"?category=animals"+"&https=true");
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }

    @Test
    public void testRandom_valid() throws IOException {
        getRequest = new HttpGet(baseURL+ Constants.RANDOM+"?auth=null");
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);

    }

    @Test
    public void testCategories_valid() throws IOException {
        getRequest = new HttpGet(baseURL+Constants.CATEGORIES);
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);

    }

    @Test
    public void testHealth_valid() throws IOException {
        getRequest = new HttpGet(baseURL+Constants.HEALTH);
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }



}
