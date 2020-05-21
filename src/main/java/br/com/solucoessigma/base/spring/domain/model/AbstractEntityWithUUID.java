package br.com.solucoessigma.base.spring.domain.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public abstract class AbstractEntityWithUUID extends AbstractEntity {

	private static final long serialVersionUID = 7797976532750327494L;

	@Id
	@GeneratedValue
	@Column(columnDefinition = "binary(16)")
	private UUID id;
}
