package xyz.ilhamgibran.spring.springmysql.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import xyz.ilhamgibran.spring.springmysql.model.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository extends CrudRepository<Mahasiswa, String> {
    @Query(value = "SELECT * FROM Mahasiswa WHERE name = ?1", nativeQuery = true)
    public Mahasiswa findByName(String name);
    public List<Mahasiswa> findBySksTake(int sks);
}
