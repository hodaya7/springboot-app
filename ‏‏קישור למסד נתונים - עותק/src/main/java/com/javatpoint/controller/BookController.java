package com.javatpoint.controller;

import com.javatpoint.dao.BookRepository;
import com.javatpoint.dao.MapStructMapper;
import com.javatpoint.dto.BookDTO;
import com.javatpoint.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RequestMapping("api/book")
@RestController
@CrossOrigin
public class BookController {


    public final BookRepository repository;
    private MapStructMapper mapStructMapper;

    public BookController(BookRepository repository,MapStructMapper mapStructMapper) {

        this.repository = repository;
        this.mapStructMapper=mapStructMapper;
    }

    @GetMapping ("/booksFind/{id}")
    public BookDTO getBookById(@PathVariable Long id)
    {
        return mapStructMapper.bookToBookDto(repository.findById(id).orElse(null));
    }
    @GetMapping ("/booksFindAge/{age}")
    public List<BookDTO> findBookByAge(@PathVariable int age)
    {
        return mapStructMapper.booksToBookDtos(repository.findAllByAge(age));
    }

    @GetMapping ("/booksFindAgeStr/{str}")
    public List<BookDTO> findBookByStr(@PathVariable String str)
    {
        return mapStructMapper.booksToBookDtos(repository.findAllByStr(str));
    }

    @GetMapping("/books")
    public List<BookDTO> all() {

        return mapStructMapper.booksToBookDtos(repository.findAll());
    }

    @PostMapping("/books")
    public BookDTO addBook(@RequestBody BookDTO b) {
        return mapStructMapper.bookToBookDto(repository.save(mapStructMapper.bookDtoToBook(b)));
    }

    @PutMapping("/books/{id}")
    public BookDTO updateBook( @PathVariable long id,@RequestBody BookDTO newBook) {
//            book.map(b -> {
//                        b.setTitle(newBook.getTitle());
//                        b.setAuthor(newBook.getAuthor());
//                        b.setSummary(newBook.getSummary());
//                        b.setPageCount(newBook.getPageCount());
//                        return repository.save(b);
//                    });
//        return null;

        BookDTO bookDTO= repository.findById(id).map(
                boo->
                {
                    Book b = mapStructMapper.bookDtoToBook(newBook);
                    boo.setId(b.getId());
                    boo.setTitle(b.getTitle());
                    boo.setAuthor(b.getAuthor());
                    boo.setSummary(b.getSummary());
                    boo.setPageCount(b.getPageCount());

                    boo.setCategory(b.getCategory());
                    boo.setLends(b.getLends());
                    return mapStructMapper.bookToBookDto(repository.save(boo));
                    }).orElse(null);
           return bookDTO;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id)
    {
        repository.deleteById(id);
    }
}
