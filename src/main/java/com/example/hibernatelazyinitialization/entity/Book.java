package com.example.hibernatelazyinitialization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs(
    value = {
            @NamedEntityGraph(
                    name = "Book.author",
                    attributeNodes = @NamedAttributeNode(
                            value = "author"
                    )
            )
    }
)
public class Book {

    @Id
    private Long id;

    private String title;

    private String genre;

//    @ManyToOne(fetch = FetchType.LAZY) TODO solution with JOIN FETCH
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String title, Author author) {
        this.author = author;
        this.title = title;
    }
}
