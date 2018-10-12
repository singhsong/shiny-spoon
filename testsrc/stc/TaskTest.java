package stc;
import com.singhblom.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTaskName()
    {
        Task testTask = new Task("Test task", "life", LocalDate.parse("2018-01-01"), true);
        assertEquals("Test task", testTask.getTaskName());
    }

    @Test
    void setTaskName()
    {

    }

    @Test
    void getProjectName() {
    }

    @Test
    void setProjectName() {
    }

    @Test
    void getDueDate() {
    }

    @Test
    void setDueDate() {
    }
}