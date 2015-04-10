/**
 * Implementation of ImageProvider. Stores captured frames and all associated data.
 * 
 * @author Óscar Javier García Baudet
 * @version 1.0, 2012-12-08
 */

package org.jderobot.androidcameraserver;

import jderobot.AMD_ImageProvider_getImageData;
import jderobot.DataNotExistException;
import jderobot.HardwareFailedException;
import jderobot.ImageData;
import jderobot.ImageDescription;
import jderobot.Time;
import Ice.Current;

public class ImageProviderI extends jderobot._ImageProviderDisp {

  /**
   * Image description that will be delivered by <code>getImageDescription</code>
   * 
   * @see #getImageDescription()
   */
  public static ImageDescription idDatos;

  /**
   * Image content (including date and description) that will be delivered by
   * <code>getImageData</code>
   * 
   * @see #getImageData()
   */
  public static ImageData idImagen;

  /**
   * Serial number generated.
   */
  private static final long serialVersionUID = 1L;

  public ImageProviderI() {
    /* Initialize image description */
    idDatos = new ImageDescription();
    idDatos.height = 0;
    idDatos.width = 0;
    idDatos.format = "NONE";
    /* Initialize image data */
    idImagen = new ImageData();
    idImagen.pixelData = new byte[0];
    idImagen.description = idDatos;
    idImagen.timeStamp = new Time();
    idImagen.timeStamp.seconds = 0;
    idImagen.timeStamp.useconds = 0;
  }

  /**
   * Delivers image description
   * 
   * @return Image description details
   */
  @Override
  public ImageDescription getImageDescription(Current __current) {
    return idDatos;
  }

  static public java.util.LinkedList<Job> _jobs = new java.util.LinkedList<Job>();

  /**
   * Delivers image and its associated description
   */
  @Override
  public void getImageData_async(AMD_ImageProvider_getImageData __cb, Current __current)
      throws DataNotExistException, HardwareFailedException {
    _jobs.add(new Job(__cb));
  }

  /**
   * Implementation of a job queue for batch data delivery
   */
  class Job {
    Job(AMD_ImageProvider_getImageData __cb) {
      cb = __cb;
    }

    void execute() {
      cb.ice_response(idImagen);
    }

    private AMD_ImageProvider_getImageData cb;
  }
}
