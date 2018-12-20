package itc.sevevents.controllers;

import itc.sevevents.domain.Comment;
import itc.sevevents.repos.CommentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentRepo commentRepo;

    @Autowired
    public CommentController(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping
    public List<Comment> list() {
        return commentRepo.findAll();
    }

    @GetMapping("{id}")
    public Comment getOne(@PathVariable("id") Comment comment) {
        return comment;
    }

    @PostMapping
    Comment create(@RequestBody Comment comment){
        return commentRepo.save(comment);
    }

    @PutMapping("{id}")
    public Comment update (
            @PathVariable("id") Comment commentFromDb,
            @RequestBody Comment comment
    ){
        BeanUtils.copyProperties(comment, commentFromDb, "id");

        return commentRepo.save(commentFromDb);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Comment comment){
        commentRepo.delete(comment);
    }

}

