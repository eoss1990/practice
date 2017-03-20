package dozer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by yangyu on 2017/3/14.
 */
public class TargetBean {

    private int targetId;

    private String targetName;

    private String targetText;

    private RefBean targetRefBean;

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetText() {
        return targetText;
    }

    public void setTargetText(String targetText) {
        this.targetText = targetText;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public RefBean getTargetRefBean() {
        return targetRefBean;
    }

    public void setTargetRefBean(RefBean targetRefBean) {
        this.targetRefBean = targetRefBean;
    }
}
