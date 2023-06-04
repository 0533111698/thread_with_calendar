package collection.pokemon;

public class Pokemon {
    private String name;
    private Type type;
    private int x,y;

    public Pokemon(String name, Type type, int x, int y) throws PokemonException {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws PokemonException{
        if (x<=20&&x>=0)
        this.x = x;
        else throw new PokemonException("Invalid x enter between 0-20");
    }

    public int getY() {
        return y;
    }

    public void setY(int y)throws PokemonException {
        if (y<=20&&y>=0)
        this.y = y;
        else throw new PokemonException("Invalid y enter between 0-20");
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }public void mover(int moveX,int moveY){
        this.x+=moveX;
        this.y+=moveY;
    }
}
