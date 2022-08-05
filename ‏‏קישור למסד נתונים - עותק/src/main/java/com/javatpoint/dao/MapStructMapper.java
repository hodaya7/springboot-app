package com.javatpoint.dao;

import com.javatpoint.dto.BookDTO;
import com.javatpoint.dto.BorrowerDTO;
import com.javatpoint.dto.CategoryDTO;
import com.javatpoint.dto.LendDTO;
import com.javatpoint.model.Book;
import com.javatpoint.model.Borrower;
import com.javatpoint.model.Category;
import com.javatpoint.model.Lend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Locale;

//הממשק ממיר dto לרגיל ומרגיל לdto
@Mapper(componentModel="spring")//מסבירים לו שאנו משתמשים בסביבה של ספרינג
public interface MapStructMapper {
    //תהיה לנו בעיה כי יש הבדל בין המחלקות אז צריך להסביר לו איך רוצים לערוך את השינויים האלה עם האנוטיישנס
    @Mapping(source = "category.id" ,target = "ageCategory")
    BookDTO bookToBookDto(Book b);//BookDTO
    @Mapping(source = "ageCategory" ,target = "category.id")
    Book bookDtoToBook(BookDTO b);//ולהפך

    //ישתמש בפונקציות שכבר כתבנו
    List<BookDTO> booksToBookDtos(List<Book> books);

    @Mapping(source = "category.id" ,target = "ageCategory")
    BorrowerDTO borrowerToBorrowerDto(Borrower b);//BorrowerDTO
    @Mapping(source = "ageCategory" ,target = "category.id")
    Borrower borrowerDtoToBorrower(BorrowerDTO b);//ולהפך

    List<BorrowerDTO> borrowersToBorrowerDtos(List<Borrower> b);

    @Mapping(source ="borrower.id",target = "borrowerId")
    @Mapping(source="book.id", target="bookId" )
    @Mapping(source="borrower.firstName", target="borrowerFirstName")
    @Mapping(source="borrower.lastName", target="borrowerLastName" )
    @Mapping(source="book.title", target="bookTitle" )
    LendDTO lendToLendDto (Lend l);
    @Mapping(source ="borrowerId",target = "borrower.id")
    @Mapping(source="bookId", target="book.id" )
    @Mapping(source="borrowerFirstName", target="borrower.firstName" )
    @Mapping(source="borrowerFirstName", target="borrower.lastName" )
    @Mapping(source="bookTitle", target="book.title" )
    Lend lendDtoToLend(LendDTO l);

    List<LendDTO> lendsToLendDtos(List<Lend> l);


    CategoryDTO categoryToCategoryDto(Category c);
    Category categoryDtoToCategory(CategoryDTO c);

    List<CategoryDTO> categoriesToCategoryDtos(List<Category> c);

}
