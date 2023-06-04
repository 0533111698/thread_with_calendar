package collection.pokemon;

import java.util.List;

public class MoverPokemon extends Thread {
    List<Pokemon>pokemons;

    public MoverPokemon(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "MoverPokemon{" +
                "pokemons=" + pokemons +
                '}';
    }

    @Override
    public void run() {
       while (true){
           for (Pokemon p:pokemons) {
              p.mover((int) (Math.random()*9)-4,(int) (Math.random()*9)-4);
           }
           try {
               Thread.sleep(1000*2);
           } catch (InterruptedException e) {
           }
       }
    }
}
