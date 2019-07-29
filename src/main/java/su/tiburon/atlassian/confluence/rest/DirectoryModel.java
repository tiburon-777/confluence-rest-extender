package su.tiburon.atlassian.confluence.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.atlassian.crowd.embedded.api.DirectoryType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DirectoryModel {

    @XmlElement
    private Long id;

    @XmlElement
    private DirectoryType type;

    @XmlElement
    private Boolean issynchronising;

    public DirectoryModel() {
        this.id = null;
        this.type = null;
        this.issynchronising = false;
    }

    public DirectoryModel(Long id, DirectoryType type, Boolean issynchronising) {
        this.id = id;
        this.type = type;
        this.issynchronising = issynchronising;
    }
}