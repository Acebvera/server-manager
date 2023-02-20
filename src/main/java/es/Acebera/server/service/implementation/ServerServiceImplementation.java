package es.Acebera.server.service.implementation;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.Acebera.server.enumeration.Status;
import es.Acebera.server.model.Server;
import es.Acebera.server.repo.ServerRepo;
import es.Acebera.server.connection.ConnectionAdress;
import es.Acebera.server.service.ServerService;

@Service
@Transactional
public class ServerServiceImplementation implements ServerService{
	private final ServerRepo serverRepo;
	private ConnectionAdress connectionAdress;
	
	public ServerServiceImplementation (ServerRepo serverRepo) {
		this.serverRepo = serverRepo;
		connectionAdress = new ConnectionAdress();
	}
	
	@Override
	public Server create(Server server) {
		System.out.println("Saving new server: " + server.getName());
		server.setImageUrl(setServerImageUrl());
		return serverRepo.save(server);
	}
	
	@Override
	public Server ping(String ipAdress) throws IOException {
		System.out.println("Pinging server IP: " + ipAdress);
		Server server = serverRepo.findByIpAdress(ipAdress);
		//InetAddress address = InetAddress.getByName(ipAdress); 
		//server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN); isReachable suele dar problemas
		server.setStatus(connectionAdress.isReachable(ipAdress, 80, 10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
		serverRepo.save(server);
		return server;
	}
	
	
	   

	@Override
	public Collection<Server> list(int limit) {
		System.out.println("Fetching all servers");

		return serverRepo.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public Server get(Long id) {
		System.out.println("Fetching server by ID " + id);
		return serverRepo.findById(id).get();
	}

	@Override
	public Server update(Server server) {
		System.out.println("Updating server: " + server.getName());
		
		return serverRepo.save(server);
	}

	@Override
	public Boolean delete(Long id) {
		System.out.println("Deleting server by ID: " + id);
		serverRepo.deleteById(id);
		return true;
	}

	private String setServerImageUrl() {
		String [] imageNames = {"server1.png", "server2.png", "server3.png", "server4.png"};
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
	}
	
}
