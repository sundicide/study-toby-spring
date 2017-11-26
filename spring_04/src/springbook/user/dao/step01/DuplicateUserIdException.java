package springbook.user.dao.step01;

public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(Throwable cause){
		super(cause);
	}
}
