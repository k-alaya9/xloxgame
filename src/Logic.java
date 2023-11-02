import java.util.*;


public class Logic {

    public void UserPlay(State state) {

        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter the X and the Y to move your block:");
            int x = input.nextInt();
            int y = input.nextInt();
            state.move(x, y);
        } while (!State.isFinal(state.getArrayOfBlocks()));
    }

    public void BFS(State state) {
        Graph graph = new Graph();
        Set<State> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        Map<State, State> path = new HashMap<>();
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()) {
            State node = queue.poll();
            if (State.isFinal(node.getArrayOfBlocks())) {
                System.out.println("Graph Size:" + graph.getGraphSize());
                System.out.println("Number of visited node:" + visited.size());
                printPath(path, node);
                break;
            }
            node.getNextState(graph);
            for (Edge e : graph.GetNode(node)) {
                if (!visited.contains(e.dist)) {
                    visited.add(e.dist);
                    queue.add(e.dist);
                    path.put(e.dist, node);
                }
            }
        }
    }

    public void DFS(State state){
        Graph graph= new Graph();
        Stack<State> stack=new Stack<>();
        Set<State> visited= new HashSet<>();
        Map<State,State>path=new HashMap<>();
        stack.push(state);
        while(!stack.isEmpty()){
            State node=stack.pop();
            if(State.isFinal(node.getArrayOfBlocks())){
                System.out.println("Graph Size:"+graph.getGraphSize());
                System.out.println("Number of Visited node:"+visited.size());
                printPath(path,node);
                break;
            }
            if(!visited.contains(node)){
                visited.add(node);
                node.getNextState(graph);
            }
            for (Edge e:graph.GetNode(node)) {
                if(!visited.contains(e.dist)){
                    stack.push(e.dist);
                    path.put(e.dist,node);
                }
            }
        }
    }

        private void printPath (Map < State, State > path, State node){
            List<State> p = new ArrayList<>();
            State currentState = node;
            while (currentState != null) {
                p.add(currentState);
                currentState = path.get(currentState);
            }
            for (int i = p.size() - 1; i >= 0; i--) {
                p.get(i).printState();
                System.out.println();
            }
        }
    }

