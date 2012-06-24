package net.wkh.karaf.contactlist.ui;

import net.wkh.karaf.contactlist.model.Contact;
import net.wkh.karaf.contactlist.model.ContactService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class ContactListServlet extends HttpServlet {
    private ContactService cs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contactId = req.getParameter("contactId");
        PrintWriter writer = resp.getWriter();
        if (contactId != null && contactId.length() > 0) {
            showContact(writer, contactId);
        } else {
            showContactList(writer);
        }
    }

    private void showContact(PrintWriter w, String id) {
        Contact c = cs.getContact(id);
        if (c != null) {
            w.println("<h1>" + c.getName() +"</h1>");
            w.println("Email: " + c.getEmail() + "<br/>");
        } else {
            w.println("No such contact id");
        }
    }

    private void showContactList(PrintWriter w) {
        w.println("<h1>Contacts</h1>");
        Collection<Contact> contacts = cs.getContacts();
        for (Contact c : contacts) {
            w.println("<a href=\"?contactId=" + c.getId() + "\">" + c.getName() + "</a><br/>");
        }
    }

    public void setContactService(ContactService cs) {
        this.cs = cs;
    }
}