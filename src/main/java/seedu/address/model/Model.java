package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.task.Task;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /**
     * Clears existing backing model and replaces with the provided new data.
     */
    void resetData(ReadOnlyTaskManager newData);

    /**
     * Returns the TaskManager
     */
    ReadOnlyTaskManager getTaskManager();

    /**
     * Returns the current amount of Xp that the user has.
     */
    int getXpValue();

    /**
     * Returns true if a task with the same identity as {@code task} exists in the task manager.
     */
    boolean hasTask(Task task);

    /**
     * Deletes the given task.
     * The task must exist in the task manager.
     */
    void deleteTask(Task target);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the task manager.
     */
    void addTask(Task task);

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the task manager.
     * The task identity of {@code editedTask} must not be the same as another existing task in the task manager.
     */
    void updateTask(Task target, Task editedTask);

    /**
     * Replaces the given task {@code target} with {@code updatedTask}.
     * Update the xp field in achievement record of the task manager according to task status change.
     * {@code target} must exist in the task manager.
     * {@code target} and {@code updatedTask} have the same identity but different status.
     */
    void updateTaskStatus(Task target, Task updatedTask);

    /**
     * Returns an unmodifiable view of the filtered task list
     */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

    /**
     * Returns true if the model has previous task manager states to restore.
     */
    boolean canUndoTaskManager();

    /**
     * Returns true if the model has undone task manager states to restore.
     */
    boolean canRedoTaskManager();

    /**
     * Restores the model's task manager to its previous state.
     */
    void undoTaskManager();

    /**
     * Restores the model's task manager to its previously undone state.
     */
    void redoTaskManager();

    /**
     * Saves the current task manager state for undo/redo.
     */
    void commitTaskManager();

    /**
     * Removes all uncommited changes and rollbacks to state pointed by
     * current state pointer.
     */
    void rollbackTaskManager();
}
