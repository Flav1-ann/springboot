package fr.ensup.demospringboot.repository;

import fr.ensup.demospringboot.domaine.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {

}