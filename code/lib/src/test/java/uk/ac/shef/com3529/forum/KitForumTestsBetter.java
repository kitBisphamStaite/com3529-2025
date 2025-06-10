package uk.ac.shef.com3529.forum;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class KitForumTestsBetter {

    @Test
    public void shouldNotLoginBannedUser() {
        Forum forum = new Forum();

        // Given a forum with registered users
        registerUserWithUsername("billy", forum);

        // When the user is banned
        forum.ban("billy");

        // Then the user cannot login
        boolean loggedIn = forum.login("billy");
        assertThat(loggedIn, equalTo(false));
    }

    @Test
    public void shouldGetRegisteredUser() {
        // Given a forum
        Forum forum = new Forum();

        // When a user is registered
        registerUserWithUsername("captain", forum);

        // Then can get the user
        assertThat(forum.getUsernames(), contains("captain"));
    }

    @Test
    public void testBan() {
        Forum forum = new Forum();
        // Given a forum with registered users
        registerUserWithUsername("billy", forum);
        for (String username : forum.getUsernames()) {
            forum.ban(username);
        }
        for (String username : forum.getUsernames()) {
            User user = forum.getUser(username);
            assertTrue(user.isBanned());
        }
    }

    @Test
    public void testGetMostProfilicPoster() {
        Forum forum = new Forum();
        // Given a forum with registered users
        registerUserWithUsername("billy", forum);
        makePosts(forum);
        assertThat(forum.getUser(forum.getMostProlificUser()).numPostsMade(), equalTo(2));
    }

    void registerUserWithUsername(String username, Forum forum) {
        forum.registerUser("Billy Sharp", username, "b.sharp@sufc.co.uk");
    }

    void makePosts(Forum forum) {
        forum.post("bash", "Billy Sharp scores goals", "We got Billy Sharp, Billy Sharp. We got Billy Sharp");
        forum.post("bash", "Boxing Day", "Hark now hear, United sing, the Wednesday Ran Away");
        forum.post("billy", "Bladesmen", "We are Bladesmen, super Bladesmen, we are Blademen, from the Lane");
    }
}
