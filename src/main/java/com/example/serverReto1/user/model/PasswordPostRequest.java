package com.example.serverReto1.user.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PasswordPostRequest {

    @NotNull @Length(min = 5, max = 70)
    private String username;
    @NotNull
    @Length(min = 5, max = 70)
    private String oldPassword;
    @NotNull
    @Length(min = 5, max = 70)
    private String newPassword;

    public PasswordPostRequest() {
    }

    public PasswordPostRequest(String username, String oldPassword, String newPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "PasswordPostRequest{" +
                "username='" + username + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
