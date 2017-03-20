package dozer;

import org.dozer.Mapping;

/**
 * Created by yangyu on 2017/3/14.
 */
public class SourceBean {

    @Mapping("targetId")
    private int id;

    @Mapping("targetName")
    private String name;

    @Mapping("targetText")
    private String text;

    @Mapping("targetRefBean")
    private RefBean refBean;

    public SourceBean(int id,String name,String text){
        this.id=id;
        this.name=name;
        this.text=text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RefBean getRefBean() {
        return refBean;
    }

    public void setRefBean(RefBean refBean) {
        this.refBean = refBean;
    }
}
