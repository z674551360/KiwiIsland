package nz.ac.aut.ense701.gameModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SaveLoad {
	Game game;
	Island island;
	Player player;

	public SaveLoad() {

	}

	public SaveLoad(Game game) {
		this.game = game;
		island = game.getIsland();
		player = game.getPlayer();
	}

	public void save() {
		try {
			File file = new File("data");
			file.mkdirs();
			String fileName = "./data/" + game.getPlayerName();
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter buffw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(buffw);
			ArrayList<String> mapItems = new ArrayList<String>();
			Occupant[] mapOccupant;
			String playerP = "";
			Position currentP;
			for (int i = 0; i < game.getNumRows(); i++) {
				for (int n = 0; n < game.getNumColumns(); n++) {
					// Iterate whole map treeain
					currentP = new Position(island, i, n);
					pw.print(island.getTerrain(currentP).getStringRepresentation());

					// Find player's position
					if (island.hasPlayer(currentP)) {
						playerP = currentP.getRow() + "," + currentP.getColumn();
					}

					// Iterate the rest of the occuoants
					mapOccupant = island.getOccupants(currentP);
					if (mapOccupant.length > 0) {
						for (int m = 0; m < mapOccupant.length; m++) {
							Occupant occupant = mapOccupant[m];
							String occType = occupant.getType();
							String string = occType + "," + occupant.getName() + "," + occupant.getDescription() + ","
									+ currentP.getRow() + "," + currentP.getColumn();
							if (occType.equals("T")) {
								string += "," + ((Tool) occupant).getWeight() + "," + ((Tool) occupant).getSize() + ",";
							} else if (occType.equals("E")) {
								string += "," + ((Food) occupant).getWeight() + "," + ((Food) occupant).getSize() + ","
										+ ((Food) occupant).getEnergy() + ",";
							} else if (occType.equals("H")) {
								string += "," + ((Hazard) occupant).getImpact() + ",";
							} else if (occType.equals("K")) {
								string += ",";
							} else if (occType.equals("P")) {
								string += ",";
							} else if (occType.equals("F")) {
								string += ",";
							}
							mapItems.add(string);
						}
						mapOccupant = null;
					}

				}
				pw.println(",");
			}
			for (int i = 0; i < mapItems.size(); i++) {
				pw.println(mapItems.get(i).toString());
			}

			//Check what item has owned
			pw.println("@owned");
			HashSet<Item> backpack = player.getBackpack();
			Iterator<Item> it = backpack.iterator();
			while (it.hasNext()) {
				Item item = it.next();
				String itemType = item.getType();
				String string = itemType+","+item.getName()+","+item.getDescription()+","+item.getWeight()+","+item.getSize();
				if (itemType.equals("E")) {
					string += "," + ((Food) item).getEnergy() + ",";
				}else{
					string += ",";
				}
				pw.println(string);
			}
			
			//Check player stamina and position
			pw.println("@player");
			pw.println(player.getStaminaLevel());
			pw.println(playerP);


			pw.close();
			buffw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void load(String fileName, String username) {

	}

}
