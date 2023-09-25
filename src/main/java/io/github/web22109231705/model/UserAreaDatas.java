package io.github.web22109231705.model;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JavaBean
public class UserAreaDatas implements Serializable {
    private List<AreaData> areaDataList;

    public UserAreaDatas() {
        super();
    }

    public List<AreaData> getAreaDataList() {
        return areaDataList;
    }

    public void setAreaDataList(List<AreaData> areaDataList) {
        this.areaDataList = areaDataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAreaDatas)) return false;
        UserAreaDatas that = (UserAreaDatas) o;
        return Objects.equals(getAreaDataList(), that.getAreaDataList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAreaDataList());
    }

    @Override
    public String toString() {
        return "UserAreaDatas{" +
                "areaDataList=" + areaDataList +
                '}';
    }
}
