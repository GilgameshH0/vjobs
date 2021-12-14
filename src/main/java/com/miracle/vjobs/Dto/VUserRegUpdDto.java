package com.miracle.vjobs.Dto;

public class VUserRegUpdDto {
    private String username;
    private String password;
//    private String name;
//    private String surname;
//    private String patronymic;
//    private Gender gender;
//    private LocalDate birthdate;
//    private String email;

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
}


