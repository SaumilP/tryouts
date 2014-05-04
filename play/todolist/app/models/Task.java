package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by saumil on 2014/05/04.
 */
@Entity
public class Task extends Model {
    @Id
    public Long id;
    @Required
    public String label;

    public static Model.Finder<Long,Task> find = new Model.Finder(Long.class, Task.class);

    public static List<Task> getAll(){
        return find.all();
    }

    public static void create(Task task){
        task.save();
    }

    public static void delete(Long id){
        find.ref(id).delete();
    }
}
