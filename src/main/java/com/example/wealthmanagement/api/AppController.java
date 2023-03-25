package com.example.wealthmanagement.api;

import com.example.wealthmanagement.entity.Category;
import com.example.wealthmanagement.entity.Expense;
import com.example.wealthmanagement.entity.User;
import com.example.wealthmanagement.repo.CategoryRepository;
import com.example.wealthmanagement.repo.ExpenseRepository;
import com.example.wealthmanagement.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private ExpenseRepository exrepo;
    @Autowired
    private CategoryRepository catrepo;
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword= encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }
    @GetMapping("/list_users")
    public String viewExpenselist(Model model){
        List<Expense> listExpenses = exrepo.findAll();
        model.addAttribute("listExpenses",listExpenses);
        return "users";
    }

    @PostMapping("/process_expense")
    public String processExpense(Expense expense,Model model){
        exrepo.save(expense);
        List<Expense> listExpenses = exrepo.findAll();
        model.addAttribute("listExpenses",listExpenses);
        return "users";
    }
    @GetMapping("/new_expense")
    public String showExpenseForm(Model model){
        model.addAttribute("expense",new Expense());
        return "expense";
    }

    @GetMapping("/list_category")
    public String viewCategorieslist(Model model){
        List<Category> listCategories=catrepo.findAll();
        model.addAttribute("listCategories",listCategories);
        return "categorylist";
    }
    @PostMapping("/process_category")
    public String processExpense(Category category,Model model){
        List<Expense> listExpenses = exrepo.findAll();
        model.addAttribute("listExpenses",listExpenses);
        catrepo.save(category);
        return "users";
    }
    @GetMapping("/new_category")
    public String showCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category";
    }

}
