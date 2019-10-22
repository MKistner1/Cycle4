package scripts;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Inventory;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

@ScriptManifest(authors = { "Khee" }, category = "Woodcutting", name = "kWoodcutter")//allows me to locally run this program
public class Main extends Script{
	final long time = Timing.currentTimeMillis();
	String location;

	/**
	 * run method opens up a gui that asks the user for what tree they would like to chop then uses the getTRee() method from GUI to get the location the user selected
	 * to decide which area the bot should go to and what trees to chop
	 * if statements - tests to see what was returned from the GUI and selects which class to run based off of the user preferred location, then runs the activities related to that
	 * tree and then sleeps for 300 milliseconds until going through the while loop again
	 */
	@Override
	public void run() {
		guiStart();
		if(onStart()) {
			while (true) {
				if(location=="Tree") {
					if(!TreeCutter.Cutting() && Inventory.isFull() == false) {//if character is not cutting and the inventory is not full then cut tree else bank the logs
						TreeCutter.cuttingActivity();
					}else if(Inventory.isFull()) {
						TreeBanker.bankingActivity();
					}

				}
				if(location=="Oak Tree") {
					if(!OakCutter.Cutting() && Inventory.isFull() == false) {
						OakCutter.cuttingActivity();
					}else if(Inventory.isFull()) {
						OakBanker.bankingActivity();
					}

				}
				if(location=="Willow Tree") {
					if(!WillowCutter.Cutting() && Inventory.isFull() == false) {
						WillowCutter.cuttingActivity();
					}else if(Inventory.isFull()) {
						WillowBanker.bankingActivity();
					}
				}
				if(location=="Yew Tree") {
					if(!YewCutter.Cutting() && Inventory.isFull() == false) {
						YewCutter.cuttingActivity();
					}else if(Inventory.isFull()) {
						YewBanker.bankingActivity();
					}
				}
				sleep(300);
			}
		}

	}

	/**
	 * tests to see if this class started
	 * @return true if the class started
	 */
	public boolean onStart() {
		return true;
	}

	/**
	 * Creates the gui from class GUI and sets the tree selected to a local value to then use in the run method
	 */
	public void guiStart() {
		GUI gui = new GUI();
		gui.setVisible(true);
		while(gui.isShowing()) {
			General.sleep(1000);
		}
		location = gui.getTree();
	}


}
