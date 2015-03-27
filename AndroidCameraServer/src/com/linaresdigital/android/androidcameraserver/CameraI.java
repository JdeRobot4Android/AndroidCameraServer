package com.linaresdigital.android.androidcameraserver;

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

	CameraDescription descripcion;
	
	CameraI() {
		descripcion = new CameraDescription();
		descripcion.name = "Android";
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
	
	@Override
	public CameraDescription getCameraDescription(Current __current) {
		// TODO Auto-generated method stub
		return descripcion;
	}

	@Override
	public int setCameraDescription(CameraDescription description,
			Current __current) {
		// TODO Auto-generated method stub
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
