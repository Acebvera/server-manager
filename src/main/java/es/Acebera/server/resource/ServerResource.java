package es.Acebera.server.resource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.Acebera.server.enumeration.Status;
import es.Acebera.server.model.Response;
import es.Acebera.server.model.Server;
import es.Acebera.server.service.implementation.ServerServiceImplementation;

@RestController
@RequestMapping("/server")
public class ServerResource {
	private final ServerServiceImplementation serverService;
	
	public ServerResource (ServerServiceImplementation serverService) {
		this.serverService = serverService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Response> getServers () {
		
		return ResponseEntity.ok(new Response(LocalDateTime.now(), HttpStatus.OK.value(), HttpStatus.OK, "Servers retrieved", Map.of("servers", serverService.list(30))));
		
	}
	
	@GetMapping("/ping/{ipAddress}")
	public ResponseEntity<Response> pingServer (@PathVariable("ipAddress") String ipAddress) throws IOException {
		
		Server server = serverService.ping(ipAddress);
		return ResponseEntity.ok(new Response(LocalDateTime.now(), HttpStatus.OK.value(), HttpStatus.OK, server.getStatus() == Status.SERVER_UP ? "Ping success" : "Ping failed", Map.of("server", server)));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> saveServer (@RequestBody @Valid Server server) {
		
		return ResponseEntity.ok(new Response(LocalDateTime.now(), HttpStatus.CREATED.value(), HttpStatus.CREATED, "Server created", Map.of("server", serverService.create(server))));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getServer (@PathVariable("id") Long id) {
		
		return ResponseEntity.ok(new Response(LocalDateTime.now(), HttpStatus.OK.value(), HttpStatus.OK, "Server retrieved", Map.of("server", serverService.get(id))));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteServer (@PathVariable("id") Long id) {
		
		return ResponseEntity.ok(new Response(LocalDateTime.now(), HttpStatus.OK.value(), HttpStatus.OK, "Server deleted", Map.of("deleted", serverService.delete(id))));
	}
}
