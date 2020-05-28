package id.ac.unhas.finaltodolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.unhas.finaltodolist.database.ToDoRepository

class ToDoViewModel(application: Application): AndroidViewModel(application) {
    private var todoRepository =
        ToDoRepository(application)
    private var todos: LiveData<List<ToDo>>? = todoRepository.getTodos()


    fun getTodos(): LiveData<List<ToDo>>? {
        return todos
    }

    fun insertTodo(todo: ToDo) {
        todoRepository.insert(todo)
    }

    fun deleteTodo(todo: ToDo) {
        todoRepository.delete(todo)
    }

    fun updateTodo(todo: ToDo) {
        todoRepository.update(todo)
    }
}