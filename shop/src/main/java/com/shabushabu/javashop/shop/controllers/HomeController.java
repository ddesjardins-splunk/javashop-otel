package com.shabushabu.javashop.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/* import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
*/

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
//import io.opentelemetry.api.trace.attributes.SemanticAttributes;
//import io.opentelemetry.extension.auto.annotations.WithSpan;

import com.shabushabu.javashop.shop.services.ProductService;

@Controller
public class HomeController {


    private static final Tracer s_tracer = OpenTelemetry.getGlobalTracer("javashop.tracer");

    @Autowired
    private ProductService productService;

   @RequestMapping(value="/", method = RequestMethod.GET)
   public String usingRequestParam(Model model, @RequestParam(value="name", required=true) String thename, @RequestParam(value="color", required=true) String thecolor) {

	 	// Create Span
	   Span span = s_tracer.spanBuilder("usingRequestParam").startSpan();
	   	// Put the span into the current Context
	   try (Scope scope = span.makeCurrent()) {
	     
		 // Set Name tag: This will be our unique way to search for a trace, by specific user at a specifc time in UI.
			span.setAttribute("name",thename);
		// Set Favorite Color tag: This will allow us to see traffic by "favcolor" in UI.
			span.setAttribute("favcolor", thecolor);
        // ORIGINAL CODE
			model.addAttribute("user", new User());
			model.addAttribute("products", productService.getProducts());
		// END ORIGINAL CODE
	   
	        
		} finally {
	          span.end(); 
	   	}

     return "index";
   } 
    
   
   
   @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user, Model model) {
    	 
	// Create Span
	   Span span = s_tracer.spanBuilder("usingRequestParam").startSpan();
	   	// Put the span into the current Context
	   try (Scope scope = span.makeCurrent()) {
	     
		 // Set Name tag: This will be our unique way to search for a trace, by specific user at a specifc time in UI.
			span.setAttribute("name",user.getName());
		// Set Favorite Color tag: This will allow us to see traffic by "favcolor" in UI.
			span.setAttribute("favcolor", user.getColor());
        // ORIGINAL CODE
			model.addAttribute("products", productService.getProducts());
		// END ORIGINAL CODE
	   
	        
		} finally {
	          span.end(); 
	   	}

    	  return "index";
    }
 
}
