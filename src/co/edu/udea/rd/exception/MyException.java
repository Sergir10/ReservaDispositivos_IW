package co.edu.udea.rd.exception;

/**
 * Clase que nos permite controlar las excepciones resultantes.
 * 
 * @author sergir10
 *
 */
public class MyException extends Exception {

	/**
	 * MyException es un constructor que nos permite mostrar un mensaje que se
	 * desee y el error que causa el error.
	 * 
	 * @param message
	 *            descriptivo de donde se obtuvo el error.
	 * @param cause
	 *            del error.
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor que solo nos permite mostrar el error que lo causo.
	 * 
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
	}

}
