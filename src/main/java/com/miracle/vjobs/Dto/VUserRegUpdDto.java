package com.miracle.vjobs.Dto;

public class VUserRegUpdDto {
    private String username;
    private String password;
    private String repeatedPassword;

    public VUserRegUpdDto() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VUserRegUpdDto user = (VUserRegUpdDto) obj;
        if (!username.equals(user.username)) {
            return false;
        }
        return password.equals(user.password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}


