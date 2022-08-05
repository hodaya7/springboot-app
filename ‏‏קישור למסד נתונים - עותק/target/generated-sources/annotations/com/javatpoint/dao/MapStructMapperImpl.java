package com.javatpoint.dao;

import com.javatpoint.dto.BookDTO;
import com.javatpoint.dto.BorrowerDTO;
import com.javatpoint.dto.CategoryDTO;
import com.javatpoint.dto.LendDTO;
import com.javatpoint.model.Book;
import com.javatpoint.model.Borrower;
import com.javatpoint.model.Category;
import com.javatpoint.model.Lend;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T16:37:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public BookDTO bookToBookDto(Book b) {
        if ( b == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        Long id = bCategoryId( b );
        if ( id != null ) {
            bookDTO.setAgeCategory( id.intValue() );
        }
        if ( b.getId() != null ) {
            bookDTO.setId( String.valueOf( b.getId() ) );
        }
        bookDTO.setTitle( b.getTitle() );
        bookDTO.setAuthor( b.getAuthor() );
        bookDTO.setSummary( b.getSummary() );
        bookDTO.setPageCount( b.getPageCount() );

        return bookDTO;
    }

    @Override
    public Book bookDtoToBook(BookDTO b) {
        if ( b == null ) {
            return null;
        }

        Book book = new Book();

        book.setCategory( bookDTOToCategory( b ) );
        if ( b.getId() != null ) {
            book.setId( Long.parseLong( b.getId() ) );
        }
        book.setTitle( b.getTitle() );
        book.setAuthor( b.getAuthor() );
        book.setSummary( b.getSummary() );
        book.setPageCount( b.getPageCount() );

        return book;
    }

    @Override
    public List<BookDTO> booksToBookDtos(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( books.size() );
        for ( Book book : books ) {
            list.add( bookToBookDto( book ) );
        }

        return list;
    }

    @Override
    public BorrowerDTO borrowerToBorrowerDto(Borrower b) {
        if ( b == null ) {
            return null;
        }

        BorrowerDTO borrowerDTO = new BorrowerDTO();

        Long id = bCategoryId1( b );
        if ( id != null ) {
            borrowerDTO.setAgeCategory( String.valueOf( id ) );
        }
        if ( b.getId() != null ) {
            borrowerDTO.setId( String.valueOf( b.getId() ) );
        }
        borrowerDTO.setTz( b.getTz() );
        borrowerDTO.setFirstName( b.getFirstName() );
        borrowerDTO.setLastName( b.getLastName() );
        borrowerDTO.setPhoneNumber( b.getPhoneNumber() );
        borrowerDTO.setMail( b.getMail() );

        return borrowerDTO;
    }

    @Override
    public Borrower borrowerDtoToBorrower(BorrowerDTO b) {
        if ( b == null ) {
            return null;
        }

        Borrower borrower = new Borrower();

        borrower.setCategory( borrowerDTOToCategory( b ) );
        if ( b.getId() != null ) {
            borrower.setId( Long.parseLong( b.getId() ) );
        }
        borrower.setTz( b.getTz() );
        borrower.setFirstName( b.getFirstName() );
        borrower.setLastName( b.getLastName() );
        borrower.setPhoneNumber( b.getPhoneNumber() );
        borrower.setMail( b.getMail() );

        return borrower;
    }

    @Override
    public List<BorrowerDTO> borrowersToBorrowerDtos(List<Borrower> b) {
        if ( b == null ) {
            return null;
        }

        List<BorrowerDTO> list = new ArrayList<BorrowerDTO>( b.size() );
        for ( Borrower borrower : b ) {
            list.add( borrowerToBorrowerDto( borrower ) );
        }

        return list;
    }

    @Override
    public LendDTO lendToLendDto(Lend l) {
        if ( l == null ) {
            return null;
        }

        LendDTO lendDTO = new LendDTO();

        Long id = lBorrowerId( l );
        if ( id != null ) {
            lendDTO.setBorrowerId( String.valueOf( id ) );
        }
        Long id1 = lBookId( l );
        if ( id1 != null ) {
            lendDTO.setBookId( String.valueOf( id1 ) );
        }
        lendDTO.setBorrowerFirstName( lBorrowerFirstName( l ) );
        lendDTO.setBorrowerLastName( lBorrowerLastName( l ) );
        lendDTO.setBookTitle( lBookTitle( l ) );
        if ( l.getId() != null ) {
            lendDTO.setId( String.valueOf( l.getId() ) );
        }
        lendDTO.setLendingDate( l.getLendingDate() );
        lendDTO.setReturnDate( l.getReturnDate() );

        return lendDTO;
    }

    @Override
    public Lend lendDtoToLend(LendDTO l) {
        if ( l == null ) {
            return null;
        }

        Lend lend = new Lend();

        lend.setBorrower( lendDTOToBorrower( l ) );
        lend.setBook( lendDTOToBook( l ) );
        if ( l.getId() != null ) {
            lend.setId( Long.parseLong( l.getId() ) );
        }
        lend.setLendingDate( l.getLendingDate() );
        lend.setReturnDate( l.getReturnDate() );

        return lend;
    }

    @Override
    public List<LendDTO> lendsToLendDtos(List<Lend> l) {
        if ( l == null ) {
            return null;
        }

        List<LendDTO> list = new ArrayList<LendDTO>( l.size() );
        for ( Lend lend : l ) {
            list.add( lendToLendDto( lend ) );
        }

        return list;
    }

    @Override
    public CategoryDTO categoryToCategoryDto(Category c) {
        if ( c == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        if ( c.getId() != null ) {
            categoryDTO.setId( String.valueOf( c.getId() ) );
        }
        categoryDTO.setName( c.getName() );
        categoryDTO.setDescription( c.getDescription() );
        categoryDTO.setColor( c.getColor() );

        return categoryDTO;
    }

    @Override
    public Category categoryDtoToCategory(CategoryDTO c) {
        if ( c == null ) {
            return null;
        }

        Category category = new Category();

        if ( c.getId() != null ) {
            category.setId( Long.parseLong( c.getId() ) );
        }
        category.setName( c.getName() );
        category.setDescription( c.getDescription() );
        category.setColor( c.getColor() );

        return category;
    }

    @Override
    public List<CategoryDTO> categoriesToCategoryDtos(List<Category> c) {
        if ( c == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( c.size() );
        for ( Category category : c ) {
            list.add( categoryToCategoryDto( category ) );
        }

        return list;
    }

    private Long bCategoryId(Book book) {
        if ( book == null ) {
            return null;
        }
        Category category = book.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Category bookDTOToCategory(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( (long) bookDTO.getAgeCategory() );

        return category;
    }

    private Long bCategoryId1(Borrower borrower) {
        if ( borrower == null ) {
            return null;
        }
        Category category = borrower.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Category borrowerDTOToCategory(BorrowerDTO borrowerDTO) {
        if ( borrowerDTO == null ) {
            return null;
        }

        Category category = new Category();

        if ( borrowerDTO.getAgeCategory() != null ) {
            category.setId( Long.parseLong( borrowerDTO.getAgeCategory() ) );
        }

        return category;
    }

    private Long lBorrowerId(Lend lend) {
        if ( lend == null ) {
            return null;
        }
        Borrower borrower = lend.getBorrower();
        if ( borrower == null ) {
            return null;
        }
        Long id = borrower.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long lBookId(Lend lend) {
        if ( lend == null ) {
            return null;
        }
        Book book = lend.getBook();
        if ( book == null ) {
            return null;
        }
        Long id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String lBorrowerFirstName(Lend lend) {
        if ( lend == null ) {
            return null;
        }
        Borrower borrower = lend.getBorrower();
        if ( borrower == null ) {
            return null;
        }
        String firstName = borrower.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String lBorrowerLastName(Lend lend) {
        if ( lend == null ) {
            return null;
        }
        Borrower borrower = lend.getBorrower();
        if ( borrower == null ) {
            return null;
        }
        String lastName = borrower.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String lBookTitle(Lend lend) {
        if ( lend == null ) {
            return null;
        }
        Book book = lend.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    protected Borrower lendDTOToBorrower(LendDTO lendDTO) {
        if ( lendDTO == null ) {
            return null;
        }

        Borrower borrower = new Borrower();

        if ( lendDTO.getBorrowerId() != null ) {
            borrower.setId( Long.parseLong( lendDTO.getBorrowerId() ) );
        }
        borrower.setFirstName( lendDTO.getBorrowerFirstName() );
        borrower.setLastName( lendDTO.getBorrowerFirstName() );

        return borrower;
    }

    protected Book lendDTOToBook(LendDTO lendDTO) {
        if ( lendDTO == null ) {
            return null;
        }

        Book book = new Book();

        if ( lendDTO.getBookId() != null ) {
            book.setId( Long.parseLong( lendDTO.getBookId() ) );
        }
        book.setTitle( lendDTO.getBookTitle() );

        return book;
    }
}
