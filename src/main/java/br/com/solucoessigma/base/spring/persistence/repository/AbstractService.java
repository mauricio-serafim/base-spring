package br.com.solucoessigma.base.spring.persistence.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @author mauricio
 * @since v1.0.0
 */
public abstract class AbstractService<V> {

	private Class<V> destinationDefault;
	private ModelMapper mapper = new ModelMapper();

	@SuppressWarnings("unchecked")
	public AbstractService() {
		this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.destinationDefault = (Class<V>) type.getActualTypeArguments()[0];
	}

	public abstract <D> List<D> findAll();

	protected <D, S> D map(final S source, Class<D> destination) {
		return source == null ? null : this.mapper.map(source, destination);
	}

	protected <D, S> List<D> map(final Collection<S> source, Class<D> destination) {
		return source.stream().map(s -> this.map(s, destination)).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	protected <D, S> D map(final S source) {
		return (D) this.map(source, this.destinationDefault);
	}

	@SuppressWarnings("unchecked")
	protected <D, S> List<D> map(final List<S> source){
		return (List<D>) this.map(source, this.destinationDefault);
	}
}
