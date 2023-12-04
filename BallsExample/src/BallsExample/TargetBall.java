package BallsExample;



/**

 *  is a Ball which is the target for the player to hit
 */


/**
 * @author shsmchlr
 * The Target Ball which you are aiming at
 */
public class TargetBall extends Ball {
	private int score;
	/**
	 * 
	 */
	public TargetBall() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public TargetBall(double ix, double iy, double ir) {
		super(ix, iy, ir);
		score = 0;
		col = 'g';
	}

	/** 
	 * checkBall in arena 
	 * @param b BallArena
	 */
	@Override
	protected void checkBall(BallArena b) {
		if (b.checkHit(this)) score++;			// if been hit, then increase score
	}
	/**
	 * draw Ball and display score
	 */
	public void drawBall(MyCanvas mc) {
		super.drawBall(mc);
		mc.showInt(x, y, score);
	}

	/**
	 * adjustBall
	 * for moving the ball - not needed here
	 */
	@Override
	protected void adjustBall() {
				// nothing to do at the moment...
	}
	/**
	 * return string defining ball ... here as target
	 */
	protected String getStrType() {
		return "Target";
	}	
}
