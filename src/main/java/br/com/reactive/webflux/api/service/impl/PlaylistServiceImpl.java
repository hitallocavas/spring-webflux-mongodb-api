package br.com.reactive.webflux.api.service.impl;

import br.com.reactive.webflux.api.domain.document.Playlist;
import br.com.reactive.webflux.api.repository.PlaylistRepository;
import br.com.reactive.webflux.api.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Override
    public Flux<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
