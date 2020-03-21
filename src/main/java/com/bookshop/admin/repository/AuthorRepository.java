package com.bookshop.admin.repository;

import com.bookshop.admin.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
