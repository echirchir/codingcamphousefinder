package ke.co.codingcamp.db;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey @Index
    private long id;

    private String full_name;
    private String email_address;
    private String phone_number;
    private String password;
    private String user_name;
    private String location;
    private boolean accepted_terms_of_service;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAccepted_terms_of_service() {
        return accepted_terms_of_service;
    }

    public void setAccepted_terms_of_service(boolean accepted_terms_of_service) {
        this.accepted_terms_of_service = accepted_terms_of_service;
    }
}
