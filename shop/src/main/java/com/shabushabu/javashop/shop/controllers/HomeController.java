package com.shabushabu.javashop.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import io.opentelemetry.extension.auto.annotations.WithSpan;

import com.shabushabu.javashop.shop.services.ProductService;

@Controller
public class HomeController {
	//private static final Tracer s_tracer = GlobalOpenTelemetry.getTracer("javasshop.tracer");

    @Autowired
    private ProductService productService;

    
    /*
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
   */
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String usingRequestParam(Model model, @RequestParam(value="name", required=false) String theName, @RequestParam(value="location", required=false) String theLocation) {
	
		model.addAttribute("user", new User());
		model.addAttribute("products", productService.getProducts());
		
		if (null != theLocation && theLocation.equalsIgnoreCase("Chicago")) {
			myCoolFunction();
		}
      return "index";
    } 
    
    private void myCoolFunction() {
    	try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   
   
   @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user, Model model) {
    	 
        // ORIGINAL CODE
			model.addAttribute("products", productService.getProducts());
		// END ORIGINAL CODE
		return "index";
    }
 
}
