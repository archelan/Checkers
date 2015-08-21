
public class BoardDrawer {
	static void drawBoard(Board board){
		try {
			int printDelay = 0;
			outDelayPrint(" |");
			for (int x = 0; x < 8; x++) {
				outDelayPrint((char)('a'+x));
			}
			outDelayPrint("|");
			outDelayPrintln();
			for (int y = 7; y >= 0; y--) {
				outDelayPrint((y+1) + "|");				
				Thread.sleep(printDelay);
				for (int x = 0; x < 8; x++) {			
					Check check = board.getCheck(new Position(x, y));
					if (check == null) {
						outDelayPrint('.');						
					} else {
						char figure = check.isQueen() ? 'Q' : (char)174;
						if (check.getColor() == 1) {
							errDelayPrint(figure);
						} else {
							outDelayPrint(figure);
						}
					}
				}
				outDelayPrint("|" + (y+1));
				outDelayPrintln();
			}
			outDelayPrint(" |");
			for (int x = 0; x < 8; x++) {
				outDelayPrint((char)('a'+x));
			}
			outDelayPrint("|");
			outDelayPrintln();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static <T> void outDelayPrint(T t){
		System.out.print(t);
		flushAndWait();
	}
	
	private static <T> void errDelayPrint(T t){
		System.err.print(t);
		flushAndWait();
	}

	private static void outDelayPrintln(){
		System.out.println();
		flushAndWait();
	}
	
	@SuppressWarnings("unused")
	private static void errDelayPrintln(){
		System.err.println();
		flushAndWait();
	}
	
	private static void flushAndWait() {
		System.out.flush();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
