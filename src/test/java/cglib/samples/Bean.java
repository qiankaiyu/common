
package cglib.samples;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * @author Chuck
 * @since 12/31/2020
 * @version
 *
 **/
// @NoArgsConstructor
// @Getter
// @Setter
public abstract class Bean implements Serializable {

    String sampleProperty;

    abstract public void addPropertyChangeListener(PropertyChangeListener listener);

    abstract public void removePropertyChangeListener(PropertyChangeListener listener);
}
