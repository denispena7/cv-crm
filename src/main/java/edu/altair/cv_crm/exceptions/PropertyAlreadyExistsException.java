package edu.altair.cv_crm.exceptions;

public class PropertyAlreadyExistsException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	public PropertyAlreadyExistsException(String mensaje) 
	{
        super(mensaje);
    }
}
