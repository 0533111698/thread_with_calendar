package collection.pokemon.nir;

import java.util.List;

public class PokemonChecker implements Runnable {

    private List<Pokemon> pokemons;
    private int playerX, playerY;

    public PokemonChecker(List<Pokemon> pokemons, int playerX, int playerY) {
        this.pokemons = pokemons;
        this.playerX = playerX;
        this.playerY = playerY;
    }

    @Override
    public void run() {
        while(true){

            for(Pokemon poke : pokemons){
                if(poke.getX() >= playerX - 1 && poke.getX() <= playerX + 1
                        && poke.getY() >= playerY - 1 && poke.getY() <= playerY + 1){
                    System.out.println(poke.getName() + " is nearby! (" + poke.getX() + ", " + poke.getY() + ")");
                }
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {}
        }
    }
}
