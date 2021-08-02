package primenumbergenerator;


import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SpringBootApplication
@RestController
public class GetPrimeNumber {

public static void main(String[] args) {
	SpringApplication.run(GetPrimeNumber.class, args);
}

@GetMapping("/primes/{number}")
@ResponseBody
public String getPrime(@PathVariable("number") int number) {
	
		ObjectMapper objectMapper = new ObjectMapper();			
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("Initial", number);
		String arrayToJson = "";
	
		if(number>1) {
			objectNode.put("Primes",getPrimeValueAsString(number));
		}else {
			objectNode.put("Error", "Enter a value greater then 1");
		}
	      
		 try {
			arrayToJson = objectMapper.writeValueAsString(objectNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return arrayToJson;
		

}

protected String getPrimeValueAsString(int number) {
	
	List<Integer> list = IntStream.range(0, number+1).filter(i -> isPrime(i)).boxed().collect(Collectors.toList());				
	String primes = list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(","));			
	
	return primes;
}

static boolean isPrime(int number) {
    return number > 1 && IntStream.rangeClosed(2, number/2).noneMatch(i -> number % i == 0);
}
	
}

