package com.ecommerce.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	//Showing cart
	@RequestMapping(value="/viewCart", method = RequestMethod.GET)
	public ModelAndView showCart(ModelAndView modelAndView, @RequestParam("userId") Integer userId) {
		List<Product> cartProducts = cartService.getProducts();
		modelAndView.addObject("cartProducts",cartProducts);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("cartview");
		return modelAndView;		
	}
	
	//Return productsview
	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute Product product, RedirectAttributes ra, @RequestParam("userId") Integer userId) {
		cartService.addProduct(product);
		System.out.println("adding product -CART CONTROLLER-");
		ra.addAttribute("userId", userId);
		return "redirect:/getProducts";
	}
	
	@RequestMapping(value="/buyingCart", method = RequestMethod.POST)
	public String buyItems(ModelAndView modelAndView, @ModelAttribute Cart cart, RedirectAttributes ra) {
		System.out.println("buying items :)");
		List<Product> cartProducts = cartService.getProducts();
		Cart current = new Cart();
		current.setUserId(cart.getUserId());
		current.setProducts(cartProducts);
		System.out.println(cartProducts);
		ra.addFlashAttribute("cart", current);
		
		double total = cartService.getTotal();
		ra.addAttribute("total", total);

		return "redirect:/addingPurchase";
	}
	
	@RequestMapping(value = "/clearCart", method = RequestMethod.GET) 
	public String clearCart(@RequestParam("userId") Integer userId, RedirectAttributes ra) {
		cartService.clearCart();
		ra.addAttribute("userId", userId);
		return "redirect:/getProducts";
	}	
}