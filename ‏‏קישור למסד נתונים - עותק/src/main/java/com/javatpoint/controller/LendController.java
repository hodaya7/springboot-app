package com.javatpoint.controller;

import com.javatpoint.dao.LendRepository;
import com.javatpoint.dao.MapStructMapper;
import com.javatpoint.dto.BookDTO;
import com.javatpoint.dto.CategoryDTO;
import com.javatpoint.dto.LendDTO;
import com.javatpoint.model.Borrower;
import com.javatpoint.model.Category;
import com.javatpoint.model.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/lend")//חלק מהמרכיב של הכתובת
@RestController//מגדיר את המחלקה להיות קונטרולר
@CrossOrigin
public class LendController {

    public final LendRepository repository;
    private MapStructMapper mapStructMapper;

    @Autowired//יוצר את התלות- מכניס אובייקט חדש
    public LendController(LendRepository repository,MapStructMapper mapStructMapper) {
        this.repository = repository;
        this.mapStructMapper=mapStructMapper;
    }

    @GetMapping ("/lendsFind/{id}")
    public LendDTO getLendById(@PathVariable long id)
    {

        return mapStructMapper.lendToLendDto(repository.findById(id).orElse(null));
    }

    @GetMapping ("/lendsFindBookId/{bookId}")
    public List<LendDTO> findLendByBookId(@PathVariable long bookId)
    {
        return mapStructMapper.lendsToLendDtos(repository.findAllByBookId(bookId));
    }

    @GetMapping ("/lendsFindBorrowerId/{borrowerId}")
    public List<LendDTO> findLendByBorrowerId(@PathVariable long borrowerId)
    {
        return mapStructMapper.lendsToLendDtos(repository.findAllByBorrowerId(borrowerId));
    }


    @GetMapping("/lends")
    public List<LendDTO> all(){

        return mapStructMapper.lendsToLendDtos(repository.findAll());
    }

    @PostMapping("/lends")
    public LendDTO addLend(@RequestBody LendDTO l)
    {
        return mapStructMapper.lendToLendDto(repository.save(mapStructMapper.lendDtoToLend(l)));
    }

    @PutMapping("/lends/{id}")
    public LendDTO updateLend(@PathVariable Long id, @RequestBody LendDTO newLend) {
//        Optional<Lend> lend = repository.findById(id);
//        if (lend.isPresent())//לבדוק אם יש ערך באובייקט
//            lend.map(l -> {
//                l.setLendingDate(newLend.getLendingDate());
//                l.setReturnDate(newLend.getReturnDate());
//                return repository.save(l);
//            });
//        return null;


        LendDTO lendDTO=repository.findById(id).map(
                len->{
                    Lend l=mapStructMapper.lendDtoToLend(newLend);
                    len.setId(l.getId());
                    len.setLendingDate(l.getLendingDate());
                    len.setReturnDate(l.getReturnDate());
                    len.setBook(l.getBook());
                    len.setBorrower(l.getBorrower());
                    return  mapStructMapper.lendToLendDto(repository.save(len));
                }).orElse(null);
        return lendDTO;
    }

    @DeleteMapping("/lends/{id}")
    public void deleteLend(@PathVariable long id)
    {
        repository.deleteById(id);
    }
}
