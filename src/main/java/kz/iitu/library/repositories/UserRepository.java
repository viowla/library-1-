package kz.iitu.library.repositories;

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
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    public List<User> findAll();

    @Override
    public long count();

    @Override
    public void deleteById(Long aLong);

    @Override
    public void deleteAll();

    @Override
    public <S extends User> S save(S s);

    @Override
    <S extends User> S saveAndFlush(S s);

    @Override
    public Optional<User> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public void flush();

    @Override
    public User getOne(Long aLong);

    public List<User> findAllByNameContainsAndAge(String name, Integer age);

    public List<User> findAllByOrderByBookId(String name,Long id);
}
