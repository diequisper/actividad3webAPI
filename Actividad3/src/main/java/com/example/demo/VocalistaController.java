package com.example.demo;

import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/vocalista")
public class VocalistaController {
	
	private static final List<Vocalista>vocalistas = new ArrayList<>();
	private final AtomicLong contador = new AtomicLong();
	
	public VocalistaController(){
		initData();
	}
	
	public void initData() {
		Vocalista demiLovato = new Vocalista(contador.incrementAndGet(), "Demi Lovato", 16, "estadounidense", "Pop-Rock");
		vocalistas.add(demiLovato);
		
		Vocalista bpRose = new Vocalista(contador.incrementAndGet(), "Rosè", 24, "australiana", "K-pop");
		vocalistas.add(bpRose);
		
		Vocalista arianaGrande = new Vocalista(contador.incrementAndGet(), "Ariana Grande", 25, "estadounidense", "Pop");
		vocalistas.add(arianaGrande);
	}
	
	@GetMapping()
	public ResponseEntity<List<Vocalista>> listar(){
		return new ResponseEntity<>(vocalistas, HttpStatus.OK);
	}
	
	@GetMapping({"/{id}"})
	public ResponseEntity<Vocalista> obtener(@PathVariable long id){
		Vocalista vocalista = vocalistas.stream().filter(x -> id == x.getId()).findAny().orElse(null);
		
		if(vocalista != null) {
			return new ResponseEntity<Vocalista>(vocalista, HttpStatus.OK );
		}else {
			return new ResponseEntity<Vocalista>(vocalista, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vocalista> registrar(@RequestBody Vocalista v){
		Vocalista thisVocalista = new Vocalista(contador.incrementAndGet(), v.getNickname(), v.getEdad(), v.getNacionalidad(), v.getGeneroMusical());
		vocalistas.add(thisVocalista);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("nuevo-vocalista", "api/vocalista/" + thisVocalista.getId());
		
		return new ResponseEntity<>(thisVocalista, httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{id}"})
	public ResponseEntity<Vocalista> actualizar(@PathVariable long id, @RequestBody Vocalista v){
		Vocalista temp = null;
		
		for(Vocalista i : vocalistas) {
			if(i.getId() == id) {
				i.setNickname(v.getNickname());
				temp = i;
				break;
			}
		}
		
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Vocalista> eliminar(@PathVariable long id){
		
		Vocalista v = vocalistas.stream().filter(x -> id == x.getId()).findAny().orElse(null);
		
		if (v != null) {
			vocalistas.remove(v);
		}
		
		return new ResponseEntity<Vocalista>(HttpStatus.NO_CONTENT);
		
	}
	
	
}
