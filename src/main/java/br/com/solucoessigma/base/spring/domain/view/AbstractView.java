package br.com.solucoessigma.base.spring.domain.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mauricio
 * @since v1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractView implements Serializable {

	private static final long serialVersionUID = -179197786190794475L;

	private Boolean active;

	private Date created;

	private Date modified;

	private Boolean getActive() {
		return this.active;
	}

	public Boolean isActive() {
		return this.getActive();
	}
}
