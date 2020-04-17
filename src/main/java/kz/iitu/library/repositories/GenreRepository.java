package kz.iitu.library.repositories;

import kz.iitu.library.classes.Genre;
import kz.iitu.library.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Override
    public List<Genre> findAll();

    @Override
    public void deleteById(Long aLong);

    @Override
    public void delete(Genre genre);

    @Override
    public void deleteAll();

    @Override
    public Optional<Genre> findById(Long aLong);
}
