public class Drzewo<T> {
    private Wezel<T> korzen;

    public Drzewo(){
        korzen = null;
    }

    public Drzewo(Wezel<T> korzen){
        this.korzen = korzen;
    }

    public Wezel<T> getKorzen(){
        return korzen;
    }

    public void preOrder(Wezel<T> n){
        System.out.print(n+" ");
        Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
        while(temp!=null){
            preOrder(temp);
            temp = temp.getPraweRodzenstwo();
        }
    }

    public void inOrder(Wezel<T> n){
        if(n.czyLisc()){
            System.out.print(n+" ");
        }else{
            Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
            inOrder(temp);
            System.out.print(n+" ");
            while(temp!=null){
                inOrder(temp);
                temp = temp.getPraweRodzenstwo();
            }
        }
    }

    public void postOrder(Wezel<T> n){
        Wezel<T> temp = n.getPierwszeDzieckoPoLewej();
        while(temp!=null){
            postOrder(temp);
            temp = temp.getPraweRodzenstwo();
        }
        System.out.print(n+" ");
    }

    public int getLevel(Wezel<T> n) {
        if (n == korzen) return 0;
        else return 1 + getLevel(n.getRodzic());
    }
}
