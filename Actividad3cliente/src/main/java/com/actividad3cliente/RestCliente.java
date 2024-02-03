package com.actividad3cliente;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestCliente {

	private static final String vocalistas = "http://localhost:8090/api/vocalista";
	private static final String vocalistasPorId = "http://localhost:8090/api/vocalista/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		getVocalistasAPI();
		
	}
	
	private static void getVocalistasAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(vocalistas, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
}
