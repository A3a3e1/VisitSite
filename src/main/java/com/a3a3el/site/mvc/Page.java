package com.a3a3el.site.mvc;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by paulvoropaiev on 11/23/15.
 */
@Entity
@Table(name = "pages", schema = "", catalog = "visit_site")
@NamedQueries({
        @NamedQuery(name = "Page.findByUrl", query = "SELECT p FROM Page p where p.url = :url")
})
@XmlRootElement
public class Page  implements Serializable{
    private int id;
    private String url;
    private String indexpage;
    private String description;
    private String content;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "indexpage", nullable = true, insertable = true, updatable = true, length = 45)
    public String getIndexpage() {
        return indexpage;
    }

    public void setIndexpage(String index) {
        this.indexpage = index;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "content", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page that = (Page) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (indexpage != null ? !indexpage.equals(that.indexpage) : that.indexpage != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (indexpage != null ? indexpage.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
