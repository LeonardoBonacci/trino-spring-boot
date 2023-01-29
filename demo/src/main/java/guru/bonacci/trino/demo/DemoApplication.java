package guru.bonacci.trino.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	private final UserRepository repo;
	private final UserRepositoryCustom custom;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("start 123");
		
		log.info("count " + repo.count());
		log.info("count " + repo.countt());
		log.info(repo.findById(1l).get().toString());
		log.info(repo.findByName("foo").get().toString());
		
		log.info(repo.findPoolType("coro").get().toString());
		repo.findAllNamesInPool("foo", "bar").forEach(System.out::println);;
		log.info(custom.findBalance("coro", "foo").toString());
	}

}
