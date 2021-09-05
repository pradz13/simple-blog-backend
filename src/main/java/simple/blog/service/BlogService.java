package simple.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.blog.dto.BlogDto;
import simple.blog.entity.Blog;
import simple.blog.repository.BlogRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void addBlog(BlogDto blogDto) {
        log.info("Adding the blog : {}", blogDto.getBlogHeading());
        Blog blog = new Blog();
        blog.setBlogHeading(blogDto.getBlogHeading());
        String blogBody = blogDto.getBlogBody();
        blogBody = blogBody.replaceAll("(\r\n|\n)", "<br />");
        blog.setBlogBody(blogBody);
        blog.setTag(blogDto.getTag());
        blog.setDate(LocalDateTime.now());
        blogRepository.save(blog);
        log.info("Successfully added the blog : {}", blogDto.getBlogHeading());
    }

    public List<Blog> findAllBlogs() {
        List<Blog> blogs = new ArrayList<>();
        Iterable<Blog> blogIterable = blogRepository.findAllByOrderByDateDesc();
        blogIterable.forEach(blogs::add);
        return blogs;
    }

    public Blog findBlog(String id) {
        return blogRepository.findById(Long.parseLong(id)).get();
    }
}
