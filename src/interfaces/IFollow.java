package interfaces;

public interface IFollow<E> {
	public abstract void follow(E toBeFollowed);
	public abstract void followedBy(E toBeFollower);
}
