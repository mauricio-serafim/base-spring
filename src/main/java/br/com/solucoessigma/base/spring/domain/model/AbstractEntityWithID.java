package br.com.solucoessigma.base.spring.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mauricio
 * @since v1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntityWithID extends AbstractEntity {

	private static final long serialVersionUID = 5692678013032566506L;

	@Id
	@TableGenerator(allocationSize = 1, name = "_sequence", pkColumnName = "entity_name", valueColumnName = "last_generated_value")
	@GeneratedValue(generator = "_sequence", strategy = GenerationType.TABLE)
	private Long id;
}
