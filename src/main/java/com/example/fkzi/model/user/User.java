package com.example.fkzi.model.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @Column(name = "mailbox_address", nullable = false, unique = true)
    private String mailboxAddress;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "group_id", nullable = false, length = 10)
    private String groupId;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "additional_job_title")
    private String additionalJobTitle;

    @Column(name = "is_on_scholarships")
    private Boolean isOnScholarships;

    @Column(name = "education_form")
    private String educationForm;

    @Column(name = "subjects_id")
    private Integer subjectsId;

    @Column(name = "google_data")
    private String googleData;

   //security config

    @Transient
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(jobTitle));
            authorities.add(new SimpleGrantedAuthority(additionalJobTitle));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return fullName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}

