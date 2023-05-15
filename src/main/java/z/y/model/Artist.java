package z.y.model;

import javax.annotation.Generated;

public class Artist {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer artistid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getArtistid() {
        return artistid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}