package fsm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashGenerator {

    public static void generateHash(String unhashedString) {

        int i = 0;
        while (i < 10) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(unhashedString);

            System.out.println(hashedPassword);
            i++;
        }

    }

}
