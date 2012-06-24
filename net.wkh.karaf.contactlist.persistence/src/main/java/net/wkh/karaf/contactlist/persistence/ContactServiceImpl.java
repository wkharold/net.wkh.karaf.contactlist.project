package net.wkh.karaf.contactlist.persistence;

import net.wkh.karaf.contactlist.model.Contact;
import net.wkh.karaf.contactlist.model.ContactService;

import java.util.Collection;
import java.util.HashMap;

public class ContactServiceImpl implements ContactService {
    private HashMap<String, Contact> db;
    private int nextid = 0;

    public ContactServiceImpl() {
        db = new HashMap<String, Contact>();
        db.put(Integer.toString(nextid), new Contact(Integer.toString(nextid++), "fred c dobbs", "fred.c.dobbs@sierra.madre"));
        db.put(Integer.toString(nextid), new Contact(Integer.toString(nextid++), "rooster cogburn", "rooster@ftsmith.gov"));
    }

    @Override
    public Contact getContact(String id) {
        return db.get(id);
    }

    @Override
    public void addContact(Contact c) {
        String id = Integer.toString(nextid++);
        c.setId(id);
        db.put(id, c);
    }

    @Override
    public void updateContact(Contact nc) {
        String id = nc.getId();
        Contact oc = db.get(id);
        if (oc != null) {
            db.put(id, nc);
        }
    }

    @Override
    public void deleteContact(String id) {
        db.remove(id);
    }

    @Override
    public Collection<Contact> getContacts() {
        return db.values();
    }
}