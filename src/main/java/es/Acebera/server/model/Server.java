package es.Acebera.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.Acebera.server.enumeration.Status;

@Entity
public class Server {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ipAdress;
	private String name;
	private String memory;
	private String type;
	private String imageUrl;
	private Status status;
}
