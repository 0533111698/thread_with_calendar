package collection.pokemon.nir;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] names = {"Charmander", "Pikachu", "Gengar", "Lucario", "Gardevoir", "Eevee", "Bulbasaur"};
        List<Pokemon> pokemons = new ArrayList<>();
        while(pokemons.size() < 10){
            try {
                pokemons.add(new Pokemon(names[random.nextInt(names.length)],
                        PokemonType.values()[random.nextInt(PokemonType.values().length)],
                        random.nextInt(30), random.nextInt(30)));
            } catch (PokemonException e) {
                System.out.println(e.getMessage() + ", trying to create a new Pokemon.");
            }
        }

        int myX = random.nextInt(21);
        int myY = random.nextInt(21);

        System.out.println("My x = " + myX);
        System.out.println("My y = " + myY);
        System.out.println(pokemons);

        //***************************************************
        Thread pokeThread = new Thread(new PokemonChecker(pokemons, myX, myY));
        pokeThread.start();
        Thread pokeThread2 = new Thread(new PokemonMover(pokemons));
        pokeThread2.start();

    }
}
