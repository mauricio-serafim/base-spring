package br.com.solucoessigma.base.spring.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 * @author mauricio
 * @since v1.0.0
 */
public interface IRestController {

	public <T> ResponseEntity<List<T>> findAll();

	public default <T> ResponseEntity<T> response(T body) {
		return body == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(body);
	}

	public default <T> ResponseEntity<List<T>> response(List<T> list) {
		return ResponseEntity.ok(list);
	}
}
