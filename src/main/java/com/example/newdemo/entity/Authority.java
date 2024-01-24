package com.example.newdemo.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name="authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authority_id")
    private int authorityId;

    @Column(name="authority_name")
    private String authorityName;

    public Authority() {
    }

    public Authority(int authorityId, String authorityName) {
        this.authorityId = authorityId;
        this.authorityName = authorityName;
    }

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return authorityId == authority.authorityId && Objects.equals(authorityName, authority.authorityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityId, authorityName);
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityId=" + authorityId +
                ", authorityName='" + authorityName + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return authorityName;
    }
}//class
