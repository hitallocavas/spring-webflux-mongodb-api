package br.com.reactive.webflux.api.domain.parser;

import br.com.reactive.webflux.api.domain.document.Playlist;
import br.com.reactive.webflux.api.entrypoints.request.PlaylistRequest;

public class PlaylistParser {
    public static Playlist parseRequest(PlaylistRequest playlistRequest){
        return Playlist.builder()
                .name(playlistRequest.getName())
                .build();
    }
}
