package doner.data;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import doner.Ingredient;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
