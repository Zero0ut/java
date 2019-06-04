package com.phoneix.projects.react;

import com.phoneix.projects.react.dao.BlogRepository;
import com.phoneix.projects.react.dao.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
public class ReactApplication implements CommandLineRunner {

	@Autowired
	private BlogRepository blogRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReactApplication.class, args);
	}

	@Override
	public void run(String args[]) {
		final Blog johnAoe = new Blog("john", "aoe", "loser");
		final Blog johnBoe = new Blog("john", "boe", "a bit of a loser");
		final Blog johnCoe = new Blog("john", "coe", "average");
		final Blog johnDoe = new Blog("john", "doe", "winner");

		blogRepository.save(johnAoe).subscribe();
	}
}
