package br.com.comprafacil.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.comprafacil.objectvalue.SituacaoEntrega;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Destinatario destinatario;
	
	@Enumerated(EnumType.STRING)
	private SituacaoEntrega statusEntrega;
	
	private BigDecimal frete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public SituacaoEntrega getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(SituacaoEntrega statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinatario == null) ? 0 : destinatario.hashCode());
		result = prime * result + ((frete == null) ? 0 : frete.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusEntrega == null) ? 0 : statusEntrega.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Entrega other = (Entrega) obj;
		if (destinatario == null) {
			if (other.destinatario != null) {
				return false;
			}
		} else if (!destinatario.equals(other.destinatario)) {
			return false;
		}
		if (frete == null) {
			if (other.frete != null) {
				return false;
			}
		} else if (!frete.equals(other.frete)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (statusEntrega != other.statusEntrega) {
			return false;
		}
		return true;
	}

}
