package villagegaulois;

public class VillageSansChefException extends Exception {  //ce n'est pas une runtime exception la on force à traiter l'exception
	public VillageSansChefException() {
		
	}
	public VillageSansChefException(String message) {
		
		super(message);
	}
	public VillageSansChefException(Throwable cause) {
		super(cause);
	}
	public VillageSansChefException(String message, Throwable cause) {
		super(message, cause);
	}
}
