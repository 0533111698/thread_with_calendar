package collection.pokemon.nir;

import java.util.List;
import java.util.Random;

public class PokemonMover implements Runnable {

    private List<Pokemon> pokemons;

    public PokemonMover(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true){

            for(Pokemon poke: pokemons){
                poke.move(random.nextInt(4), random.nextInt(4));
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}
