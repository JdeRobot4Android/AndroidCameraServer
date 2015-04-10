package org.jderobot.androidcameraserver;

import jderobot.AMD_ImageProvider_getImageData;
import jderobot.CameraDescription;
import jderobot.DataNotExistException;
import jderobot.HardwareFailedException;
import jderobot.ImageData;
import jderobot.ImageDescription;
import jderobot.Time;
import Ice.Current;

public class CameraI extends jderobot._CameraDisp {

  /**
   * Get the description of the image that will be delivered at <code>getImageDescription</code>
   * 
   * @see #getImageDescription()
   */
  public static ImageDescription idDatos;

  /**
   * Get the image content (including date and description) that will delivered at
   * <code>getImageData</code>
   * 
   * @see #getImageData()
   */
  public static ImageData idImagen;

  /**
   * Serial number generated
   */
  private static final long serialVersionUID = 1L;

  CameraDescription descripcion;

  CameraI() {
    descripcion = new CameraDescription();
    descripcion.name = "Android";
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

  @Override
  public CameraDescription getCameraDescription(Current __current) {
    return descripcion;
  }

  @Override
  public int setCameraDescription(CameraDescription description, Current __current) {
    descripcion = description;
    return 0;
  }

  @Override
  public String startCameraStreaming(Current __current) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void stopCameraStreaming(Current __current) {
    // TODO Auto-generated method stub
  }

  @Override
  public void reset(Current __current) {
    // TODO Auto-generated method stub
  }

  /**
   * Delivers image description
   * 
   * @return Image description data
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
