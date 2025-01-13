import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question, first, second, third, forth, fifth, sixth, seventh, eithth, ninth, tenth;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, Lifeline, Submit, Previous;

    public static int timer = 150;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    public void setLabelColor(int questionNo, Color color) {
        switch (questionNo) {
            case 0:
                first.setForeground(color);
                break;
            case 1:
                second.setForeground(color);
                break;
            case 2:
                third.setForeground(color);
                break;
            case 3:
                forth.setForeground(color);
                break;
            case 4:
                fifth.setForeground(color);
                break;
            case 5:
                sixth.setForeground(color);
                break;
            case 6:
                seventh.setForeground(color);
                break;
            case 7:
                eithth.setForeground(color);
                break;
            case 8:
                ninth.setForeground(color);
                break;
            case 9:
                tenth.setForeground(color);
                break;
        }
    }

    String name;


   Quiz(String name) {
       this.name = name;

       setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(0,0,1440,392);
       add(image);

       first = new JLabel("[1]");
       first.setBounds(100,400,50,30);
       first.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(first);

       second = new JLabel("[2]");
       second.setBounds(160,400,50,30);
       second.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(second);

       third = new JLabel("[3]");
       third.setBounds(220,400,50,30);
       third.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(third);

       forth = new JLabel("[4]");
       forth.setBounds(280,400,50,30);
       forth.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(forth);

       fifth = new JLabel("[5]");
       fifth.setBounds(340,400,50,30);
       fifth.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(fifth);

       sixth = new JLabel("[6]");
       sixth.setBounds(400,400,50,30);
       sixth.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(sixth);

       seventh = new JLabel("[7]");
       seventh.setBounds(460,400,50,30);
       seventh.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(seventh);

       eithth = new JLabel("[8]");
       eithth.setBounds(520,400,50,30);
       eithth.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(eithth);

       ninth = new JLabel("[9]");
       ninth.setBounds(580,400,50,30);
       ninth.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(ninth);

       tenth = new JLabel("[10]");
       tenth.setBounds(640,400,50,30);
       tenth.setFont(new Font("Tahoma", Font.PLAIN,20));
       add(tenth);


       qno = new JLabel();
       qno.setBounds(100,450,50,30);
       qno.setFont(new Font("Tahoma", Font.PLAIN,24));
       add(qno);

       question = new JLabel();
       question.setBounds(150,450,900,30);
       question.setFont(new Font("Tahoma", Font.PLAIN,24));
       add(question);

       questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
       questions[0][1] = "JVM";
       questions[0][2] = "JDB";
       questions[0][3] = "JDK";
       questions[0][4] = "JRE";

       questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
       questions[1][1] = "int";
       questions[1][2] = "Object";
       questions[1][3] = "long";
       questions[1][4] = "void";

       questions[2][0] = "Which package contains the Random class?";
       questions[2][1] = "java.util package";
       questions[2][2] = "java.lang package";
       questions[2][3] = "java.awt package";
       questions[2][4] = "java.io package";

       questions[3][0] = "An interface with no fields or methods is known as?";
       questions[3][1] = "Runnable Interface";
       questions[3][2] = "Abstract Interface";
       questions[3][3] = "Marker Interface";
       questions[3][4] = "CharSequence Interface";

       questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
       questions[4][1] = "Stack";
       questions[4][2] = "String memory";
       questions[4][3] = "Random storage space";
       questions[4][4] = "Heap memory";

       questions[5][0] = "Which of the following is a marker interface?";
       questions[5][1] = "Runnable interface";
       questions[5][2] = "Remote interface";
       questions[5][3] = "Readable interface";
       questions[5][4] = "Result interface";

       questions[6][0] = "Which keyword is used for accessing the features of a package?";
       questions[6][1] = "import";
       questions[6][2] = "package";
       questions[6][3] = "extends";
       questions[6][4] = "export";

       questions[7][0] = "In java, jar stands for?";
       questions[7][1] = "Java Archive Runner";
       questions[7][2] = "Java Archive";
       questions[7][3] = "Java Application Resource";
       questions[7][4] = "Java Application Runner";

       questions[8][0] = "Which of the following is a mutable class in java?";
       questions[8][1] = "java.lang.StringBuilder";
       questions[8][2] = "java.lang.Short";
       questions[8][3] = "java.lang.Byte";
       questions[8][4] = "java.lang.String";

       questions[9][0] = "Which of the following option leads to the portability and security of Java?";
       questions[9][1] = "Bytecode is executed by JVM";
       questions[9][2] = "The applet makes the Java code secure and portable";
       questions[9][3] = "Use of exception handling";
       questions[9][4] = "Dynamic binding between objects";


       answers[0][1] = "JDB";
       answers[1][1] = "int";
       answers[2][1] = "java.util package";
       answers[3][1] = "Marker Interface";
       answers[4][1] = "Heap memory";
       answers[5][1] = "Remote interface";
       answers[6][1] = "import";
       answers[7][1] = "Java Archive";
       answers[8][1] = "java.lang.StringBuilder";
       answers[9][1] = "Bytecode is executed by JVM";



       opt1 = new JRadioButton();
       opt1.setBounds(170,520,700,30);
       opt1.setBackground(Color.white);
       opt1.setFont(new Font("Dialog", Font.PLAIN,20));
       add(opt1);

       opt2 = new JRadioButton();
       opt2.setBounds(170,560,700,30);
       opt2.setBackground(Color.white);
       opt2.setFont(new Font("Dialog", Font.PLAIN,20));
       add(opt2);

       opt3 = new JRadioButton();
       opt3.setBounds(170,600,700,30);
       opt3.setBackground(Color.white);
       opt3.setFont(new Font("Dialog", Font.PLAIN,20));
       add(opt3);

       opt4 = new JRadioButton();
       opt4.setBounds(170,640,700,30);
       opt4.setBackground(Color.white);
       opt4.setFont(new Font("Dialog", Font.PLAIN,20));
       add(opt4);

       groupoptions = new ButtonGroup();
       groupoptions.add(opt1);
       groupoptions.add(opt2);
       groupoptions.add(opt3);
       groupoptions.add(opt4);

       next = new JButton("Next");
       next.setBounds(1100,510,200,40);
       next.setFont(new Font("Tahoma", Font.PLAIN, 22));
       next.setBackground(new Color(30,144,255));
       next.setForeground(Color.BLACK);
       next.addActionListener(this);
       add(next);

       Previous = new JButton("Previous");
       Previous.setBounds(1100,590,200,40);
       Previous.setFont(new Font("Tahoma", Font.PLAIN, 22));
       Previous.setBackground(new Color(30,144,255));
       Previous.setForeground(Color.BLACK);
       Previous.addActionListener(this);
       add(Previous);

       Lifeline = new JButton("50-50 Lifeline");
       Lifeline.setBounds(1100,670,200,40);
       Lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
       Lifeline.setBackground(new Color(30,144,255));
       Lifeline.setForeground(Color.BLACK);
       Lifeline.addActionListener(this);
       add(Lifeline);

       Submit = new JButton("Submit");
       Submit.setBounds(1100,750,200,40);
       Submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
       Submit.setBackground(new Color(30,144,255));
       Submit.setForeground(Color.BLACK);
       Submit.addActionListener(this);
       Submit.setEnabled(false);
       add(Submit);

       start(count);


        setVisible(true);

    }


    public void actionPerformed (ActionEvent ae) {
       if (ae.getSource() == next) {
           repaint();
           opt1.setEnabled(true);
           opt2.setEnabled(true);
           opt3.setEnabled(true);
           opt4.setEnabled(true);

           ans_given = 1;
           if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
           } else {
               useranswers[count][0] =groupoptions.getSelection().getActionCommand();
           }

           if (!useranswers[count][0].equals("")){
               setLabelColor(count, Color.GREEN);

           } else {
               setLabelColor(count,Color.red);
           }

           if (count == 8) {
               next.setEnabled(false);
               Submit.setEnabled(true);

           }

           count++;
           start(count);
       } else if (ae.getSource() == Previous) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] =groupoptions.getSelection().getActionCommand();
            }

           count--;

            if (count == 8) {
                Submit.setEnabled(false);

            }
            next.setEnabled(true);
            Submit.setEnabled(false);


            start(count);
        }else if (ae.getSource() == Lifeline) {
           if (count == 2 || count == 4 || count == 6 || count == 8 || count ==9)  {
               opt1.setEnabled(false);
               opt4.setEnabled(false);
           } else {
               opt2.setEnabled(false);
               opt3.setEnabled(false);
           }
           Lifeline.setEnabled(false);
       } else if (ae.getSource() == Submit) {
           ans_given = 1;
           useranswers[count][0] = "";
       } else {
           useranswers[count][0] = groupoptions.getSelection().getActionCommand();
       }


       for(int i = 0; i < useranswers.length; i++) {
           if (useranswers[i][0].equals(answers[i][1])) {
               score += 10;
           }
       }
       setVisible(false);
         new Score(name, score);
    }

    public void paint(Graphics g) {
       super.paint(g);

       String time = "Time left - " + timer + " seconds";

       if (timer <= 15) {
           g.setColor(Color.red);
       } else {
           g.setColor(Color.green);
       }

       g.setFont(new Font("Tahoma", Font.BOLD,20));

       if(timer > 0) {
           g.drawString(time, 1100,500);
       } else {
           g.drawString("Times up!!", 1100,500);
       }

       timer--;

       try{
           Thread.sleep(1000);
           repaint();
       } catch (Exception e) {
          e.printStackTrace();
       }

       if (timer < 0 && count == 8) {
           ans_given = 0;
           timer = 150;
       } else if (timer < 0 && count == 8) {
           timer = 150;

               next.setEnabled(false);
               Previous.setEnabled(true);
               Submit.setEnabled(true);

           if (count == 9) {
               if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
               } else {
                   useranswers[count][0] = groupoptions.getSelection().getActionCommand();
               }

               for(int i = 0; i < useranswers.length; i++) {
                   if (useranswers[i][0].equals(answers[i][1])) {
                       score += 10;
                   } else {
                       score += 0;
                   }
               }
               setVisible(false);
                new Score(name, score);
           } else {

               if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
               } else {
                   useranswers[count][0] = groupoptions.getSelection().getActionCommand();
               }
               count++;
               start(count);
           }
       }


    }


    public void start (int count)  {

       groupoptions.clearSelection();


       qno.setText("" + (count + 1) + ". ");
       question.setText(questions[count][0]);

       opt1.setText(questions[count][1]);
       opt1.setActionCommand(questions[count][1]);

       opt2.setText(questions[count][2]);
       opt2.setActionCommand(questions[count][2]);

       opt3.setText(questions[count][3]);
       opt3.setActionCommand(questions[count][3]);

       opt4.setText(questions[count][4]);
       opt4.setActionCommand(questions[count][4]);

       if (useranswers[count][0] !=null && !useranswers[count][0].equals("")) {
           if(useranswers[count][0].equals(questions[count][1])) {
               opt1.setSelected(true);
           } else if (useranswers[count][0].equals(questions[count][2])) {
               opt2.setSelected(true);
           } else if (useranswers[count][0].equals(questions[count][3])) {
               opt3.setSelected(true);
           } else if (useranswers[count][0].equals(questions[count][4])) {
               opt4.setSelected(true);
           }

       }
    }


    public static void main (String[] args){

       new Quiz("User");

    }
}
