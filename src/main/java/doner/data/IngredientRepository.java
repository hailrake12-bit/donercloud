package doner.data;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import doner.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
