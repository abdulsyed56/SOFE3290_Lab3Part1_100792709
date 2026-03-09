package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("a", "");
        model.addAttribute("b", "");
        model.addAttribute("op", "+");
        model.addAttribute("result", "");
        return "calculator";
    }

    @PostMapping("/")
    public String result(
            @RequestParam("a") String a,
            @RequestParam("b") String b,
            @RequestParam("op") String op,
            Model model) {

        Binary left = new Binary(a);
        Binary right = new Binary(b);
        Binary result;

        switch (op) {
            case "+":
                result = Binary.add(left, right);
                break;
            case "*":
                result = Binary.multiply(left, right);
                break;
            case "&":
                result = Binary.and(left, right);
                break;
            case "|":
                result = Binary.or(left, right);
                break;
            default:
                result = new Binary("0");
                break;
        }

        model.addAttribute("a", left.getValue());
        model.addAttribute("b", right.getValue());
        model.addAttribute("op", op);
        model.addAttribute("result", result.getValue());

        return "calculator";
    }
}
