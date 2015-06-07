package gr.hua.Internet;

//import com.sun.istack.internal.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author palia_000
 */
public class Users {

    // @NotNull

    private int user_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private String strBirthdate;
    private String gender;
    private String email;
    private String IBAN;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public String getStrBirthdate() {
        return df.format(this.birthdate);
    }

    public void setStrBirthdate(String strBirthdate) throws ParseException {
        this.birthdate = new java.sql.Date(df.parse(strBirthdate).getTime());

    }

}
