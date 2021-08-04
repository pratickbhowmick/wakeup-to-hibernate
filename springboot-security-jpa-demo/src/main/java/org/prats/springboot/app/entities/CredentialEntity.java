package org.prats.springboot.app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_credentials")
public class CredentialEntity {

    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(mappedBy = "credential", fetch = FetchType.EAGER)
    private List<AuthorizationEntity> authorizations;

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public List<AuthorizationEntity> getAuthorizations() { return authorizations; }

    public void setAuthorizations(List<AuthorizationEntity> authorizations) { this.authorizations = authorizations; }

}
