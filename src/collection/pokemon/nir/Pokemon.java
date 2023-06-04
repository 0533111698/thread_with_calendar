package collection.pokemon.nir;

public class Pokemon {
    private String name;
    private PokemonType type;
    private int x, y;

    public Pokemon(String name, PokemonType type, int x, int y) throws PokemonException {
        this.name = name;
        this.type = type;
        setX(x);
        setY(y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws PokemonException {
        if(x >= 0 && x <=20)
            this.x = x;
        else
            throw new PokemonException("Invalid x position");
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws PokemonException {
        if(y >= 0 && y <=20)
            this.y = y;
        else
            throw new PokemonException("Invalid y position");
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "\n{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
