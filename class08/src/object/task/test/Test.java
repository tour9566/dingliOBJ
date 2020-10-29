package object.task.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        mothed();
        //ctrl+alt+space
        System.out.println();
//        System.out.println();
        //ctrl+d 复制当前行
        System.out.println();

        //ctrl+y 删除当前行
        System.out.println();
        getTree1();


    }

    private static void getTree1() {
        ArrayList<Node> allNodes = new ArrayList<>();
        allNodes.add(new Node("湖北师范大学", 0, 1));
        allNodes.add(new Node("计算机与信息学院", 1, 2));
        allNodes.add(new Node("1808班", 2, 3));
        allNodes.add(new Node("1809班", 2, 4));
        allNodes.add(new Node("1810班", 2, 5));
        allNodes.add(new Node("1811班", 2, 6));

        ArrayList<Node> rootNodes = new ArrayList<>();
        for (int i = 0; i < allNodes.size(); i++) {
            Node node = allNodes.get(i);
            Map<String, Object> mp = new HashMap<String, Object>();
            int id = node.getId();
            switch (id) {
                case 1: {
                    mp.put("level", "college");
                    break;
                }
                case 2: {
                    mp.put("level", "department");
                    break;
                }
                case 3: {
                    mp.put("level", "classes");
                    mp.put("classes", "1808");
                    if (node.getContext().equals("1808班")) {
                        mp.put("total", 64);
                    }
                    break;
                }
                case 4: {
                    mp.put("level", "classes");
                    mp.put("classes", "1809");
                    if (node.getContext().equals("1809班")) {
                        mp.put("total", 51);
                    }
                    break;
                }
                case 5: {
                    mp.put("level", "classes");
                    mp.put("classes", "1810");
                    if (node.getContext().equals("1810班")) {
                        mp.put("total", 51);
                    }

                    break;
                }
                case 6: {
                    mp.put("level", "classes");
                    mp.put("classes", "1811");
                    if (node.getContext().equals("1811班")) {
                        mp.put("total", 51);
                    }
                    break;
                }
            }
            node.setAttributes(mp);
            if (node.getPid() == 0) {
                rootNodes.add(node);
            }
        }

        for (int i = 0; i < rootNodes.size(); i++) {
            Node node = rootNodes.get(i);
            node.setChildren(getChild(node, allNodes));
            System.out.println(node);
        }

        for (int i = 0; i < rootNodes.size(); i++) {
            Node node = rootNodes.get(i);
            List<Node> child = getChild(node, allNodes);
            System.out.println("tree1===" + child);
        }
    }

    private static List<Node> getChild(Node rootNode, ArrayList<Node> allNodes) {
        List<Node> childList = new ArrayList<Node>();
        for (int i = 0; i < allNodes.size(); i++) {
            Node node = allNodes.get(i);
            if (node.getPid() == rootNode.getId()) {
                childList.add(node);
                rootNode.setChildren(getChild(node, allNodes));
            }
        }
        return childList;
    }

    private static List<Node> getChild1(Node rootNode, ArrayList<Node> allNodes) {
        List<Node> childList = new ArrayList<Node>();
        for (int i = 0; i < allNodes.size(); i++) {
            Node node = allNodes.get(i);
            if (rootNode.getId() == node.getPid()) {
                childList.add(node);
            }
        }
        for (int i = 0; i < childList.size(); i++) {
            Node node = childList.get(i);
            node.setChildren(getChild(node, allNodes));
        }
        if (childList.size() == 0) {
            return new ArrayList<Node>();
        }
        return childList;
    }


    //ctrl+alt+m
    private static void mothed() {
    }

    //


}
