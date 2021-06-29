package hu.nive.ujratervezes.forest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Forest {

    private Lumberjack lumberjack;

    private List<Tree> trees;

    public Forest() {                                                       // konstruktor overload
    }

    public Forest(List<Tree> trees) {
        this.trees = trees;
    }

    public Forest(Lumberjack lumberjack, List<Tree> trees) {
        this.lumberjack = lumberjack;
        this.trees = trees;
    }

    public void rain() {
        for (Tree tree: trees) {
            tree.irrigate();
        }
    }

//    public void cutTrees(Lumberjack lumberjack) {
//        for (Tree tree: trees) {
//            if (lumberjack.canCut(tree)) {
//                trees.remove(tree);         // iterator
//            }
//        }
//    }

    public void cutTrees(Lumberjack lumberjack) {
        for (Iterator<Tree> i = trees.iterator(); i.hasNext();) {
            Tree tree = i.next();
            if (lumberjack.canCut(tree)) {
                i.remove();
            }
        }
    }

    public boolean isEmpty() {
        return trees.isEmpty() || trees == null;
    }

//    public String getStatus() {
//        StringBuilder sb = new StringBuilder();
//        String s = "[ \n";
//        for (Tree tree: trees) {
//            s = String.format("There is a %d tall %s in the forest.", tree.getHeight(), tree.getName());
//            sb.append(s);
//        }
//        sb.append("\n ]");
//        return sb.toString();
//    }

    public List<String> getStatus() {
        List<String> treesStatus = new ArrayList<>();
        for (Tree tree: trees) {
            treesStatus.add(String.format("There is a %d tall %s in the forest.", tree.getHeight(), tree.getName()));
        }

        return treesStatus;
    }

    public Lumberjack getLumberjack() {
        return lumberjack;
    }

    public List<Tree> getTrees() {
        return trees;
    }
}
