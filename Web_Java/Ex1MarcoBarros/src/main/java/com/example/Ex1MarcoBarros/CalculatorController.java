package com.example.Ex1MarcoBarros;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String Calculate(
            Model model,
            @RequestParam(name = "op1", required = false, defaultValue = "0") String op1,
            @RequestParam(name = "op2", required = false, defaultValue = "0") String op2,
            @RequestParam(name = "operator", required = false, defaultValue = "0") String operator) {

        model.addAttribute("op1", op1);
        model.addAttribute("op2", op2);
        model.addAttribute("operator", operator);

        if (Integer.parseInt(op2) == 0 && operator.equals("div")) {
            return "erro";
        }

        int result;
        switch (Objects.requireNonNull(operator)) {
            case "add" -> result = Integer.parseInt(op1) + Integer.parseInt(op2);
            case "sub" -> result = Integer.parseInt(op1) - Integer.parseInt(op2);
            case "multi" -> result = Integer.parseInt(op1) * Integer.parseInt(op2);
            case "div" -> result = Integer.parseInt(op1) / Integer.parseInt(op2);
            default -> result = 0;
        }
        model.addAttribute("result", result);
        return "calculator";
    }

}
