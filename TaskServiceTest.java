package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.*;

class TaskServiceTest {

    //service to be tested
    TaskService service;

    //we create a new service before each test
    @BeforeEach
    public void setUpAll() {
        service = new TaskService();
    }

    //testing to make sure we can add a valid task
    @Test
    void TestAddTask() {
        service.AddTask("Test task", "This is a test task");

        assertTrue(service.GetTaskCount() == 1);
        assertTrue(service.At("0").GetID().equals("0"));
        assertTrue(service.At("0").GetName() == "Test task");
        assertTrue(service.At("0").GetDescription() == "This is a test task");
    }

    //testing to make sure we can add multiple valid tasks
    @Test
    void TestAddMultipleTasks() {
        service.AddTask("Task 1", "Description 1");
        service.AddTask("Task 2", "Description 2");
        service.AddTask("Task 3", "Description 3");

        assertTrue(service.GetTaskCount() == 3);
        assertTrue(service.At("0").GetName() == "Task 1");
        assertTrue(service.At("1").GetName() == "Task 2");
        assertTrue(service.At("2").GetName() == "Task 3");

        assertTrue(service.At("0").GetDescription() == "Description 1");
        assertTrue(service.At("1").GetDescription() == "Description 2");
        assertTrue(service.At("2").GetDescription() == "Description 3");
    }

    //testing to remove a valid task
    @Test
    void TestRemoveTask() {
        service.AddTask("Task 1", "Description 1");
        service.AddTask("Task 2", "Description 2");

        assertTrue(service.GetTaskCount() == 2);

        service.DeleteTask("0");

        assertTrue(service.GetTaskCount() == 1);
        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetName()
        );
        assertTrue(service.At("1").GetName() == "Task 2");
    }

    //testing to remove multiple valid tasks
    @Test
    void TestRemoveMultipleTasks() {
        service.AddTask("Task 1", "Description 1");
        service.AddTask("Task 2", "Description 2");
        service.AddTask("Task 3", "Description 3");

        assertTrue(service.GetTaskCount() == 3);

        service.DeleteTask("0");
        service.DeleteTask("2");

        assertTrue(service.GetTaskCount() == 1);
        assertThrows(IllegalArgumentException.class, () ->
            service.At("0").GetName()
        );
        assertTrue(service.At("1").GetName() == "Task 2");
        assertThrows(IllegalArgumentException.class, () ->
            service.At("2").GetName()
        );
    }

    //testing to remove an invalid task
    @Test
    void TestRemoveTaskFails() {
        service.AddTask("Task 1", "Description 1");
        service.AddTask("Task 2", "Description 2");

        assertThrows(IllegalArgumentException.class, () ->
            service.DeleteTask("2")
        );
    }

    //tesing to update a task with valid inputs
    @Test
    void TestUpdateTask() {
        service.AddTask("Task 1", "Description 1");

        service.UpdateTask("0", "New Task 1", "New Description 1");

        assertTrue(service.At("0").GetName() == "New Task 1");
        assertTrue(service.At("0").GetDescription() == "New Description 1");
    }

    //testing to update tasks with null inputs
    @Test
    void TestUpdateTaskFailsNull() {
        service.AddTask("Task 1", "Description 1");

        assertThrows(IllegalArgumentException.class, () ->
            service.UpdateTask("0", null, "New Description 1")
        );
        assertThrows(IllegalArgumentException.class, () ->
            service.UpdateTask("0", "New Task 1", null)
        );
    }

    //testing to update tasks with inputs that are too long
    @Test
    void TestUpdateTaskFailsTooLong() {
        service.AddTask("Task 1", "Description 1");

        assertThrows(IllegalArgumentException.class, () ->
            service.UpdateTask(
                "0",
                "This name is way too long so we can test it",
                "New Description 1"
            )
        );
        assertThrows(IllegalArgumentException.class, () ->
            service.UpdateTask(
                "0",
                "New Task 1",
                "This description needs to be even longer for it to throw so i'll keep writing"
            )
        );
    }

    //testing to access an invalid task
    @Test
    void TestAtFails() {
        service.AddTask("Task 1", "Description 1");

        assertThrows(IllegalArgumentException.class, () ->
            service.At("1").GetName()
        );
    }
}
