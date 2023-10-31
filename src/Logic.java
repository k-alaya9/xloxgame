import java.util.*;


public class Logic {

    public void UserPlay(State state){

        Scanner input=new Scanner(System.in);
        do {
            System.out.print("Enter the X and the Y to move your block:");
            int x=input.nextInt();
            int y=input.nextInt();
            state.move(x,y);
        }while(!state.isFinal());
    }

    public void BFS(State state){
        Graph graph= new Graph();
        Set<State> visited= new HashSet<>();
        Queue<State> queue= new LinkedList<>();
        graph.addNode(state);
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()){
            State node=queue.poll();
            if(node.isFinal()){
                break;
            }
            else {
                node.getNextState(graph);
                for (Edge neighbor:graph.GetNode(node)){
                    if(!visited.contains(neighbor.dist)){
                        visited.add(neighbor.dist);
                        queue.add(neighbor.dist);
                    }
                }
            }
        }
    }



    public  void DFS(State state){
        Graph graph= new Graph();
        Set<State> visited= new HashSet<>();
        DFS(state,visited,graph);
    }

    private void DFS(State state,Set<State> visited,Graph graph){
        graph.addNode(state);
        visited.add(state);
        if(state.isFinal()){
            return;
        }
        state.getNextState(graph);
        for (Edge e:graph.GetNode(state)){
            if(!visited.contains(e.dist)){
              DFS(e.dist,visited,graph);
            }
        }
    }
}


