package murach.business;

import java.io.Serializable;
public class Survey implements Serializable {
    private String source;
    private boolean announcements;
    private boolean specialOffers;
    private String contactVia;

    public Survey() {
        source = "";
        announcements = false;
        specialOffers = false;
        contactVia = "Both";
    }

    public Survey(String source, boolean announcements,
                  boolean specialOffers, String contactVia) {
        this.source = source;
        this.announcements = announcements;
        this.specialOffers = specialOffers;
        this.contactVia = contactVia;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public boolean isAnnouncements() {
        return announcements;
    }
    public void setAnnouncements(boolean announcements) {
        this.announcements = announcements;
    }

    public boolean isSpecialOffers() {
        return specialOffers;
    }
    public void setSpecialOffers(boolean specialOffers) {
        this.specialOffers = specialOffers;
    }

    public String getContactVia() {
        return contactVia;
    }
    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }
}
