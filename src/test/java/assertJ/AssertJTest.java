package assertJ;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatIOException;

public class AssertJTest {
    @Test
    public void IO_예외처리(){
        assertThatIOException().isThrownBy(()-> {throw new IOException("Boom!!");
        } )
                .withMessage("%s!","Boom!")
                .withMessageContaining("Boom!!")
                .withNoCause();
    }

}
