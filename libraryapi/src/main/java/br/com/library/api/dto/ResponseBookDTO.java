package br.com.library.api.dto;

import br.com.library.api.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBookDTO {
    
    private Long id;

    private String title;

    private String publisher;

    private String photo;

    private String author;

    public ResponseBookDTO(Book book){
        this.id = book.getId();
        this.author = book.getAuthor();
        this.title = book.getTitle();
        this.publisher = book.getPublisher();
        this.photo = book.getPhoto();
    }
}
