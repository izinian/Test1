package com.ibs.litmus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
//import org.slf4j.profiler.Profiler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class LoggingDemoApplication {
	Logger log = LoggerFactory.getLogger( LoggingDemoApplication.class);

	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		//Profiler myProfiler = new Profiler("MYPROFILER");
		//myProfiler.start("List generation process");
		
		log.info("client has made a request");
        Marker myMarker = MarkerFactory.getMarker("MYMARKER");
        
        //return "finished";
		log.debug("Request {}", name);
		
		//log.info(myMarker, "Starting request");
        //Thread.sleep(5000);
		
		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Opps Exception raised....");
		}
		String response = "Hi " + name + " Welcome...";
		log.debug("Response {}", response);
		
        //log.debug(myMarker, "Finished request");
		log.debug("{} Finished request",myMarker);
		
		//myProfiler.stop().print();
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(LoggingDemoApplication.class, args);
	}

}
