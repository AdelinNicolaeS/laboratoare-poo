package second;

import first.Task;

import java.util.ArrayList;

public class Stack implements Container {
    ArrayList<Task> list = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return list;
    }

    public void setTasks(ArrayList<Task> list) {
        this.list = list;
    }

    public Task pop() {
        if(list.isEmpty()) {
            return null;
        }
        Task returned = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return returned;
    }

    @Override
    public void push(Task task) {
        list.add(task);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void transferFrom(Container container) {
        while(container.size() != 0) {
            list.add(container.pop());
        }
    }
}
