package javabeans;

/**
 * Simple container class to hold the room positions on the screen for the
 * classroom attendance module.
 * @author Richard Scott Smith <rsmith@harriscomputer.com>
 */
public class locator {
	private int x;
	private int y;

	/**
	 * The horizontal position from the left in pixels for this object's
	 * location.
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * The horizontal position from the left in pixels for this object's
	 * location.
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * The vertical position from the top in pixels for this object's location.
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * The vertical position from the top in pixels for this object's location.
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
