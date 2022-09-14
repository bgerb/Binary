
public class node {
    private node parent;
    private node lchild;
    private node rchild;
    private int data;

    public node(int dataa) {
        data = dataa;
    }

    public int getData() {
        return data;
    }

    public void setKey(int _key) {
        data = _key;
    }

    public void setParent(node _parent) {
        parent = _parent;
    }

    public void setLChild(node _lchild) {
        lchild = _lchild;
    }

    public void setRChild(node _rchild) {
        rchild = _rchild;
    }

    public node getLChild() {
        return lchild;
    }

    public node getRChild() {
        return rchild;
    }

    public node getParent() {
        return parent;
    }

    public node minimum() {
        node test = this;
        while(test.getLChild() !=  null) {
            test = test.getLChild();
        }
        return test;
    }

    public node successor() {
        node test = this;
        if(test.getRChild() !=  null) {
            return test.getRChild().minimum();
        }
        node par = test.getParent();
        while(par != null && test == par.getRChild()){
            test = par;
            par = test.getParent();
        }
        return test;
    }

    public int childcount() {
        int num = 0;
        if(lchild != null) num++;
        if(rchild != null) num++;
        return num;

    }

    public String toString() {
        return "data" + data + " children: " + childcount() +   " and reference " + super.toString();
    }
    public String stringWalk() {
        String strr = "";
        if(lchild != null) strr += lchild.stringWalk();
        strr += " " + data + "\n";
        if(rchild != null) strr += rchild.stringWalk();
        return strr;

    }


}