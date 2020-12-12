package br.com.reactive.webflux.api.repository;

import br.com.reactive.webflux.api.domain.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
