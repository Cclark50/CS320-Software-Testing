/*
 **@Author Christian Clark
 **@Date 5/28/25
 **This is the task service that drives an arraylist of tasks
 */
package tasks;

import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> tasks;
    private int currID = 0;

    public TaskService() {
        tasks = new ArrayList<Task>();
    }

    //returns and updates to the next ID so we can have a sequential unique ID
    private int GetNextID() {
        return currID++;
    }

    public int GetTaskCount() {
        return tasks.size();
    }

    public void AddTask(String name, String description) {
        Task task = new Task(String.valueOf(GetNextID()), name, description);
        tasks.add(task);
    }

    //deletes a task given an ID
    public void DeleteTask(String ID) {
        int index = IndexOf(ID);
        if (index == -1) {
            throw new IllegalArgumentException("Task not found");
        }

        tasks.remove(index);
    }

    //using my At function from the previous assignment since it worked perfectly for that
    //gets the index of the task with the given ID
    public Task At(String ID) {
        int index = IndexOf(ID);

        if (index == -1) {
            throw new IllegalArgumentException("Task not found");
        }

        return tasks.get(index);
    }

    //updates a task when given the ID and the new name and description
    public void UpdateTask(String ID, String name, String description) {
        int index = IndexOf(ID);
        if (index == -1) {
            throw new IllegalArgumentException("Task not found");
        }

        Task task = tasks.get(index);
        task.SetName(name);
        task.SetDescription(description);
    }

    private int IndexOf(String ID) {
        int index = -1;
        for (Task task : tasks) {
            index++;
            if (task.GetID().equals(ID)) {
                return index;
            }
        }

        return -1;
    }
}
