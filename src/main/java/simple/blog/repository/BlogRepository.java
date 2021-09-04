package simple.blog.repository;

import org.springframework.data.repository.CrudRepository;
import simple.blog.entity.Blog;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    List<Blog> findAllByOrderByDateDesc();
}
