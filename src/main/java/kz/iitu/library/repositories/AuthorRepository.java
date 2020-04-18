package kz.iitu.library.repositories;

import kz.iitu.library.classes.Author;
import kz.iitu.library.classes.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    public List<Author> findAll();

    @Override
    public long count();

    @Override
    public void deleteById(Long aLong);

    @Override
    public void deleteAll();

    @Override
    public <S extends Author> S save(S s);

    @Override
    <S extends Author> S saveAndFlush(S s);

    @Override
    public Optional<Author> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public void flush();

    @Override
    public Author getOne(Long aLong);

    public List<Author> findAuthorByName(String name);

    public List<Author> findAuthorByBookList(List<Book> books);
}
