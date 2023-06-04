package collection.pokemon;

import java.util.List;
import java.util.Vector;

public class ProgramPokemon {
    public static void main(String[] args)throws InterruptedException{
        List<Pokemon>pokemons=new Vector<Pokemon>();
        for (int i = 0; i <10; i++) {
            try {
                pokemons.add(new Pokemon("Pokemon"+(i+1),Type.values()[(int) (Math.random()*Type.values().length)],
                        (int) (Math.random()*21),(int) (Math.random()*21)));
            } catch (PokemonException e) {
                System.out.println(e.getMessage()+"Trying to create new pokemon");
            }

        }
        int myPlaceX=(int) (Math.random()*21);
        int myPlaceY=(int) (Math.random()*21);
        System.out.println(myPlaceX);
        System.out.println(myPlaceY);
        PokemonThread pt=new PokemonThread(pokemons,myPlaceX,myPlaceY);
        pt.start();
        MoverPokemon mp=new MoverPokemon(pokemons);
        mp.start();
        System.out.println(pokemons);



    }
}
