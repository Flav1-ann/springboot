package fr.ensup.demospringboot.repository;

import fr.ensup.demospringboot.domaine.Music;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicRepository extends CrudRepository<Music,Long> {

}