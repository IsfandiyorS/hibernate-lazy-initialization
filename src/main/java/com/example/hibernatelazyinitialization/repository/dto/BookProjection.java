package com.example.hibernatelazyinitialization.repository.dto;

public interface BookProjection {
    Long getId();
    String getTitle();
    String getGenre();
    AuthorProjection getAuthor();
}
