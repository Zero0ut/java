package com.phoenix.projects.react.dao;

import com.phoenix.projects.react.dao.entity.Blog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BlogRepository extends ReactiveMongoRepository<Blog, String> {

    Flux<Blog> findByAuthor(String author);

    Flux<Blog> findByAuthorAndDeleteIsFalse(String author);

    Flux<Blog> findByTitleAndDeleteIsFalse(String titleKeyword);

    Mono<Blog> findByTitle(String title);

    Mono<Blog> findByIdAndDeleteIsFalse(String id);
}