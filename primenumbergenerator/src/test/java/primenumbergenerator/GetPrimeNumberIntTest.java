package primenumbergenerator;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
class GetPrimeNumberIntTest {

  
  @Test
  public void testPrimeNumberSuccess200() throws URISyntaxException 
  {
      RestTemplate restTemplate = new RestTemplate();
       
      final String baseUrl = "http://localhost:8080/primes/10";
      URI uri = new URI(baseUrl);
   
      ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
       
      //Verify request succeed
      Assert.assertEquals(200, result.getStatusCodeValue());
  }
  
  @Test
  public void testPrimeNumberFailure400() throws URISyntaxException 
  {
      RestTemplate restTemplate = new RestTemplate();
       
      final String baseUrl = "http://localhost:8080/primes/a";
      URI uri = new URI(baseUrl);
      
      try {
   
      restTemplate.getForEntity(uri, Object.class);
      
      }catch(HttpClientErrorException e){
          Assert.assertEquals(400, e.getRawStatusCode());
      }
       
  }
  
  @Test
  public void testPrimeNumberFailure404() throws URISyntaxException 
  {
      RestTemplate restTemplate = new RestTemplate();
       
      final String baseUrl = "http://localhost:8080/primes/100/22";
      URI uri = new URI(baseUrl);
      
      try {
   
      restTemplate.getForEntity(uri, Object.class);
      
      }catch(HttpClientErrorException e){
          Assert.assertEquals(404, e.getRawStatusCode());
      }
       
  }
  
  @Test
  public void testPrimeNumberhasBody() throws URISyntaxException 
  {
      RestTemplate restTemplate = new RestTemplate();
       
      final String baseUrl = "http://localhost:8080/primes/10";
      URI uri = new URI(baseUrl);
   
      ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
       
      //Verify request succeed
      Assert.assertEquals(true, result.hasBody());
  }

}