package scripts;


import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class TreeBanker{
	final static int[] AXES = {1351, 1349, 1353, 1361, 1357, 1359};//values of the axes used to woodcut
	final static RSArea bankLocation = new RSArea(new RSTile(3191,3448,0), new RSTile(3179,3432,0));

	/**
	 * checks if the player's location is in the bank area
	 * @return true if player is in the tiles specified by bankLocation false if the player is not in the area
	 */
	public static boolean atBank() {
		return bankLocation.contains(Player.getPosition());
	}

	/**
	 * if player is at the bank then it banks the logs, if not then the player walks to the bank
	 */
	public static void bankingActivity() {
		if (atBank()) {
			bankLogs();
		}
		else {
			Walking.blindWalkTo(bankLocation.getRandomTile());
			Timing.waitCondition(Conditions.get().Moving(), General.random(4000, 7000));//if character is moving the bot waits 4-7 to continue
		}
	}

	/**
	 * this method banks all of the logs in the inventory if the bank is open, if it is not open then it opens the bank
	 */
	public static void bankLogs() {
		if(Banking.isBankScreenOpen()) {
			if(Banking.depositAllExcept(AXES) > 0) {
				Timing.waitCondition(bankChecker(), General.random(5000, 8000));//if the inventory still has logs then it waits 5-8 seconds to continue
			}
		}
		else {
			if(Banking.openBank()) {
				Timing.waitCondition(openBank(), General.random(5000, 8000)); //while the character opens the bank, wait 5-8 seconds
			}
		}
	}

	/**
	 * creates a condition to use in the waitCondition parameter that opens the bank
	 * @returns a condition to open the bank
	 */
	@SuppressWarnings("deprecation")
	private static Condition openBank() {
		return new Condition() {

			@Override
			public boolean active() {
				return Banking.openBank();
			}

		};
	}

	/**
	 * creates a new test condition to see whether the player's inventory still has logs
	 * @returns a condition that waits until the inventory is empty
	 */
	@SuppressWarnings("deprecation")
	public static Condition bankChecker() {
		return new Condition() {

			@Override
			public boolean active() {
			 return Inventory.find("Logs").length == 0;
			}

		};
	}

}
