import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<State,List<Edge>> vertices;

    public Graph() {
        this.vertices=new HashMap<>();
    }


    public Map<State, List<Edge>> getVertices() {
        return vertices;
    }

    public void setVertices(Map<State, List<Edge>> vertices) {
        this.vertices = vertices;
    }

    public List<Edge>GetNode(State node){
        return vertices.get(node);
    }
    public void addNode(State node){
        if(!vertices.containsKey(node)) {
            vertices.put(node,new ArrayList<>());
        }
    }

    public int getGraphSize(){
        return vertices.size();
    }
    public void addEdges(State sourceNode,State distNode){
        if(!vertices.containsKey(sourceNode)||!vertices.containsKey(distNode)) {
            return;
        }
       vertices.get(sourceNode).add(new Edge(distNode));
    }

}
