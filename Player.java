import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Player {
	// ATRIBUTOS
	private int pos;
	private String name;
	private String team;
	private double valuation;
	
	// CONSTRUCTORES
	public Player() {
		
	}
	
	public Player(int pos, String name, String team, double valuation) {
		this.pos = pos;
		this.name = name;
		this.team = team;
		this.valuation = valuation;
	}
	
	// SETTER
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public void setValuation(double valuation) {
		this.valuation = valuation;
	}
	
	// GETTER
	public int getPos() {
		return this.pos;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public double getValuation() {
		return this.valuation;
	}
	
	// MÉTODO TO STRING
	@Override
	public String toString() {
		return "Player [pos=" + pos + ", name=" + name + ", team=" + team + ", valuation=" + valuation + "]";
	}
	
	public StringBuffer toStringBuffer() {
		StringBuffer string_buffer = new StringBuffer("");
		string_buffer.append("Player [pos=" + pos + ", name=" + name + ", team=" + team + ", valuation=" + valuation + "]");
		return string_buffer;
	}
	
	// MÉTODOS PARA LEER MEDIANTE JOPTIONPANE
	public int readPos(String message, ArrayList<Player> player_list) {
		String string_pos;
		int pos  = 0;
		boolean keep_going = true;
		
		do {
			try {
				keep_going = true;
				string_pos = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < string_pos.length(); i++) {
					if (Character.isDigit(string_pos.charAt(i))) {
						pos = Integer.parseInt(string_pos);
					} else {
						keep_going = false;
					}
				}
				
				for (int x = 0; x < player_list.size(); x++) {
					if (pos == player_list.get(x).getPos()) {
						keep_going = false;
						String error_message = "ERROR: la posición ya está asignada, escoge otra";
						JOptionPane.showMessageDialog(null, error_message);
					}
				}
				
				if (pos < 0) {
					keep_going = false;
					String error_message = "ERROR: el número no puede ser inferior a 0";
					JOptionPane.showMessageDialog(null, error_message);
				}
				
				if (!keep_going) {
					String error_message = "ERROR: has introducido un formato incorrecto";
					JOptionPane.showMessageDialog(null, error_message);
				}	
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción";
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		return pos;
	}
	public String readName(String message) {
		String name = "";
		boolean keep_going = true;
		
		do {
			try {
				keep_going = true;
				name = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < name.length(); i++) {
					if (!Character.isLetter(name.charAt(i)) && !Character.isSpaceChar(name.charAt(i))) {
						keep_going = false;
					}
				}
				
				if (!keep_going) {
					String error_message = "ERROR: has introducido un formato incorrecto";
					JOptionPane.showMessageDialog(null, error_message);
				}				
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción";
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		return name;
	}
	
	public String readTeam(String message) {
		String team = "";
		boolean keep_going = true;
		
		do {
			try {
				keep_going = true;
				team = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < team.length(); i++) {
					if (!Character.isLetter(team.charAt(i)) && !Character.isSpaceChar(team.charAt(i))) {
						keep_going = false;
					}
				}
				
				if (!keep_going) {
					String error_message = "ERROR: has introducido un formato incorrecto";
					JOptionPane.showMessageDialog(null, error_message);
				}				
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción";
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		return team;
	}
	
	public double readValuation(String message) {
		String string_valuation;
		double valuation  = 0;
		boolean keep_going = true;
		
		do {
			try {
				keep_going = true;
				string_valuation = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < string_valuation.length(); i++) {
					if (Character.isDigit(string_valuation.charAt(i)) || string_valuation.charAt(i) == 46) {
						valuation = Double.parseDouble(string_valuation);
					} else {
						keep_going = false;
					}
				}
				
				if (valuation < 0) {
					keep_going = false;
					String error_message = "ERROR: el número no puede ser inferior a 0";
					JOptionPane.showMessageDialog(null, error_message);
				}
				
				if (!keep_going) {
					String error_message = "ERROR: has introducido un formato incorrecto";
					JOptionPane.showMessageDialog(null, error_message);
				}				
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción";
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		return valuation;
	}
}
