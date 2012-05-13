package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;

public class LinkedList extends Struct {

    private LinkedListNode start;
    private int tamanho = 0;

    public LinkedList() {
        super(IGEDConst.LISTA);
    }

    public void setStart(LinkedListNode start) {
        this.start = start;
    }

    public LinkedListNode getStart() {
        return this.start;
    }

    @Override
    public boolean compare(Struct lk) {
        if(!(lk instanceof LinkedList))
            return false;
        if (lk.getType() == IGEDConst.LISTA) {
            LinkedList l = ((LinkedList) lk);
            
            if(this.tamanho != l.tamanho)
                return false;
            
            LinkedListNode thisNode = this.start;
            LinkedListNode lkNode = l.getStart();
            while (thisNode != null && lkNode != null) {
                if (!thisNode.compare(lkNode)) {
                    return false;
                }
                thisNode = thisNode.next();
                lkNode = lkNode.next();
            }
            if(thisNode == null && lkNode == null)
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public Node readField(int field) {

        switch (field) {

            case IGEDConst.LISTA_INICIO:
                return this.start;
            default:
                break;

        }
        return null;
    }

    @Override
    public void writeField(Struct n, int field) {
        switch (field) {
            case IGEDConst.LISTA_INICIO:
                this.start = (LinkedListNode) n;
                break;


            default:
                break;

        }

    }

    @Override
    public void writeInfo(int value) {
        this.tamanho = value;
    }

    @Override
    public int readInfo() {
        return this.tamanho;
    }
}
