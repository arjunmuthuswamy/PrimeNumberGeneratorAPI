package primenumbergenerator;
import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;


public class GetPrimeNumberUnitTest {
	
	
	
	
	@Test
    public void testPrimeValue2() {
		GetPrimeNumber msao = new GetPrimeNumber();
		String result = msao.getPrimeValueAsString(2);
		assertEquals("2", result);
        
    }
	
	@Test
    public void testPrimeValue7() {
		GetPrimeNumber msao = new GetPrimeNumber();
		String result = msao.getPrimeValueAsString(7);
		assertEquals("2,3,5,7", result);
        
    }
	
	@Test
    public void testPrimeValue10() {
		GetPrimeNumber msao = new GetPrimeNumber();
		String result = msao.getPrimeValueAsString(10);
		assertEquals("2,3,5,7", result);
        
    }
	
	@Test
    public void testPrimeValue20() {
		GetPrimeNumber msao = new GetPrimeNumber();
		String result = msao.getPrimeValueAsString(20);
		assertEquals("2,3,5,7,11,13,17,19", result);
        
    }
	
	
	@Test
    public void testPrimeValueJSON10() {
		GetPrimeNumber msao = new GetPrimeNumber();
		String result = msao.getPrime(10);
		
		try {
			JSONAssert.assertEquals("{\"Initial\":10,\"Primes\":\"2,3,5,7\"}", result, false);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}  
        
    }
	
	@Test
    public void testPrimeValueJSON1() {
		GetPrimeNumber msao = new GetPrimeNumber();
		String result = msao.getPrime(1);
		
		try {
			JSONAssert.assertEquals("{\"Initial\":1,\"Error\":\"Enter a value greater then 1\"}", result, false);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}  
        
    }
	
	
	
}
