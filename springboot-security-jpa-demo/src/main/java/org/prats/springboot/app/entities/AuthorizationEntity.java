package org.prats.springboot.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_authorizations")
public class AuthorizationEntity {

    @Id
    @Column(name = "authorization_id")
    private String authorizationId;
    @Column(name = "authorization")
    private String authorization;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CredentialEntity credential;

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getAuthorization() { return authorization; }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public CredentialEntity getCredential() {
        return credential;
    }

    public void setCredential(CredentialEntity credentialEntity) {
        this.credential = credentialEntity;
    }
}
