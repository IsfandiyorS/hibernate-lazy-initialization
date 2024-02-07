package com.example.hibernatelazyinitialization.repository;

import com.example.hibernatelazyinitialization.entity.Book;
import com.example.hibernatelazyinitialization.repository.dto.BookProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


//    TODO @Query("select b from Book as b JOIN FETCH b.author") // first solution with JOIN FETCH in hibernate n + 1 problem but for this we have to define fetch type Lazy in @ManyToOne relationship --- first APPROACH
//    List<Book> findAllBooks();


    @EntityGraph(value = "Book.author")
        // TODO Named Entity Graphs --- second APPROACH
    List<Book> findAll();

    @EntityGraph(attributePaths = {"author"}) // TODO Dynamic entity Graphs --- third APPROACH
    @Query("SELECT b FROM Book as b WHERE b.genre = :genre")
    List<Book> findByGenre(@Param("genre") String genre);

    List<BookProjection> findAllProjectedBy(); // TODO DTO projection is the next approach to avoid n+1 hibernate problem -- fourth APPROACH
}

