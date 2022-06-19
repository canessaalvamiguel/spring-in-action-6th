package com.example.tacoscloud.controller;

import com.example.tacoscloud.entities.Taco;
import com.example.tacoscloud.entities.TacoOrder;
import com.example.tacoscloud.entities.TacoUDT;
import com.example.tacoscloud.repository.OrderRepository;
import com.example.tacoscloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepo;
    private TacoRepository tacoRepository;

    public OrderController(OrderRepository orderRepository, TacoRepository tacoRepository) {
        this.orderRepo = orderRepository;
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model, @ModelAttribute("taco") TacoUDT taco){
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.addTaco(taco);
        model.addAttribute("tacoOrder", tacoOrder);

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }

        orderRepo.save(order);
        for (TacoUDT t : order.getTacos()){
            Taco taco_ = new Taco();
            taco_.setName(t.getName());
            taco_.setIngredients(t.getIngredients());
            tacoRepository.save(taco_);
        }
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
