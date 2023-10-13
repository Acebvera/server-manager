package es.Acebera.server;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import es.Acebera.server.enumeration.Status;
import es.Acebera.server.model.Server;
import es.Acebera.server.repo.ServerRepo;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run (ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "8 GB", "Personal PC", "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.51", "Fedora Linux", "32 GB", "Dell Tower", "http://localhost:8080/server/image/server2.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.28", "Microsoft Windows Server 2012", "128 GB", "Web Server", "http://localhost:8080/server/image/server3.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "64 GB", "Mail Server", "http://localhost:8080/server/image/server4.png", Status.SERVER_UP));
			
		};
	}
	
	/*@Bean
	public CorsFilter corsFilter () {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new 
	}*/

}
