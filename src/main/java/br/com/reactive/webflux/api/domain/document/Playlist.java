package br.com.reactive.webflux.api.domain.document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Builder
@Document
public class Playlist {
    @MongoId
    private String id;
    private String name;
}
