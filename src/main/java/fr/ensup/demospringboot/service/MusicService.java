package fr.ensup.demospringboot.service;

import fr.ensup.demospringboot.domaine.Music;
import fr.ensup.demospringboot.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Iterable<Music> listAll() {
        return musicRepository.findAll();
    }

    public void save(Music music) {
        musicRepository.save(music);
    }

    public Music get(long id) {
        return musicRepository.findById(id).get();
    }

    public void delete(long id) {
        musicRepository.deleteById(id);
    }
}
