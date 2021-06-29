package hu.nive.ujratervezes.forest;

public class Lumberjack{

    private Tree tree;                      // has-a kapcsolat, kompozíció

    public Lumberjack() {
    }

    public boolean canCut(Tree tree) {
        if (tree.getHeight() > 4) {
            return true;
        }
        else return false;
    }

}
