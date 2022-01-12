package fr.ensup.demospringboot.domaine;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    public Music(){}

    public Music(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Music(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format(
                "Music[id=%d, title='%s', author='%s']",
                id, title, author);
    }

}
