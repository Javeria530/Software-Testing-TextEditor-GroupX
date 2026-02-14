package data;

import static org.junit.Assert.*;
import org.junit.Test;
import dal.DatabaseConnection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class SingletonTests {

    @Test
    public void testSingletonInstance() {
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        assertNotNull("Instance should not be null", instance1);
        assertSame("Both instances should be the exact same object (Singleton property)", instance1, instance2);
    }

    @Test
    public void testPrivateConstructor() {
        Constructor<?>[] constructors = DatabaseConnection.class.getDeclaredConstructors();
        assertEquals("There should be exactly one constructor", 1, constructors.length);

        int modifiers = constructors[0].getModifiers();
        assertTrue("Constructor should be private to enforce Singleton pattern", Modifier.isPrivate(modifiers));
    }
}
