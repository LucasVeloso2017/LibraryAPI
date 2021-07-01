package br.com.library.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.library.api.dto.InputBookDTO;
import br.com.library.api.dto.ResponseBookDTO;
import br.com.library.api.entities.Book;
import br.com.library.api.exception.BookNotFoundException;
import br.com.library.api.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;


    public void create(InputBookDTO book){
        repository.save(
            new Book(book)
        );
    }

    public List<ResponseBookDTO> index(){
        return repository.findAll()
        .stream()
        .map( element -> new ResponseBookDTO(element))
        .collect(Collectors.toList());
    }

    public ResponseBookDTO show(Long id){
        return new ResponseBookDTO(
            repository.findById(id)
            .orElseThrow(()-> new BookNotFoundException("Book not Found"))
        );
    }

    public ResponseBookDTO update(InputBookDTO book, Long id){

        Book findBook = new Book(show(id));

        findBook.setAuthor(book.getAuthor());
        findBook.setTitle(book.getTitle());
        findBook.setPhoto(book.getPhoto());
        findBook.setPublisher(book.getPublisher());

        return new ResponseBookDTO(
            repository.save(findBook)
        );
    }

    public void destroy(Long id){
        repository.deleteById(id);
    }


}
