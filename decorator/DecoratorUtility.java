package decorator;

public class DecoratorUtility {
    // This function was graciously provided by ChatGPT
    public static void dramaticPrint(String text, int speed, int pauseBetweenLines) {
        for (String line : text.split("\n")) {
            for (char character : line.toCharArray()) {
                System.out.print(character);
                
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println();
            
            try {
                Thread.sleep(pauseBetweenLines);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
