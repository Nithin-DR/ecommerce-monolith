package com.nithin.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//The above annotation Internally combines below three annotations:
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class EcommerceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);


        System.out.println("JVM Starts --> main() --> SpringApplication.run()--> Create Spring Container-->Scan Packages -->Create Beans --> Auto Configuration-->Start Embedded Tomcat --> Application Ready");
        System.out.println("E-Commerce Application Started Successfully");

	}

}
