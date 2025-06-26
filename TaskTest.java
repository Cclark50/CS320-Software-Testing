package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tasks.Task;

class TaskTest {

    //test to create a vaild task
    @Test
    void TestTask() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        assertTrue(task.GetID() == "1");
        assertTrue(task.GetName() == "Christian");
        assertTrue(task.GetDescription() == "TestDescription 123");
    }

    //testing creating a task with an ID that is too long
    @Test
    void TestTaskIDTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("123456789012", "Christian", "TestDescription 123")
        );
    }

    //testing creating a task with a null ID
    @Test
    void TestTaskIDNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task(null, "Christian", "TestDescription 123")
        );
    }

    //testing creating a task with a name that is too long
    @Test
    void TestTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task(
                "1",
                "We need to keep writing until we get past 20 characters",
                "TestDescription 123"
            )
        );
    }

    //testing creating a task with a null name
    @Test
    void TestTaskNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("1", null, "TestDescription 123")
        );
    }

    //testing creating a task with a description that is too long
    @Test
    void TestTaskDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task(
                "1",
                "Christian",
                "The description needs to be way too long for this to throw an exception, So I'll keep writing until we get past 50 characters"
            )
        );
    }

    //testing creating a task with a description that is null
    @Test
    void TestTaskDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("1", "Christian", null)
        );
    }

    //testing setting a valid name
    @Test
    void TestSetTaskName() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        task.SetName("John");
        assertTrue(task.GetName() == "John");
    }

    //testing setting a long name
    @Test
    void TestSetTaskNameTooLong() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        assertThrows(IllegalArgumentException.class, () ->
            task.SetName(
                "We need to keep writing until we get past 20 characters"
            )
        );
    }

    //testing setting a null name
    @Test
    void TestSetTaskNameNull() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        assertThrows(IllegalArgumentException.class, () -> task.SetName(null));
    }

    //testing setting a valid description
    @Test
    void TestSetTaskDescription() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        task.SetDescription("New description");
        assertTrue(task.GetDescription() == "New description");
    }

    //testing setting a long description
    @Test
    void TestSetTaskDescriptionTooLong() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        assertThrows(IllegalArgumentException.class, () ->
            task.SetDescription(
                "The description needs to be way too long for this to throw an exception, So I'll keep writing until we get past 50 characters"
            )
        );
    }

    //testing setting a null description
    @Test
    void TestSetTaskDescriptionNull() {
        Task task = new Task("1", "Christian", "TestDescription 123");
        assertThrows(IllegalArgumentException.class, () ->
            task.SetDescription(null)
        );
    }
}
