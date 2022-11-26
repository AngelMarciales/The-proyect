package Structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class SearchBinaryTree<T> implements Iterable<T> {

    private Node<T> root;
    private Comparator<T> comparator;
    private boolean exist = false;

    public SearchBinaryTree(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
    }

    public void insert(T value) {
        if (isEmpty()) {
            root = new Node<T>(value, null, null);
        } else {
            auxInsert(value, root);
        }
    }

    private void auxInsert(T value, Node<T> aux) {
        if (comparator.compare(aux.getValue(), value) > 0) {
            if (aux.getLeft() != null) {
                auxInsert(value, aux.getLeft());
            } else {
                aux.setLeft(new Node<T>(value, null, null));
            }
        } else if (comparator.compare(aux.getValue(), value) < 0) {
            if (aux.getRight() != null) {
                auxInsert(value, aux.getRight());
            } else {
                aux.setRight(new Node<T>(value, null, null));
            }
        }
    }

    public boolean exist(T value) {
        if (isEmpty()) {
            return false;
        } else {
            return auxExist(value, root);
        }
    }

    private boolean auxExist(T value, Node<T> aux) {
        if (comparator.compare(aux.getValue(), value) == 0) {
            exist = true;
        } else {
            if (comparator.compare(aux.getValue(), value) > 0) {
                if (comparator.compare(aux.getLeft().getValue(), value) == 0) {
                    exist = true;
                } else if (aux.getLeft() != null && !exist) {
                    auxExist(value, aux.getLeft());
                }
            } else if (comparator.compare(aux.getValue(), value) < 0) {
                if (comparator.compare(aux.getRight().getValue(), value) == 0) {
                    exist = true;
                } else if (aux.getRight() != null && !exist) {
                    auxExist(value, aux.getRight());
                }
            }
        }
        return exist;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public ArrayList<T> inOrder() {
        ArrayList<T> orderList = new ArrayList<T>();
        if (root != null) {
            auxInOrder(root, orderList);
        }
        return orderList;
    }

    private ArrayList<T> auxInOrder(Node<T> root, ArrayList<T> orderlist) {
        if (root.getLeft() != null) {
            auxInOrder(root.getLeft(), orderlist);
        }
        if (root.getRight() != null) {
            auxInOrder(root.getRight(), orderlist);
        }
        orderlist.add(root.getValue());
        return orderlist;
    }

    public T search(T value) {
        if (isEmpty()) {
            return null;
        } else {
            return auxSearch(value, root);
        }
    }

    private T auxSearch(T value, Node<T> aux) {
        T nodeValue = null;
        if (comparator.compare(aux.getValue(), value) == 0) {
            nodeValue = aux.getValue();
        } else {
            if (comparator.compare(aux.getValue(), value) > 0) {
                if (comparator.compare(aux.getLeft().getValue(), value) == 0) {
                    nodeValue = aux.getLeft().getValue();
                } else if (aux.getLeft() != null) {
                    auxExist(value, aux.getLeft());
                }
            } else if (comparator.compare(aux.getValue(), value) < 0) {
                if (comparator.compare(aux.getRight().getValue(), value) == 0) {
                    nodeValue = aux.getRight().getValue();
                } else if (aux.getRight() != null) {
                    auxExist(value, aux.getRight());
                }
            }
        }
        return nodeValue;
    }

    public void delete(T value) {
        if (isEmpty()) {
            return;
        } else {
            deleteAux(value, root);
        }
    }

    private Node<T> deleteAux(T value, Node<T> root) {
        if (root == null)
            return null;
        else if (comparator.compare(root.getValue(), value) < 0) {
            Node<T> aux = deleteAux(value, root.getRight());
            root.setRight(aux);
        } else if (comparator.compare(root.getValue(), value) > 0) {
            Node<T> aux = deleteAux(value, root.getLeft());
            root.setLeft(aux);
        } else {
            Node<T> aux = root;
            if (aux.getLeft() == null)
                root = aux.getRight();
            else if (aux.getRight() == null)
                root = aux.getLeft();
            else
                aux = deleteWith2Childs(aux);
            aux = null;
        }

        return root;
    }

    private Node<T> deleteWith2Childs(Node<T> root) {
        Node<T> aux1, aux2;
        aux1 = root;
        aux2 = root.getLeft();
        while (aux2.getRight() != null) {
            aux1 = aux2;
            aux2 = aux2.getRight();
        }
        root.setValue(aux2.getValue());
        if (aux1 == root)
            aux1.setLeft(aux2.getLeft());
        else
            aux1.setRight(aux2.getLeft());
        return aux2;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
