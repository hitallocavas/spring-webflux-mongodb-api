package br.com.reactive.webflux.api.entrypoints.controller;

import br.com.reactive.webflux.api.domain.document.Playlist;
import br.com.reactive.webflux.api.domain.parser.PlaylistParser;
import br.com.reactive.webflux.api.entrypoints.request.PlaylistRequest;
import br.com.reactive.webflux.api.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "playlists")
@Slf4j
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

    @GetMapping(value = "events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> findEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5L));
        Flux<Playlist> events = playlistService.findAll();
        log.info("Passou por evento");
        return Flux.zip(interval, events);
    }
}
