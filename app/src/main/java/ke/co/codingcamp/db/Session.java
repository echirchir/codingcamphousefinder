package ke.co.codingcamp.db;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Session extends RealmObject {

    @PrimaryKey @Index
    private long id;

    private boolean is_logged_in;
    private long session_begin;
    private long session_end;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIs_logged_in() {
        return is_logged_in;
    }

    public void setIs_logged_in(boolean is_logged_in) {
        this.is_logged_in = is_logged_in;
    }

    public long getSession_begin() {
        return session_begin;
    }

    public void setSession_begin(long session_begin) {
        this.session_begin = session_begin;
    }

    public long getSession_end() {
        return session_end;
    }

    public void setSession_end(long session_end) {
        this.session_end = session_end;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
