package be.thomasmore.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Uses {
    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "uses2")
    Collection<CodingLanguage> codings;

    @ManyToMany(mappedBy = "uses")
    Collection<FrameworkEngine> frameworkEngines;

    public Uses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
