package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location is required")
    @NotNull(message = "Location is required")
    private String location;

    @AssertTrue(message = "Registration required must be true for no good reason")
    private boolean registrationRequired;

    @Positive(message = "Number of attendees must be a positive number")
    private int attendees;

    private EventType type;

    public Event(String name, String description, String contactEmail, String location, boolean registrationRequired, int attendees, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.attendees = attendees;
        this.type = type;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getContactEmail() { return contactEmail; }

    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public int getId() { return id; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public boolean isRegistrationRequired() { return registrationRequired; }

    public void setRegistrationRequired(boolean registrationRequired) { this.registrationRequired = registrationRequired; }

    public int getAttendees() { return attendees; }

    public void setAttendees(int attendees) { this.attendees = attendees; }

    public EventType getType() { return type; }

    public void setType(EventType type) { this.type = type; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
