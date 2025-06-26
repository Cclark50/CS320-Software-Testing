/*
 **@Author Christian Clark
 **@Date 5/28/25
 **This is a task class that holds an ID, name, and description
 */
package tasks;

public class Task {

    private final String ID;
    private String name;
    private String description;

    public Task(String ID, String name, String descrption) {
        if (ID == null || ID.length() >= 11) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (name == null || name.length() >= 21) {
            throw new IllegalArgumentException("Invalid Name");
        }
        if (descrption == null || descrption.length() >= 51) {
            throw new IllegalArgumentException("Invalid Description");
        }

        this.ID = ID;
        this.name = name;
        this.description = descrption;
    }

    public String GetID() {
        return ID;
    }

    public String GetName() {
        return name;
    }

    public String GetDescription() {
        return description;
    }

    public void SetName(String name) {
        if (name == null || name.length() >= 21) {
            throw new IllegalArgumentException("Invalid Name");
        }

        this.name = name;
    }

    public void SetDescription(String description) {
        if (description == null || description.length() >= 51) {
            throw new IllegalArgumentException("Invalid Description");
        }

        this.description = description;
    }
}
