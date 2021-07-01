package br.com.library.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.library.api.dto.InputBookDTO;
import br.com.library.api.dto.ResponseBookDTO;
import br.com.library.api.service.BookService;

@RestController
@RequestMapping("book")
public class BooksController {
    
    @Autowired
    private BookService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(
        @RequestBody @Validated InputBookDTO dto
    ){
        service.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<ResponseBookDTO>> index(){
        return ResponseEntity.ok(service.index());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBookDTO> show(
        @PathVariable Long id
    ){
        return ResponseEntity.ok(service.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBookDTO> update(
        @PathVariable Long id,
        @RequestBody @Validated InputBookDTO dto
    ){
        return ResponseEntity.ok(service.update(dto,id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void destroy(
        @PathVariable Long id
    ){
        service.destroy(id);
    }
}
