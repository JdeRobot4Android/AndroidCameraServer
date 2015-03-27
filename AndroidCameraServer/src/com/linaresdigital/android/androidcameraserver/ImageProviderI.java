/**
 * Implementación de ImageProvider. Almacena los fotogramas capturados así
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
     * La descripción de la imagen que será entregada en
     * <code>getImageDescription</code>.
     *
     * @see #getImageDescription()
     */
    public static ImageDescription idDatos;

	/**
     * Contenido de la imagen (incluyendo descripción y fecha) que será entregado en
     * <code>getImageData</code>.
     *
     * @see #getImageData()
     */
    public static ImageData idImagen;
	
	/**
	 * Número de serie generado.
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageProviderI() {
		/* Inicializamos la descripción de la imagen */
		idDatos = new ImageDescription();
		idDatos.height = 0;
		idDatos.width = 0;
		idDatos.format = "NONE";
		/* Inicializamos los datos de la imagen */
		idImagen = new ImageData();
		idImagen.pixelData = new byte[0];
		idImagen.description = idDatos;
		idImagen.timeStamp = new Time();
		idImagen.timeStamp.seconds = 0;
		idImagen.timeStamp.useconds = 0;
	}

	/**
	 * Entrega la descripción de la imagen.
	 * @return Datos de la descripción de la imagen
	 */
	@Override
	public ImageDescription getImageDescription(Current __current) {
		return idDatos;
	}

	static public java.util.LinkedList<Job> _jobs = new java.util.LinkedList<Job>();
	/**
	 * Entrega la imagen y su descripción asociada.
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
