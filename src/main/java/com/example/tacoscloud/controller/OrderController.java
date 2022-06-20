package com.example.tacoscloud.controller;

import com.example.tacoscloud.entities.Taco;
import com.example.tacoscloud.entities.TacoOrder;
import com.example.tacoscloud.repository.OrderRepository;
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

    public OrderController(OrderRepository orderRepository) {
        this.orderRepo = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model, @ModelAttribute("taco") Taco taco){
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
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
