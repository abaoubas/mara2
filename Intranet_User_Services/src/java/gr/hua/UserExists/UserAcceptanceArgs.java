
package gr.hua.UserExists;

public class UserAcceptanceArgs {
    private int user_id;
    private int request_id;
    private int accept;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int isAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }
    
    
}
