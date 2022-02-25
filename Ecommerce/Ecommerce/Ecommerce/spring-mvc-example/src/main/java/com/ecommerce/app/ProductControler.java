package com.ecommerce.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.ProductService;

@Controller
public class ProductControler {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/getProducts", method= RequestMethod.GET)
	public ModelAndView getAllProducts(ModelAndView modelAndView,@RequestParam("userId") Integer userId, @ModelAttribute Product product, Model model) {
		//productService.saveProduct(product);
		List<Product> productsList = productService.getProductsList();
		modelAndView.addObject("productsList",productsList);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("productsview");
		return modelAndView;
	}
	
	@RequestMapping(value="/getProductByName", method= RequestMethod.GET)
	public ModelAndView getProductByName(ModelAndView modelAndView, @RequestParam("productName") String productName, @RequestParam("userId") Integer userId) {
		List<Product> productsList = productService.getProductByName(productName);
		System.out.println("Product name: " + productName);
		modelAndView.addObject("products",productsList);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("productbynameview");
		return modelAndView;
	}
	
	/*@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return "productsview";
	}*/
	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return "productsview";
	}
}