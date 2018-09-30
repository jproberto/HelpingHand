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
public class ListaAtaque {

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
	private Date				horaAtaque;

	@ManyToOne
	private Jogador				criador;

	@OneToMany(mappedBy = "listaAtaque")
	private List<Participante>	participantes	= new ArrayList<Participante>();

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

	public Date getHoraAtaque() {
		return horaAtaque;
	}

	public void setHoraAtaque(Date horaAtaque) {
		this.horaAtaque = horaAtaque;
	}

	public Jogador getCriador() {
		return criador;
	}

	public void setCriador(Jogador criador) {
		this.criador = criador;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

}
