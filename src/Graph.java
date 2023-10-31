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
        vertices.put(node,new ArrayList<>());
    }

    public void addEdges(State sourceNode,State distNode){
        if(!GetNode(sourceNode).contains(new Edge(distNode))) {
            GetNode(sourceNode).add(new Edge(distNode));
        }
    }


}
