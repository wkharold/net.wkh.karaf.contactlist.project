package net.wkh.karaf.contactlist.model;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: wkharold
 * Date: 6/23/12
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContactService {
    Contact getContact(String id);
    void addContact(Contact c);
    void updateContact(Contact c);
    void deleteContact(String id);
    Collection<Contact> getContacts();
}
