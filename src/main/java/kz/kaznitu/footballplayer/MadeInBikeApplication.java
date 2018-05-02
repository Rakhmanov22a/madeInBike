package kz.kaznitu.footballplayer;

import kz.kaznitu.footballplayer.models.MadeIn;
import kz.kaznitu.footballplayer.repositories.MadeInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MadeInBikeApplication implements CommandLineRunner {

	@Autowired
	MadeInRepository madeInRepository;

	public static void main(String[] args) { SpringApplication.run(MadeInBikeApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{

		MadeIn madeIn1 = new MadeIn();
		madeIn1.setBikeName("Yamaha");
		madeIn1.setLocation("Japan");

		MadeIn madeIn2 = new MadeIn();
		madeIn2.setBikeName("Honda");
		madeIn2.setLocation("Korean");

		madeInRepository.save(madeIn1);
		madeInRepository.save(madeIn2);
	}
}
