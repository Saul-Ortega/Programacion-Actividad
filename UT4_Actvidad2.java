import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UT4_Actvidad2 {

	public static void main(String[] args) {
		ArrayList<Player> player_list = new ArrayList<Player>();

		int ask_number_of_players;
		
		String message_number_players = "Dime el número de jugadoras que vas a introducir";
		String message_pos = "Dime el número de la posición";
		String message_name = "Dime el nombre de la jugadora";
		String message_team = "Dime el nombre del equipo";
		String message_valuation = "Dime su valoración";
		
		ask_number_of_players = errorManagementInt(message_number_players);
		
		Player players[] = new Player[ask_number_of_players];
		
		int counter_of_iterations = 0;
		do {
			for (int x = 0; x < ask_number_of_players; x++) {
				players[x] = new Player();
				int pos = players[x].readPos(message_pos, player_list);
				players[x].setPos(pos);
				String name = players[x].readName(message_name);
				players[x].setName(name);
				String team = players[x].readTeam(message_team);
				players[x].setTeam(team);
				double valuation = players[x].readValuation(message_valuation);
				players[x].setValuation(valuation);
				
				player_list.add(players[counter_of_iterations]);
				
				counter_of_iterations++;
			}
		} while (counter_of_iterations != ask_number_of_players);
		
		printArrayList(player_list);
		searchPlayerByPosition(player_list);
		int best_player_pos = returnBestPlayer(player_list);
		printBestPlayer(player_list, best_player_pos);
		int worst_player_pos = returnWorstPlayer(player_list);
		printWorstPlayer(player_list, worst_player_pos);
		
		printFinishProgram();
	}
	public static int errorManagementInt(String message) {
		String string_pos;
		int number  = 0;
		boolean keep_going = true;
		
		do {
			keep_going = true;
			string_pos = JOptionPane.showInputDialog(null, message);
			
			for (int i = 0; i < string_pos.length(); i++) {
				if (Character.isDigit(string_pos.charAt(i))) {
					number = Integer.parseInt(string_pos);
				} else {
					keep_going = false;
				}
			}
			
			if (number < 0) {
				keep_going = false;
				String error_message = "ERROR: el número no puede ser inferior a 0";
				JOptionPane.showMessageDialog(null, error_message);
			}
			
			if (!keep_going) {
				String error_message = "ERROR: has introducido un formato incorrecto";
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		return number;
	}
	public static void printArrayList(ArrayList<Player> player_list) {
		StringBuffer print_list = new StringBuffer("");
		for (int i = 0; i < player_list.size(); i++) {
			print_list.append(player_list.get(i).toStringBuffer());
			print_list.append("\n");
		}
		JOptionPane.showMessageDialog(null, print_list);
	}
	public static void searchPlayerByPosition(ArrayList<Player> player_list) {
		String message = "BUSCAR JUGADORA POR POSICIÓN\nIntroduce la posición de la jugadora a buscar";
		int pos = 0;
		do {
			pos = errorManagementInt(message);
			
			if (pos > player_list.size() || pos <= 0) {
				String error_message = "ERROR: la posicón se encuentra fuera de los parámetros";
				JOptionPane.showMessageDialog(null, error_message);
			} else {
				JOptionPane.showMessageDialog(null, player_list.get(pos - 1).toString());				
			}
			
		} while (pos > player_list.size() || pos <= 0);
	}
	public static int returnBestPlayer(ArrayList<Player> player_list) {
		int pos = 0;
		double best_val = Double.MIN_VALUE;
		
		for (int i = 0; i < player_list.size(); i++) {
			
			if (best_val < player_list.get(i).getValuation()) {
				best_val = player_list.get(i).getValuation();
				pos = player_list.get(i).getPos();
			}
		}
		
		return pos;
	}
	public static void printBestPlayer(ArrayList<Player> player_list, int pos) {
		String mesage = "----------------------------------\n"
				+ "JUGADORA MEJOR VALORADA\n"
				+ "----------------------------------\n";
		JOptionPane.showMessageDialog(null, mesage + player_list.get(pos - 1).toString());		
	}
	public static int returnWorstPlayer(ArrayList<Player> player_list) {
		int pos = 0;
		double worst_val = Double.MAX_VALUE;
		
		for (int i = 0; i < player_list.size(); i++) {
			
			if (worst_val > player_list.get(i).getValuation()) {
				worst_val = player_list.get(i).getValuation();
				pos = player_list.get(i).getPos();
			}	
		}
		
		return pos;
	}
	public static void printWorstPlayer(ArrayList<Player> player_list, int pos) {
		String mesage = "----------------------------------\n"
				+ "JUGADORA PEOR VALORADA\n"
				+ "----------------------------------\n";
		JOptionPane.showMessageDialog(null, mesage + player_list.get(pos - 1).toString());		
	}
	public static void printFinishProgram() {
		String message = "PROGRAMA FINALIZADO";
		JOptionPane.showMessageDialog(null, message);
	}
}
