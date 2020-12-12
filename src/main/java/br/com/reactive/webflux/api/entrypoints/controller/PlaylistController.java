package br.com.reactive.webflux.api.entrypoints.controller;

import br.com.reactive.webflux.api.domain.document.Playlist;
import br.com.reactive.webflux.api.domain.parser.PlaylistParser;
import br.com.reactive.webflux.api.entrypoints.request.PlaylistRequest;
import br.com.reactive.webflux.api.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping
    public Flux<Playlist> findAll(){
        return playlistService.findAll();
    }

    @GetMapping(value = "{id}")
    public Mono<Playlist> findById(@PathVariable String id){
        return playlistService.findById(id);
    }

    @PostMapping
    public Mono<Playlist> save(@RequestBody PlaylistRequest playlistRequest){
        return playlistService.save(PlaylistParser.parseRequest(playlistRequest));
    }
}
