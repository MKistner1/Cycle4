package scripts;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Player;

@SuppressWarnings("deprecation")
public class Conditions {

	private static Conditions condition = null;

	/*
	 * returns a condition that tests if the player is doing the cutting action
	 */
	public Condition Chopping() {
		return new Condition() {

			@Override
			public boolean active() {
				return Player.getAnimation()==867;
			}

		};

	}

	/*
	 * returns a condition that tests if the bank screen is open
	 */
	public Condition Banking() {
		return new Condition() {

			@Override
			public boolean active() {
				return Banking.isBankScreenOpen();
			}

		};

	}

	/*
	 * creates a condition that tests if the player is doing an activity (not standing there)
	 */
	public Condition DoingActivity() {
		return new Condition() {

			@Override
			public boolean active() {
				return Player.getAnimation() != -1;
			}

		};

	}

	/*
	 * creates a condition that tests if the player is moving
	 */
	public Condition Moving() {
		return new Condition() {

			@Override
			public boolean active() {
				if(!Player.isMoving()) {
					return false;
				}
				return true;
			}

		};

	}

		/*
		 * method to that returns the value of a condition
		 */
	public static Conditions get() {
		if(condition!=null) {
			return condition;
		}
		else {
			return new Conditions();
		}
	}




}
