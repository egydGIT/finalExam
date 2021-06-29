package hu.nive.ujratervezes.forest;

public class WhitebarkPine extends Tree {

    public WhitebarkPine() {
    }

    public WhitebarkPine(int height) {
        super(height);
    }

    @Override
    void irrigate() {
        increase2();
    }

    @Override
    String getName() {
        return "WhitebarkPine";
    }

}
