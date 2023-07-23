package pets_amok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VirtualPetTest {

    @Test
    void appCanSayHappyBirthday() {
        Application test = new Application();
        assertEquals("Test!", test.test(), "App should say Test");
    }
}
