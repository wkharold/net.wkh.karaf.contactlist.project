package net.wkh.karaf.contactlist.model;

/**
 * Created with IntelliJ IDEA.
 * User: wkharold
 * Date: 6/23/12
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contact {
    private String id;
    private String name;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Contact(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
