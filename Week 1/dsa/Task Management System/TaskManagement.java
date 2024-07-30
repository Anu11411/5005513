class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class Node {
    Task data;
    Node next;

    public Node(Task data) {
        this.data = data;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.taskId == taskId) {
                System.out.println("Task found: " + temp.data.taskName);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found");
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data.taskId + ", " + temp.data.taskName + ", " + temp.data.status);
            temp = temp.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.taskId == taskId) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.taskId == taskId) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found");
    }
}

public class TaskManagement {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTask(new Task(1, "Task A", "Pending"));
        taskList.addTask(new Task(2, "Task B", "In Progress"));
        taskList.addTask(new Task(3, "Task C", "Completed"));

        taskList.traverseTasks();
        taskList.searchTask(2);
        taskList.deleteTask(2);
        taskList.traverseTasks();
    }
}
