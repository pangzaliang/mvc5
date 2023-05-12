package z.y.model;

import javax.annotation.Generated;

public class DbUser {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer age;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Short sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUid() {
        return uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getAge() {
        return age;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Short getSex() {
        return sex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSex(Short sex) {
        this.sex = sex;
    }
}