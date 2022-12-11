package edu.famu.booking;
import edu.famu.booking.models.parse.Property;
import io.github.cdimascio.dotenv.Dotenv;
import org.parse4j.Parse;
import org.parse4j.util.ParseRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyInvApplication {
	public static void main(String[] args) {
		ParseRegistry.registerSubclass(Property.class);
		Dotenv dotenv = Dotenv.configure().filename("env").load();
		Parse.initialize(dotenv.get("PARSE_APP_ID"), dotenv.get("PARSE_REST_ID"));
		SpringApplication.run(MyInvApplication.class, args);
	}
}
