package br.com.library.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.library.api.dto.InputBookDTO;
import br.com.library.api.dto.ResponseBookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;

    private String publisher;

    private String photo;

    private String author;

    public Book(String title,String publisher,String photo,String author){
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.photo = photo;
    }

    public Book(ResponseBookDTO book){
        this.id = book.getId();
        
        this.author = book.getAuthor();
        this.title = book.getTitle();
        this.publisher = book.getPublisher();
        this.photo = book.getPhoto();
    }
    
    public Book(InputBookDTO book){
        this.author = book.getAuthor();
        this.title = book.getTitle();
        this.publisher = book.getPublisher();
        this.photo = book.getPhoto();
    }
}
