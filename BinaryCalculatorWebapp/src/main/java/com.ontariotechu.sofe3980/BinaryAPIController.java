package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	 @GetMapping("/add")
    public String add(@RequestParam String a, @RequestParam String b) {
        return Binary.add(new Binary(a), new Binary(b)).getValue();
    }

    @GetMapping("/mul")
    public String mul(@RequestParam String a, @RequestParam String b) {
        return Binary.multiply(new Binary(a), new Binary(b)).getValue();
    }

    @GetMapping("/and")
    public String and(@RequestParam String a, @RequestParam String b) {
        return Binary.and(new Binary(a), new Binary(b)).getValue();
    }

    @GetMapping("/or")
    public String or(@RequestParam String a, @RequestParam String b) {
        return Binary.or(new Binary(a), new Binary(b)).getValue();
    }

}
