package es.Acebera.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import es.Acebera.server.model.Server;

public interface ServerRepo extends JpaRepository<Server, Long>{
	Server findByIpAdress(String ipAdress);
}
