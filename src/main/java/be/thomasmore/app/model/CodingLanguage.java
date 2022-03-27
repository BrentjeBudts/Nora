package be.thomasmore.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class CodingLanguage {
    @Id
    private int id;
    private String coding_name;
    private String description;
    private Boolean objectOriented;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @ManyToMany
    private Collection<Uses> uses2;

    @ManyToMany(mappedBy = "languages")
    private Collection<FrameworkEngine> frameworkEngines;

    public CodingLanguage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoding_name() {
        return coding_name;
    }

    public void setCoding_name(String coding_name) {
        this.coding_name = coding_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Collection<Uses> getUses2() {
        return uses2;
    }

    public void setUses2(Collection<Uses> uses2) {
        this.uses2 = uses2;
    }

    public Collection<FrameworkEngine> getFrameworkEngines() {
        return frameworkEngines;
    }

    public void setFrameworkEngines(Collection<FrameworkEngine> frameworkEngines) {
        this.frameworkEngines = frameworkEngines;
    }
}
