package xyz.ilhamgibran.spring.springmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MahasiswaRepository extends MongoRepository<Mahasiswa, String> {
    public Mahasiswa findByNim(String nim);
    public List<Mahasiswa> findBySksTake(int sks);
}
