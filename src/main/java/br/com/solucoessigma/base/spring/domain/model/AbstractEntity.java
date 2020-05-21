package br.com.solucoessigma.base.spring.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mauricio
 * @since v1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4364324914627685713L;

	@NotNull
	@Column(nullable = false)
	private Boolean active = Boolean.TRUE;

	@NotNull
	@CreatedDate
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();

	@NotNull
	@LastModifiedDate
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified = new Date();

	private Boolean getActive() {
		return this.active;
	}

	public Boolean isActive() {
		return this.getActive();
	}
}
