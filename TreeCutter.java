package scripts;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

public class TreeCutter{
	final static RSArea treeLocation = new RSArea(new RSTile(3160,3449,0), new RSTile(3150,3459,0));

	/**
	 * method that returns a boolean to whether the characters current position is within the specified tiles within treeLocation
	 * @returns whether the player is in the location or not
	 */
	public static boolean atTreeLocation() {
		return treeLocation.contains(Player.getPosition());
	}

	/**
	 * method that returns a boolean to see whether the character is currently cutting a tree or standing there (if the player is standing there then the value is -1)
	 * @returns whether the player is performing an action or not
	 */
	public static boolean Cutting() {
		return Player.getAnimation() > 0;
	}

	/**
	 * this method is what makes the bot function, it checks to see if the character is within the specified area and if not then the bot will walk the character to a random tile
	 * within the specified area, if the character is in the area then the bot checks to see if the character is doing nothing and if the character is doing nothing then it will
	 * cut the closest tree
	 */
	public static void cuttingActivity() {
		if (atTreeLocation()) {
			if (Player.getAnimation() == -1) {
				if (cutTree()) {
					Timing.waitCondition(Conditions.get().DoingActivity(), General.random(4000, 6000));	//this function waits until the condition is not true to continue and waits 4-6 seconds until testing the condition again
				}
			}
		}
		else {
			Walking.blindWalkTo(treeLocation.getRandomTile());
			Timing.waitCondition(Conditions.get().Moving(), General.random(12000, 16000));//if character is moving, waits 12-16 seconds until checking again to continue

		}
	}

	/**
	 * method that creates an array of RSobjects(the trees) within a 10 wile radius
	 * tests to make sure there are values in the array
	 * sets the closest tree value to a RSObject value and then tests to make sure the value is not null (without this, the null pointerException is thrown)
	 * checks to see if the tree selected is on the screen, if it is then it clicks the tree but if it is not then it walks to the tree
	 * @returns a boolean that does a click function at the same time
	 */
	public static boolean cutTree() {
		RSObject[] trees = Objects.findNearest(10,"Tree");
		if(trees.length == 0) {
			return false;
		}
		RSObject tree = trees[0];
		if(tree == null) {
			return false;
		}
		if(tree.isOnScreen()) {
			return tree.click("Chop down");
		}
		else {
			return Walking.walkTo(tree);
		}
	}


}
