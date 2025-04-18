import javax.swing.*;
import java.awt.*;

public class QuizGUI extends JFrame {
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    String[][] questions = new String[6][];
    String[][][] options = new String[6][][];
    int[][] answers = new int[6][];

    String[] categories = {"AFL", "Basketball", "Tennis", "Soccer", "American Football", "NRL"};
    int currentTopicIndex = 0;
    int currentQuestion = 0;
    int score = 0;

    JPanel quizPanel;
    JLabel questionLabel;
    JRadioButton[] optionButtons = new JRadioButton[4];
    ButtonGroup optionGroup = new ButtonGroup();
    JButton nextButton;

    public QuizGUI() {
        setTitle("Multi-Sport Quiz Game");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(34, 40, 49));

        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.background", new Color(0x00ADB5));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Panel.background", new Color(34, 40, 49));

        setupQuestions();
        setupScreens();

        add(mainPanel);
        cardLayout.show(mainPanel, "start");
        setVisible(true);
    }

    private void setupScreens() {
        addStartScreen();
        addCategoryScreen();
        addQuizScreen();
        addScoreScreen();
    }

    private void setupQuestions() {
        questions[0] = new String[]{
                "Who won the Brownlow in 2024?",
                "What year were the Gold Coast Suns introduced?",
                "Who is the all-time leading AFL goalkicker?",
                "Who was the no.1 draft pick in 2024?",
                "Who won the NAB Rising Star in 2023?"
        };
        options[0] = new String[][]{
                {"Patrick Cripps", "Nick Daicos", "Marcus Bontempelli", "Max Gawn"},
                {"2009", "2010", "2011", "2012"},
                {"Jack Darling", "Jarayd Roughead", "Tony Lockett", "Lance Franklin"},
                {"Harley Reid", "Sam Lalor", "Sid Draper", "Finn O'Sullivan"},
                {"Riley Sanders", "Sam Darcy", "Harley Reid", "Ollie Dempsey"}
        };
        answers[0] = new int[]{1, 1, 2, 0, 2};

        questions[1] = new String[]{
                "Who has the most points in NBA history?",
                "What team won the 2023 NBA Finals?",
                "Which country won the FIBA 2023 World Cup?",
                "Who is known as 'The Greek Freak'?",
                "Which player has the most NBA MVPs?"
        };
        options[1] = new String[][]{
                {"Kobe Bryant", "Kareem Abdul-Jabbar", "LeBron James", "Michael Jordan"},
                {"Warriors", "Lakers", "Nuggets", "Celtics"},
                {"USA", "Germany", "Spain", "Serbia"},
                {"Luka Dončić", "Giannis Antetokounmpo", "Nikola Jokić", "Rudy Gobert"},
                {"LeBron James", "Michael Jordan", "Bill Russell", "Kareem Abdul-Jabbar"}
        };
        answers[1] = new int[]{2, 2, 1, 1, 3};

        questions[2] = new String[]{
                "Who has the most Grand Slam titles (men)?",
                "What surface is the French Open played on?",
                "Which country hosts the Australian Open?",
                "Which player is known for the 'Come on!' celebration?",
                "How many Grand Slams are played each year?"
        };
        options[2] = new String[][]{
                {"Roger Federer", "Novak Djokovic", "Rafael Nadal", "Andy Murray"},
                {"Grass", "Clay", "Hard", "Indoor"},
                {"UK", "France", "USA", "Australia"},
                {"Roger Federer", "Novak Djokovic", "Rafael Nadal", "Lleyton Hewitt"},
                {"2", "3", "4", "5"}
        };
        answers[2] = new int[]{1, 1, 3, 3, 2};

        questions[3] = new String[]{
                "Who won the FIFA World Cup 2022?",
                "Which club has the most UEFA Champions League titles?",
                "Who is the all-time top scorer in international football?",
                "What year was the first FIFA World Cup held?",
                "Who is known as 'The GOAT' of football?"
        };
        options[3] = new String[][]{
                {"France", "Argentina", "Germany", "Brazil"},
                {"Barcelona", "AC Milan", "Real Madrid", "Bayern"},
                {"Cristiano Ronaldo", "Messi", "Ali Daei", "Neymar"},
                {"1920", "1930", "1940", "1950"},
                {"Pelé", "Maradona", "Messi", "Ronaldo"}
        };
        answers[3] = new int[]{1, 2, 0, 1, 2};

        questions[4] = new String[]{
                "Which team won Super Bowl LVIII (2024)?",
                "Who has the most career passing TDs in NFL history?",
                "What is the length of an NFL field (in yards)?",
                "Who is known as 'The GOAT' QB?",
                "How many players are on the field per team?"
        };
        options[4] = new String[][]{
                {"Chiefs", "49ers", "Eagles", "Patriots"},
                {"Tom Brady", "Drew Brees", "Peyton Manning", "Aaron Rodgers"},
                {"90", "100", "110", "120"},
                {"Patrick Mahomes", "Tom Brady", "Joe Montana", "Aaron Rodgers"},
                {"9", "10", "11", "12"}
        };
        answers[4] = new int[]{0, 0, 1, 1, 2};

        questions[5] = new String[]{
                "Which team won the 2023 NRL Premiership?",
                "How many players are in an NRL team on field?",
                "What is the name of NRL's biggest rivalry?",
                "Who is the all-time top try scorer?",
                "When was the NRL formed?"
        };
        options[5] = new String[][]{
                {"Panthers", "Broncos", "Rabbitohs", "Storm"},
                {"11", "12", "13", "14"},
                {"Roosters vs Rabbits", "Storm vs Panthers", "Eels vs Bulldogs", "Broncos vs Cowboys"},
                {"Billy Slater", "Cameron Smith", "Ken Irvine", "Greg Inglis"},
                {"1995", "1998", "2000", "2001"}
        };
        answers[5] = new int[]{0, 2, 0, 2, 1};
    }

    private void addStartScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("\uD83C\uDFC6 Welcome to the Multi-Sport Quiz 🏆", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(new Color(0xEEEEEE));

        JButton startButton = new JButton("Start");
        styleButton(startButton);
        startButton.addActionListener(e -> cardLayout.show(mainPanel, "category"));

        panel.add(label, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);
        mainPanel.add(panel, "start");
    }

    private void addCategoryScreen() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        JLabel label = new JLabel("Choose a Quiz Topic", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        for (int i = 0; i < categories.length; i++) {
            int index = i;
            JButton btn = new JButton(categories[i]);
            styleButton(btn);
            btn.addActionListener(e -> {
                currentTopicIndex = index;
                currentQuestion = 0;
                score = 0;
                loadQuestion();
                cardLayout.show(mainPanel, "quiz");
            });
            panel.add(btn);
        }

        mainPanel.add(panel, "category");
    }

    private void addQuizScreen() {
        quizPanel = new JPanel(new BorderLayout(10, 10));
        quizPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        quizPanel.setBackground(new Color(34, 40, 49));

        questionLabel = new JLabel("Question", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        quizPanel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionsPanel.setBackground(new Color(34, 40, 49));
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setBackground(new Color(34, 40, 49));
            optionButtons[i].setForeground(Color.WHITE);
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            optionGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        quizPanel.add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        styleButton(nextButton);
        nextButton.addActionListener(e -> checkAnswer());
        quizPanel.add(nextButton, BorderLayout.SOUTH);

        mainPanel.add(quizPanel, "quiz");
    }

    private void loadQuestion() {
        if (currentQuestion < questions[currentTopicIndex].length) {
            questionLabel.setText((currentQuestion + 1) + ". " + questions[currentTopicIndex][currentQuestion]);
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[currentTopicIndex][currentQuestion][i]);
            }
            optionGroup.clearSelection();
        } else {
            showScore();
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                if (i == answers[currentTopicIndex][currentQuestion]) {
                    score++;
                }
                break;
            }
        }
        currentQuestion++;
        loadQuestion();
    }

    private void addScoreScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(34, 40, 49));
        JLabel scoreLabel = new JLabel("", JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 22));
        scoreLabel.setForeground(new Color(0xF8F8F8));
        panel.add(scoreLabel, BorderLayout.CENTER);

        JButton backBtn = new JButton("Back to Categories");
        styleButton(backBtn);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "category"));
        panel.add(backBtn, BorderLayout.SOUTH);

        mainPanel.add(panel, "score");

        scoreUpdater = () -> {
            String topic = categories[currentTopicIndex];
            int total = questions[currentTopicIndex].length;
            scoreLabel.setText("\u2705 You scored " + score + " / " + total + " in " + topic + "!");
        };
    }

    private void styleButton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBackground(new Color(0x00ADB5));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    Runnable scoreUpdater;

    private void showScore() {
        scoreUpdater.run();
        cardLayout.show(mainPanel, "score");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizGUI::new);
    }
}