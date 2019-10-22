package scripts;

import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Player;

@SuppressWarnings("deprecation")
public class Conditions {

	private static Conditions condition = null;


	public Condition Chopping() {
		return new Condition() {

			@Override
			public boolean active() {
				return Player.getAnimation()==867;
			}

		};

	}
	public Condition Banking() {
		return new Condition() {

			@Override
			public boolean active() {
				return Banking.isBankScreenOpen();
			}

		};

	}
	public Condition DoingActivity() {
		return new Condition() {

			@Override
			public boolean active() {
				return Player.getAnimation() != -1;
			}

		};

	}
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

	public static Conditions get() {
		if(condition!=null) {
			return condition;
		}
		else {
			return new Conditions();
		}
	}




}
