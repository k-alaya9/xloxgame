import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<State,List<State>> graph;

    public Graph() {
        this.graph=new HashMap<>();
    }


    public Map<State, List<State>> getgraph() {
        return graph;
    }

    public void setgraph(Map<State, List<State>> graph) {
        this.graph = graph;
    }

    public List<State>GetNode(State node){
        return graph.get(node);
    }
    public void addNode(State node){
        graph.put(node,new ArrayList<>());
    }

    public int getGraphSize(){
        return graph.size();
    }
    public void addEdges(State sourceNode,State distNode){
        if(!graph.containsKey(sourceNode)||!graph.containsKey(distNode))
            return;
        graph.get(sourceNode).add(distNode);
    }

}
