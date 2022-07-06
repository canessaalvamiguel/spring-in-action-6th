package com.example.tacoscloud.controller;

import com.example.tacoscloud.entities.Taco;
import com.example.tacoscloud.entities.TacoOrder;
import com.example.tacoscloud.entities.User;
import com.example.tacoscloud.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {

/**
 * There’s one other way of identifying who the authenticated user is, although it’s a bit messy in
 * the sense that it’s very heavy with security-specific code. You can obtain an Authentication
 * object from the security context and then request its principal like this:
 *
  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  User user = (User) authentication.getPrincipal();
 *
 * Although this snippet is thick with security-specific code, it has one advantage over the other
 * approaches described: it can be used anywhere in the application, not only in a controller’s
 * handler methods. This makes it suitable for use in lower levels of the code.
 */

        if(errors.hasErrors()){
            return "orderForm";
        }

        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
