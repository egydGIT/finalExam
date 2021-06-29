package hu.nive.ujratervezes.forest;

public class FoxtailPine extends Tree {

    public FoxtailPine() {
    }

    public FoxtailPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        increase1();            // feladatkiírás és a teszteset szerintem itt eltér
    }

    @Override
    public String getName() {
        return "FoxtailPine";
    }

}
