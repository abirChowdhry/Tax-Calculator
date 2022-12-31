package com.controller;

import com.domain.Admin;
import com.domain.Category;
import com.domain.User;
import com.exception.BadRequestAlertException;
import com.service.AdminService;
import com.service.CategoryService;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api")
public class AdminController {
    private UserService userService;
    private AdminService adminService;
    private CategoryService categoryService;

    public AdminController(AdminService adminService, UserService userService, CategoryService categoryService) {

        this.adminService = adminService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws Exception {
        if (admin.getId() != null) {
            throw new BadRequestAlertException("A new admin cannot have an id value");
        }
        adminService.insert(admin);
        return ResponseEntity.created(new URI("/admin/"))
                .body(admin);
    }
    @PostMapping ("/updateUser")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws Exception {
        if (user.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        userService.update(user);
        return ResponseEntity.created(new URI("/register"))
                .body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok().body(users);
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws Exception {
        if (category.getId() != null) {
            throw new BadRequestAlertException("A new category cannot have an id value");
        }
        categoryService.insert(category);
        return ResponseEntity.created(new URI("/category/"))
                .body(category);
    }

    @PostMapping ("/updateCategory")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) throws Exception {
        if (category.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        categoryService.update(category);
        return ResponseEntity.created(new URI("/category"))
                .body(category);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
