package com.javatpoint.controller;


import com.javatpoint.dao.BorrowerRepository;
import com.javatpoint.dao.MapStructMapper;
import com.javatpoint.dto.BookDTO;
import com.javatpoint.dto.BorrowerDTO;
import com.javatpoint.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController//מגדיר את המחלקה להיות קונטרולר(מה שגורם לזה לעלות לרשת)
//- ליגרום לזה לעבוד כשרת, עכשיו זו תהיה מחלקה שאמורה להיות לה כתובת
//כדי להגדיר איזה כתובת:
@RequestMapping("api/borrower")//חלק מהמרכיב של הכתובת(ההתחלה זה local host)
@CrossOrigin
public class BorrowerController {
//שנוכל לגשת לפונקציה מתוך הקונטרולר, נסביר לפונק:
//    @GetMapping(:"myName")
//public  String getMyName()
//{
//    return "dina";
//}

    public final BorrowerRepository repository;
    private MapStructMapper mapStructMapper;

    @Autowired//יוצר את התלות- מכניס אובייקט חדש
    public BorrowerController(BorrowerRepository repository,MapStructMapper mapStructMapper)
    {
        this.repository = repository;
        this.mapStructMapper=mapStructMapper;
    }

//    @GetMapping ("/borrowers/{id}")
//    public BorrowerDTO getBorrowerById(@PathVariable long id)
//    {
//        return mapStructMapper.borrowerToBorrowerDto(repository.findById(id).orElse(null));
//    }

    @GetMapping ("/borrowers/{id}")
    public BorrowerDTO getBorrowerById(@PathVariable Long id)
    {
        return mapStructMapper.borrowerToBorrowerDto(repository.findById(id).orElse(null));
    }

    @GetMapping("/borrowers")
    public List<BorrowerDTO> all(){

        return mapStructMapper.borrowersToBorrowerDtos(repository.findAll());
    }

    @PostMapping("/borrowers")
    public BorrowerDTO addBorrower(@RequestBody BorrowerDTO b)
    {
        return mapStructMapper.borrowerToBorrowerDto(repository.save(mapStructMapper.borrowerDtoToBorrower(b)));
    }

    @PutMapping("/borrowers/{id}")
    public BorrowerDTO updateBorrower(@PathVariable long id, @RequestBody BorrowerDTO newBorrower) {
//        Optional<Borrower> borrower = repository.findById(id);
//        if (borrower.isPresent())//לבדוק אם יש ערך באובייקט
//            borrower.map(b -> {
//                b.setTz(newBorrower.getTz());
//                b.setFirstName(newBorrower.getFirstName());
//                b.setLastName(newBorrower.getLastName());
//                b.setPhoneNumber(newBorrower.getPhoneNumber());
//                b.setMail(newBorrower.getMail());
//                return repository.save(b);
//            });
//        return null;

        BorrowerDTO borrowerDTO=repository.findById(id).map(
                borr->{
                    Borrower b=mapStructMapper.borrowerDtoToBorrower(newBorrower);
                    borr.setId(b.getId());
                    borr.setTz(b.getTz());
                    borr.setFirstName(b.getFirstName());
                    borr.setLastName(b.getLastName());
                    borr.setPhoneNumber(b.getPhoneNumber());
                    borr.setMail(b.getMail());
                    return  mapStructMapper.borrowerToBorrowerDto(repository.save(borr));
                }).orElse(null);
        return borrowerDTO;
    }


    @DeleteMapping("/borrowers/{id}")
    public void deleteBorrower(@PathVariable long id)
    {
        repository.deleteById(id);
    }
}
