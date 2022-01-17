package concurrency.completablefuture;

import concurrency.executor.Nap;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
@Slf4j
@Data
public class Machina {
    public enum State {
        START, ONE, TWO, THREE, END;

        State step() {
            if (equals(END)) {
                return END;
            }
            return values()[ordinal() + 1];
        }
    }

    private State state = State.START;
    private final int id;;

    Machina(int id) {
        this.id = id;
    }

    static Machina work(Machina m) {
        if (!m.state.equals(State.END)) {
            new Nap(0.1);
            m.state = m.state.step();
        }
        log.info("{}", m);
        return m;
    }
}
