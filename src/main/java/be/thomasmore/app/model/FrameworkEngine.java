package be.thomasmore.app.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class FrameworkEngine {

    @Id
    private int id;
    private String name;
    private String quote;
    private Boolean paidForStudents;
    private Boolean paidForCompany;
    private int popularity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @ManyToMany
    private Collection<Uses> uses;
    @ManyToMany
    private Collection<CodingLanguage> languages;

    public FrameworkEngine() {}
    public String getName() {
        return name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Collection<Uses> getUses() {
        return uses;
    }

    public Boolean getPaidForStudents() {
        return paidForStudents;
    }

    public void setPaidForStudents(Boolean paidForStudents) {
        this.paidForStudents = paidForStudents;
    }

    public Boolean getPaidForCompany() {
        return paidForCompany;
    }

    public void setPaidForCompany(Boolean paidForCompany) {
        this.paidForCompany = paidForCompany;
    }

    public void setUses(Collection<Uses> uses) {
        this.uses = uses;
    }

    public Collection<CodingLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<CodingLanguage> languages) {
        this.languages = languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public int getPopularity() {
        return popularity;
    }

}
