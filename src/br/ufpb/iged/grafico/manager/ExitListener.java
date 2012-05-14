<<<<<<< HEAD
package br.ufpb.iged.grafico.manager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** A listener that you attach to the top-level Frame or JFrame of
 *  your application, so quitting the frame exits the application.
 *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class ExitListener extends WindowAdapter {
  public void windowClosing(WindowEvent event) {
    System.exit(0);
  }
=======
package br.ufpb.iged.grafico.manager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** A listener that you attach to the top-level Frame or JFrame of
 *  your application, so quitting the frame exits the application.
 *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class ExitListener extends WindowAdapter {
  public void windowClosing(WindowEvent event) {
    System.exit(0);
  }
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}