package interfaces;

import componentsV2.Person;

public interface IFollow<E> {
	public abstract void follow(E toBeFollowed);
	public abstract void followedBy(E toBeFollower);
	public void unfollow(Person toBeUnFollowed);
	public void removeFollower(Person toBeDeleted);
}
