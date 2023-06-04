package collection.pokemon;

import java.util.List;

public class PokemonThread extends Thread{
    private List<Pokemon>pokemons;
    private int myPlaceX, myPlaceY;

    public PokemonThread(List<Pokemon> pokemons, int myPlaceX, int myPlaceY) {
        this.pokemons = pokemons;
        this.myPlaceX = myPlaceX;
        this.myPlaceY = myPlaceY;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getMyPlaceX() {
        return myPlaceX;
    }

    public void setMyPlaceX(int myPlaceX) {
        this.myPlaceX = myPlaceX;
    }

    public int getMyPlaceY() {
        return myPlaceY;
    }

    public void setMyPlaceY(int myPlaceY) {
        this.myPlaceY = myPlaceY;
    }

    @Override
    public String toString() {
        return "PokemonThread{" +
                "pokemons=" + pokemons +
                ", myPlaceX=" + myPlaceX +
                ", myPlaceY=" + myPlaceY +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            for (Pokemon pokemon:pokemons) {
                if (pokemon.getX() >= myPlaceX-1 && pokemon.getX() <= myPlaceX+1&&
                        pokemon.getY()>= myPlaceY -1 && pokemon.getY() <= myPlaceY+1){
                    System.out.println("The pokemon 'pikaku' is near you!!!!" + "The picaku" + pokemon.getName() + " " + pokemon.getX() + " " + pokemon.getY()
                            + "you" + getMyPlaceX() + " " + getMyPlaceY());
                }
            }
            try {
                Thread.sleep(1000*4);
            } catch (InterruptedException e) {
            }
        }

    }
}



