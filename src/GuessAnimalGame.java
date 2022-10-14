import java.util.Scanner;

public class GuessAnimalGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DesTreeNode<String> startNode;
        gameInstruct();
        startNode = beginDesTree();
        do {
            play(startNode);
        } while (check("Сыграем еще раз?"));
        System.out.println("Спасибо!");
        System.exit(0);
    }

    private static boolean check(String query) {
        String answer;
        System.out.print(query + " [Д или Н]: ");
        answer = scanner.nextLine().toUpperCase();
        while (!answer.startsWith("Д") && !answer.startsWith("Н")) {
            System.out.print("Отвечай Д или Н: ");
            answer = scanner.nextLine().toUpperCase();
        }
        return answer.startsWith("Д");
    }

    private static void play(DesTreeNode<String> current) {
        while (!current.isLeaf()) {
            if (check(current.getData())) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        if (!check("Я думаю, что это " + current.getData() + ". Я прав?")) {
            learn(current);
        } else {
            System.out.println("Магия!)");
        }
    }

    private static void learn(DesTreeNode<String> current) {
        String guessAnimal;   // The animal that was just guessed
        String correctAnimal; // The animal that the user was thinking of
        String newQuestion;   // A question to distinguish the two animals

        // Set Strings for the guessed animal, correct animal and a new question.
        guessAnimal = current.getData();

        System.out.println("Здаюсь. Что за животное?");
        correctAnimal = scanner.nextLine();
        if (correctAnimal == null || correctAnimal.equals("")) System.exit(0);

        System.out.println("Напиши чем отличается " + correctAnimal + " от " + guessAnimal + ".");
        newQuestion = scanner.nextLine();
        if (newQuestion == null || newQuestion.equals("")) System.exit(0);


        // Put the new question in the current node, and add two new children.
        current.setData(newQuestion);
        if (check("У " + correctAnimal + " " + newQuestion)) {
            current.setLeftChild(new DesTreeNode<>(correctAnimal, null, null));
            current.setRightChild(new DesTreeNode<>(guessAnimal, null, null));
        } else {
            current.setLeftChild(new DesTreeNode<>(guessAnimal, null, null));
            current.setRightChild(new DesTreeNode<>(correctAnimal, null, null));
        }
    }

    private static DesTreeNode<String> beginDesTree() {
        DesTreeNode<String> root;
        DesTreeNode<String> child;

        final String ROOT_QUESTION = "Животное живет на суше?";
        final String ANIMAL1 = "Кот";
        final String ANIMAL2 = "Кит";

        root = new DesTreeNode<>(ROOT_QUESTION, null, null);

        child = new DesTreeNode<>(ANIMAL1, null, null);
        root.setLeftChild(child);

        child = new DesTreeNode<>(ANIMAL2, null, null);
        root.setRightChild(child);

        return root;
    }

    private static void gameInstruct() {
        System.out.println("Загадай животное, а я попробую угадать...");
        System.out.println("Я задам несколько вопросов \"да\" / \"нет\", чтобы попытаться понять какое животное ты загадал.");
    }
}
