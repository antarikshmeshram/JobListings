package com.org.jobs.joblistings.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Objects;

@Document(collection = "JobPost")
public class Post {

    private String profile;
    private String desc;
    private int exp;
    private String techs[];

    public Post() {
    }

    public Post(String profile, String desc, int exp, String[] techs) {
        this.profile = profile;
        this.desc = desc;
        this.exp = exp;
        this.techs = techs;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return exp == post.exp && Objects.equals(profile, post.profile) && Objects.equals(desc, post.desc) && Objects.deepEquals(techs, post.techs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, desc, exp, Arrays.hashCode(techs));
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
