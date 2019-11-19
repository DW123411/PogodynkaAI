package src;

import java.util.LinkedList;

public class Drzewo<T> {
    private Wezel<T> korzen;

    public Drzewo() {
        korzen = null;
    }

    public Drzewo(Wezel<T> korzen) {
        this.korzen = korzen;
    }

    public Wezel<T> getKorzen() {
        return korzen;
    }

    public void preOrder(Wezel<T> n) {
        System.out.print(n + " ");
        Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
        while (temp != null) {
            preOrder(temp);
            temp = temp.getPraweRodzenstwo();
        }
    }

    public void inOrder(Wezel<T> n) {
        if (n.czyLisc()) {
            System.out.print(n + " ");
        } else {
            Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
            inOrder(temp);
            System.out.print(n + " ");
            while (temp != null) {
                inOrder(temp);
                temp = temp.getPraweRodzenstwo();
            }
        }
    }

    public void postOrder(Wezel<T> n) {
        Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
        while (temp != null) {
            postOrder(temp);
            temp = temp.getPraweRodzenstwo();
        }
        System.out.print(n + " ");
    }

    public int getLevel(Wezel<T> n) {
        if (n == korzen) return 0;
        else return 1 + getLevel(n.getRodzic());
    }

    public int getHeight(Wezel root) {
        if (root == null) return 0;
        int h = 0;
        if (!root.czyLisc()) {

            LinkedList<Wezel> lista = new LinkedList<Wezel>();
            for (int i = 0; i < root.getDzieci().size(); i++) {
                lista.add((Wezel) root.getDzieci().get(i));
            }

            while (!lista.isEmpty()) {

                Wezel w = lista.remove(0);
                h = Math.max(h, getHeight(w));

            }
        }
        return h + 1;
    }

    public LinkedList<Wezel<ElementDrzewa>> preOrderToList(Wezel<T> n, LinkedList<Wezel<ElementDrzewa>> list) {
        list.add((Wezel<ElementDrzewa>) n);
        Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
        while (temp != null) {
            preOrderToList(temp, list);
            temp = temp.getPraweRodzenstwo();
        }
        return list;
    }

}
