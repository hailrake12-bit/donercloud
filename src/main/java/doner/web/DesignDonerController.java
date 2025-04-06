package doner.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import doner.Doner;
import doner.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;
import doner.Ingredient;
import doner.Ingredient.Type;
import doner.DonerOrder;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("donerOrder")
public class DesignDonerController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignDonerController(
            IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "donerOrder")
    public DonerOrder order () {
        return new DonerOrder();
    }
    @ModelAttribute(name = "doner")
    public Doner doner() {
        return new Doner();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processDoner(@Valid Doner doner, Errors errors,
                              @ModelAttribute DonerOrder donerOrder) {

        if(errors.hasErrors()) return "design";

        donerOrder.addDoner(doner);
        log.info("Заказ обрабатывается: {}", doner);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> supplements, Type type) {
        return StreamSupport.stream(supplements.spliterator(), false)
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}

