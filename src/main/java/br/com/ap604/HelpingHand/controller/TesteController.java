package br.com.ap604.HelpingHand.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ap604.HelpingHand.exception.ResourceNotFoundException;
import br.com.ap604.HelpingHand.model.Teste;
import br.com.ap604.HelpingHand.repository.TesteRepository;

@RestController
@RequestMapping("/api")
public class TesteController {

	@Autowired
	TesteRepository testeRepository;

	@RequestMapping(value = "/testes", method = RequestMethod.GET)
	public List<Teste> getAllTeses() {
		return testeRepository.findAll();
	}

	@PostMapping("/testes")
	public Teste createTeste(@Valid @RequestBody Teste teste) {
		return testeRepository.save(teste);
	}

	@GetMapping("/testes/{id}")
	public Teste getTesteById(@PathVariable(value = "id") Long testeId) {
		return testeRepository.findById(testeId).orElseThrow(() -> new ResourceNotFoundException("Teste", "id", testeId));
	}

	@PutMapping("/testes/{id}")
	public Teste updateTeste(@PathVariable(value = "id") Long testeId, @Valid @RequestBody Teste testeDetails) {

		Teste teste = testeRepository.findById(testeId).orElseThrow(() -> new ResourceNotFoundException("Teste", "id", testeId));

		teste.setTitulo(testeDetails.getTitulo());
		teste.setConteudo(testeDetails.getConteudo());

		Teste updatedNote = testeRepository.save(teste);
		return updatedNote;
	}

	@DeleteMapping("/testes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long testeId) {
		Teste teste = testeRepository.findById(testeId).orElseThrow(() -> new ResourceNotFoundException("Teste", "id", testeId));

		testeRepository.delete(teste);

		return ResponseEntity.ok().build();
	}
}
