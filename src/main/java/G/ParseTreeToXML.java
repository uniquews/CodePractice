package G;

import utils.MultiTreeNode;

import java.util.Stack;

public class ParseTreeToXML {
    public String parse(MultiTreeNode root) {
        if (root == null) {
            return "";
        }

        if (root.children.isEmpty()) {
            return "<" + root.val + "/>";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<" + root.val + ">");
        for (int i = 0; i < root.children.size(); i++) {
            sb.append(parse(root.children.get(i)));
        }
        sb.append("</" + root.val + ">");
        return sb.toString();
    }


    public static void main(String[] args) {
        ParseTreeToXML test = new ParseTreeToXML();
        MultiTreeNode a = new MultiTreeNode(1);
        MultiTreeNode b = new MultiTreeNode(2);
        MultiTreeNode c = new MultiTreeNode(3);
        MultiTreeNode d = new MultiTreeNode(4);
        MultiTreeNode e = new MultiTreeNode(5);
        MultiTreeNode f = new MultiTreeNode(6);
        MultiTreeNode g = new MultiTreeNode(7);
        MultiTreeNode h = new MultiTreeNode(8);

        a.children.add(b);
        a.children.add(c);
        a.children.add(d);

        b.children.add(e);
        b.children.add(f);

        c.children.add(g);
        g.children.add(h);
        System.out.print(test.parse(a));
    }
}
