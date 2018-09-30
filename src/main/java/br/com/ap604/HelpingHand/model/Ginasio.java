package br.com.ap604.HelpingHand.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ginasio")
public class Ginasio extends PontoInteresse {

	private Boolean passeEx;

	@OneToMany(mappedBy = "ginasio")
	private List<Reide>	reide	= new ArrayList<Reide>();

	public Boolean getPasseEx() {
		return passeEx;
	}

	public void setPasseEx(Boolean passeEx) {
		this.passeEx = passeEx;
	}

	public List<Reide> getReide() {
		return reide;
	}

	public void setReide(List<Reide> reide) {
		this.reide = reide;
	}
}
