package xyz.ilhamgibran.spring.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner {

	@Autowired
	private MahasiswaRepository repository;

	public static void main(String[] args) {


		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		repository.save(new Mahasiswa("171524001", "Afif Rana Muhammad", 104));
		repository.save(new Mahasiswa("171524002", "Ahmad Aji Naufal ALi", 104));

		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Mahasiswa mhs : repository.findAll()){
			System.out.println(mhs);
		}

		// fetch an individual customer
		System.out.println("Customer found with findByNim('171524001'):");
		System.out.println("--------------------------------");
		Mahasiswa mahasiswa  = repository.findByNim("171524001");
		System.out.println(mahasiswa == null ? "Data Not Found" : mahasiswa);

		System.out.println("Customers found with findByGpa(3.6):");
		System.out.println("--------------------------------");
		for (Mahasiswa mhs : repository.findBySksTake(104)) {
			System.out.println(mhs);
		}
	}
}
