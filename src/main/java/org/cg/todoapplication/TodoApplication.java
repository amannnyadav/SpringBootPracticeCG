package org.cg.todoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequestMapping("/todo")
@RestController
public class TodoApplication {
    List<Data> lists = new ArrayList<>();

    @PostMapping
    public String addList(@RequestBody Data data){
        lists.add(data);
        return "List added into db";
    }

    @GetMapping
    public List<Data> getList(){
        return lists;
    }

    @PutMapping("/{title}")
    public String editList(@PathVariable String title, @RequestBody Data data){
        for(Data list : lists){
            if(list.getTitle().equals(title)){
                list.setTitle(data.getTitle());
                list.setDescription(data.getDescription());
                return "List with title: "+title+" got updated!";
            }
        }
        return "List not found!";
    }

    @DeleteMapping("/{title}")
    public String deleteList(@PathVariable String title) {
        boolean removed = lists.removeIf(list -> list.getTitle().equals(title));
        return removed ? "Title: "+title+" list deleted successfully" : "List not found!";
    }


    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

}