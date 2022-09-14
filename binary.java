 public class binary {

    private node root;

    public node getRoot() {
        return root;
    }

    public void setRoot(node _root) {
        root = _root;
    }

    public void insert(node newNode) {
        if (newNode == null) return;
        node newParent = findInsertionNode(newNode.getData());
        if (newParent == null) root = newNode;
        else {
            newNode.setParent(newParent);
            if (newParent.getData() > newNode.getData()) newParent.setLChild(newNode);
            else newParent.setRChild(newNode);
        }
    }

    public node findInsertionNode(int data) {
        node test = null;
        node x = root;
        while (x != null) {
            test = x;
            if (data < x.getData()) x = x.getLChild();
            else x = x.getRChild();
        }
        return test;
    }

    public node search(node x, int data) {
        if (x != null && x.getData() != data) {
            if (data < x.getData())
                return search(x.getLChild(), data);
            else {
                return search(x.getRChild(), data);
            }
        }

        return x;

    }


    public boolean childless(node a) {
        if (a == null) return true;
        return a.getLChild() == null && a.getRChild() == null;
    }

    public boolean onechild(node a) {
        return (!childless(a)) && (a.getLChild() == null || a.getRChild() == null);
    }

    public void scrubParent(node a) {
        if (a == null) return;
        node par = a.getParent();
        if (par == null) root = null;
        else {
            if (a == par.getRChild()) par.setRChild(null);
            else par.setLChild(null);
        }
    }


    public void spliceOut(node a) {
        node child = a.getLChild();
        node par = a.getParent();
        if (child == null) child = a.getRChild();
        if (child != null) child.setParent(par);
        if (par == null) root = child;
        else {
            if (a == par.getRChild()) par.setRChild(child);
            else par.setLChild(child);
        }
    }

    public void rotateOut(node a) {
        if (a == null) return;
        node suc = a.successor();
        spliceOut(suc);
        a.setKey(suc.getData());

    }
    public void delete(node a) {
        if(childless(a)) {
            scrubParent(a);
            return;
        }
        if(onechild(a)) spliceOut(a);
        else {
            rotateOut(a);
        }
    }

    public String toString() {
        if(root != null) return root.toString();
        return "Empty tree";
    }
}