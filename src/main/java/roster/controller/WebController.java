package roster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import roster.beans.Player;
import roster.repository.PlayerRepository;

@Controller
public class WebController {
	@Autowired
	PlayerRepository repo;

	@GetMapping("/viewAll")
	public String viewAllPlayers(Model model) {
		model.addAttribute("players", repo.findAll());
		return "results";
	}
	@GetMapping("/inputPlayer")
		public String addNewPlayer(Model model) {
		Player c = new Player();
		model.addAttribute("newPlayer", c);
		return "input";
	}
	@PostMapping("/inputPlayer")
	public String addNewPlayer(@ModelAttribute Player c, Model model) {
		repo.save(c);
		model.addAttribute("players", repo.findAll());
		return "results";
	}
	
	@GetMapping("/edit/{id}")

	public String showUpdateForm(@PathVariable("id") long id, Model model) {

	    Player c = repo.findById((long) id)

	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

	    model.addAttribute("player", c);

	    return "update";

	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id")long id, @Valid Player c, BindingResult result, Model model) {
		if(result.hasErrors()) {
			c.setId(id);
			return "update";	
		}
		repo.save(c);
		model.addAttribute("players", repo.findAll());
		return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Player c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		repo.delete(c);
		model.addAttribute("players", repo.findAll());
		return "results";
	}
}
