
public class ServiceNotAvailableAtTheMoment extends Exception {
	public String getMessage(){
		String err = "Exceptions messages and traces are watched by *developer*. It is a sign of courtesy and respectfullness to write good, descriptive and concise exception messages to help people that investigate when things go wrong.";
		return err;
	}
}
