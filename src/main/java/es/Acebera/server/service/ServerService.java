package es.Acebera.server.service;

import java.io.IOException;
import java.util.Collection;

import es.Acebera.server.model.Server;

public interface ServerService {
	Server create(Server server);
	Server ping (String ipAdress) throws IOException;
	Collection<Server> list (int limit); //Limitar el numero de servidores listados
	Server get (Long id);
	Server update (Server server);
	Boolean delete(Long id);
}
