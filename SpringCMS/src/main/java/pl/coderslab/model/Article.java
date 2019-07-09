package pl.coderslab.model;

import pl.coderslab.entities.Author;
import pl.coderslab.entities.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 200)
    private String title;

    @ManyToOne
    private Author author;

    @OneToMany
    private Category category;


    private String content;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void preCreatePersist(){
        createdOn = LocalDateTime.now();
    }
    public void preUpdated(){
        updatedOn = LocalDateTime.now();
    }

}
