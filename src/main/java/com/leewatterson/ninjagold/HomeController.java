package com.leewatterson.ninjagold;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		if(gold == null) {
			System.out.println("Starting new Session");
			session.setAttribute("gold", 0);
		}
		else if (gold < -100) {
			return "prison.jsp";
		}
		return "index.jsp";
	}
	@RequestMapping(value="/mine", method=RequestMethod.POST)
	public String mine(@RequestParam(value="mine") String mine, HttpSession session, RedirectAttributes redirectAttributes) {
		Integer gold = (Integer) session.getAttribute("gold");
		System.out.println(mine);
		Random goldy = new Random();
		Date today = new Date();
		
		if(mine.equals("farm")) {
			int farmGold = goldy.nextInt(11) + 10;
			System.out.println(farmGold);
			gold += farmGold;
			redirectAttributes.addFlashAttribute("mined", "You earned " + farmGold + " gold on " + today);
		}
		else if (mine.equals("cave")) {
			int caveGold = goldy.nextInt(6) + 5;
			System.out.println(caveGold);
			gold += caveGold;
			redirectAttributes.addFlashAttribute("mined", "You earned " + caveGold + " gold on " + today);
		}
		else if (mine.equals("house")) {
			int houseGold = goldy.nextInt(4) + 2;
			System.out.println(houseGold);
			gold += houseGold;
			redirectAttributes.addFlashAttribute("mined", "You earned " + houseGold + " gold on " + today);
		}
		else if (mine.equals("casino")) {
			int casinoGold = goldy.nextInt(100) - 50;
			System.out.println(casinoGold);
			gold += casinoGold;
			if(casinoGold >= 0) {
				redirectAttributes.addFlashAttribute("mined", "You earned " + casinoGold + " gold on " + today);				
			}
			else {
				redirectAttributes.addFlashAttribute("lost", "You lost " + casinoGold + " gold on " + today);
			}
		}
		session.setAttribute("gold", gold);
		
		return "redirect:/";
	}
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
