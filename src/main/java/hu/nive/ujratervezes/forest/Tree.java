package hu.nive.ujratervezes.forest;

public abstract class Tree {

    private int height;

    public Tree() {
        this.height = 0;
    }

    public Tree(int height) {
        this.height = height;
    }

    public abstract void irrigate();

    public abstract String getName();

    public int increase1() {
        return this.height++;
    }

    public int increase2() {
        return this.height += 2;
    }

    public int getHeight() {
        return height;
    }
}
