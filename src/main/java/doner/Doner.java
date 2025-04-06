package doner;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
@Entity
public class Doner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Имя должно состоять хотя бы из 5 символов")
    private String name;

    @NotNull(message = "Необходимо выбрать лаваш")
    @ManyToOne
    private Ingredient wrap;

    @NotNull(message = "Необходимо выбрать мясо")
    @ManyToOne
    private Ingredient meat;

    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}