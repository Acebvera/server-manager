package es.Acebera.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import es.Acebera.server.enumeration.Status;

@Entity
public class Server {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	@NotEmpty(message = "Ip adress cannot be empty or null")
	private String ipAdress;
	private String name;
	private String memory;
	private String type;
	private String imageUrl;
	private Status status;
	
	public Server () {
		
	}
	
	public Server(Long id,String ipAdress, String name, String memory, String type, String imageUrl, Status status) {
		this.id = id;
		this.ipAdress = ipAdress;
		this.name = name;
		this.memory = memory;
		this.type = type;
		this.imageUrl = imageUrl;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
