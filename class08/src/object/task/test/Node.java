package object.task.test;

import java.util.List;
import java.util.Map;

public class Node {
    String  context;
    int pid;
    int id;
    List<Node> children;

    //自定义用户属性
    private Map<String, Object> attributes;



    public Node(String context, int pid, int id) {
        this.context = context;
        this.pid = pid;
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Node{" +
                "context='" + context + '\'' +
                ", pid=" + pid +
                ", id=" + id +
                ", children=" + children +
                ", attributes=" + attributes +
                '}';
    }
}
