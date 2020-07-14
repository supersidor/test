package com.test.springmvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShapesController{
	Stats stats;
	private static double PI = 3.14;

	@Value( "${storeFileName}" )
	private String storeFileName;

	@PostConstruct
	public void init() {
		stats = loadStats(storeFileName);
	}	

	@GetMapping({"/shapes"})
	public String shapes(Model model) {
		model.addAttribute("stats", stats);
		return "shapes";
	}
	
	//circle
	@GetMapping({"/circle"})
	public String circle(Model model) {
		return "circle";
	}
	@GetMapping({"/calc_circle"})
	public String calc_circle(Model model,@RequestParam(value="diameter", required=true) Double diameter) {
		double area = PI*Math.pow(diameter/2,2);
		model.addAttribute("title", String.format("Area of circle is %.2f",area));
		stats.incrementCircle();
		saveStats(stats);		
		return "result";
	}
	//square
	@GetMapping({"/square"})
	public String square(Model model) {
		return "square";
	}
	@GetMapping({"/calc_square"})
	public String calc_square(Model model,@RequestParam(value="side", required=true) Double side) {
		double area = Math.pow(side,2);
		model.addAttribute("title", String.format("Area of circle is %.2f",area));
		stats.incrementSquare();
		saveStats(stats);		
		return "result";
	}	
	// rectangle

	@GetMapping({"/rectangle"})
	public String rectangle(Model model) {
		return "rectangle";
	}
	@GetMapping({"/calc_rectangle"})
	public String calc_rectangle(Model model,@RequestParam(value="height", required=true) Double height,@RequestParam(value="width", required=true) Double width) {
		double area = width*height;
		model.addAttribute("title", String.format("Area of rectangle is %.2f",area));
		stats.incrementRectangle();
		saveStats(stats);		
		return "result";
	}		
	// ellipse

	@GetMapping({"/ellipse"})
	public String ellipse(Model model) {
		return "ellipse";
	}
	@GetMapping({"/calc_ellipse"})
	public String calc_ellipse(Model model,@RequestParam(value="da", required=true) Double da,@RequestParam(value="db", required=true) Double db) {
		double area =  PI*(da/2)*(db/2);
		model.addAttribute("title", String.format("Area of ellipse is %.2f",area));
		stats.incrementEllipse();
		saveStats(stats);		
		return "result";
	}	

	private Stats loadStats(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			stats = new Stats();
			return stats;
		}

		Stats stats = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			stats = (Stats) ois.readObject();
		} catch (Exception ex) {
			stats = new Stats();
			ex.printStackTrace();
		}
		return stats;
	}    

	private synchronized void saveStats(Stats stats) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeFileName))) {
			oos.writeObject(stats);
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

}
