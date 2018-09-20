package br.com.ap604.HelpingHand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ap604.HelpingHand.model.Teste;

@Repository
public interface TesteRepository extends JpaRepository<Teste, Long> {

}
