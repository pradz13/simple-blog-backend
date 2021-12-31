package simple.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simple.blog.dto.BlogDto;
import simple.blog.entity.Blog;
import simple.blog.service.BlogService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/get-blogs")
    public List<BlogDto> getBlogs() {
        List<Blog> blogs = blogService.findAllBlogs();
        List<BlogDto> blogDtos = new ArrayList<>();
        for(Blog blog : blogs) {
            BlogDto blogDto = new BlogDto();
            blogDto.setId(blog.getId());
            blogDto.setBlogHeading(blog.getBlogHeading());
            blogDto.setBlogBody(blog.getBlogBody());
            blogDto.setDate(blog.getDate());
            blogDto.setTag(blog.getTag());
            blogDtos.add(blogDto);
        }
        log.info("Found {} blogs in the database for display", blogDtos.size());
        return blogDtos;
    }

    @GetMapping("/get-blog/{id}")
    public BlogDto getBlog(@PathVariable("id") String id) {
        Blog blog = blogService.findBlog(id);
        log.info("Found blog in the database with id : {} ", id);
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setBlogHeading(blog.getBlogHeading());
        blogDto.setBlogBody(blog.getBlogBody());
        blogDto.setDate(blog.getDate());
        blogDto.setTag(blog.getTag());
        return blogDto;
    }

    @PostMapping(value = "/add-blog")
    public void addBlog(@RequestBody BlogDto blogDto) {
        blogService.addBlog(blogDto);
    }
}
