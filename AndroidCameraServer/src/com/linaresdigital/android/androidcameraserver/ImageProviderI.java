/**
 * Implementation of image provider. Almacena los fotogramas capturados así
 * como todos los datos asociados al mismo.
 * @author Óscar Javier García Baudet
 * @version 1.0, 2012-12-08
 */

package com.linaresdigital.android.androidcameraserver;

import jderobot.AMD_ImageProvider_getImageData;
import jderobot.DataNotExistException;
import jderobot.HardwareFailedException;
import jderobot.ImageData;
import jderobot.ImageDescription;
import jderobot.Time;
import Ice.Current;

public class ImageProviderI extends jderobot._ImageProviderDisp {

	/**
     * Get the description of the image that will be delivered
     * <code>getImageDescription</code>.
     *
     * @see #getImageDescription()
     */
    public static ImageDescription idDatos;

	/**
     * Get the image content(including date and description)
     * <code>getImageData</code>.
     *
     * @see #getImageData()
     */
    public static ImageData idImagen;
	
	/**
	 * Serial number generated.
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageProviderI() {
		/* Initialize imagedescription */
		idDatos = new ImageDescription();
		idDatos.height = 0;
		idDatos.width = 0;
		idDatos.format = "NONE";
		/* Initialize the imagedata */
		idImagen = new ImageData();
		idImagen.pixelData = new byte[0];
		idImagen.description = idDatos;
		idImagen.timeStamp = new Time();
		idImagen.timeStamp.seconds = 0;
		idImagen.timeStamp.useconds = 0;
	}

	/**
	 * Gets the image description
	 * @return Details image description
	 */
	@Override
	public ImageDescription getImageDescription(Current __current) {
		return idDatos;
	}

	static public java.util.LinkedList<Job> _jobs = new java.util.LinkedList<Job>();
	/**
	 * Gets image and its associated description
	 */
	@Override
	public void getImageData_async(AMD_ImageProvider_getImageData __cb,
			Current __current) throws DataNotExistException,
			HardwareFailedException {
		_jobs.add(new Job(__cb));
	}

	class Job {
	    Job(AMD_ImageProvider_getImageData __cb)
	    {
	        cb = __cb;
	    }

	    void execute()
	    {
	        cb.ice_response(idImagen);
	    }


	    private AMD_ImageProvider_getImageData cb;
	}
}
