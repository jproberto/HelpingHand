package br.com.ap604.HelpingHand.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"criadoEm", "atualizadoEm"}, allowGetters = true)
public class Reide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long				id;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date				criadoEm;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date				atualizadoEm;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				horaInicio;

	private Boolean				reideEx;

	@ManyToOne
	private Ginasio				ginasio;

	@ManyToOne
	private Chefe				chefe;

	@OneToMany
	private List<ListaAtaque>	listaAtaques	= new ArrayList<ListaAtaque>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Boolean getReideEx() {
		return reideEx;
	}

	public void setReideEx(Boolean reideEx) {
		this.reideEx = reideEx;
	}

	public Ginasio getGinasio() {
		return ginasio;
	}

	public void setGinasio(Ginasio ginasio) {
		this.ginasio = ginasio;
	}

	public Chefe getChefe() {
		return chefe;
	}

	public void setChefe(Chefe chefe) {
		this.chefe = chefe;
	}

	public List<ListaAtaque> getListaAtaques() {
		return listaAtaques;
	}

	public void setListaAtaques(List<ListaAtaque> listaAtaques) {
		this.listaAtaques = listaAtaques;
	}
}
