package io.geemov42.hexarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"io.geemov42.hexarch",
})
public class HexArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexArchApplication.class, args);
	}

}
