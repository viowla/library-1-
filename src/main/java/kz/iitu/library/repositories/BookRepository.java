package kz.iitu.library.repositories;

import kz.iitu.library.classes.Book;
import kz.iitu.library.classes.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    public List<Book> findAll();

    @Override
    public long count();

    @Override
    public void deleteById(Long aLong);

    @Override
    public void delete(Book book);

    @Override
    public void deleteAll();

    @Override
    public <S extends Book> S save(S s);

    @Override
    <S extends Book> S saveAndFlush(S s);

    @Override
    public Optional<Book> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public void flush();

    @Override
    public Book getOne(Long aLong);


}
