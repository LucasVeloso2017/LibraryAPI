package br.com.library.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.library.api.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    
}
