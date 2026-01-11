import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.io.File;

// ===================== ELECTRICITY BILL FRAME =====================

class ElectricityBillFrame extends JFrame {

    ElectricityBillFrame() {
        setTitle("Electricity Bill");
        setSize(400, 420);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Consumer No:");
        JLabel l2 = new JLabel("Consumer Name:");
        JLabel l3 = new JLabel("Previous Reading:");
        JLabel l4 = new JLabel("Current Reading:");
        JLabel l5 = new JLabel("Connection Type:");

        JTextField tfNo = new JTextField();
        JTextField tfName = new JTextField();
        JTextField tfPrev = new JTextField();
        JTextField tfCurr = new JTextField();
        JTextField tfType = new JTextField();

        JTextArea taResult = new JTextArea();
        taResult.setEditable(false);

        JButton btnCalc = new JButton("Calculate Bill");

        // ---- Set Bounds ----
        l1.setBounds(30, 30, 150, 25);
        tfNo.setBounds(180, 30, 150, 25);

        l2.setBounds(30, 70, 150, 25);
        tfName.setBounds(180, 70, 150, 25);

        l3.setBounds(30, 110, 150, 25);
        tfPrev.setBounds(180, 110, 150, 25);

        l4.setBounds(30, 150, 150, 25);
        tfCurr.setBounds(180, 150, 150, 25);

        l5.setBounds(30, 190, 150, 25);
        tfType.setBounds(180, 190, 150, 25);

        btnCalc.setBounds(120, 230, 150, 30);

        taResult.setBounds(30, 280, 320, 100);

        // ---- Add Components ----
        add(l1); add(tfNo);
        add(l2); add(tfName);
        add(l3); add(tfPrev);
        add(l4); add(tfCurr);
        add(l5); add(tfType);
        add(btnCalc);
        add(taResult);

        // ---- Button Action ----
        btnCalc.addActionListener(e -> {
            try {
                int prev = Integer.parseInt(tfPrev.getText());
                int curr = Integer.parseInt(tfCurr.getText());
                int units = curr - prev;
                double amount = units * 2; // simple calculation

                taResult.setText(
                        "Units Consumed: " + units + "\n" +
                        "Bill Amount: Rs. " + amount
                );
            } catch (Exception ex) {
                taResult.setText("Invalid Input!");
            }
        });

        setVisible(true);
    }
}

// ===================== EMPLOYEE PANEL =====================


class EmployeeFrame extends JFrame {

    EmployeeFrame() {
        setTitle("Employee Salary");
        setSize(420, 430);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel("ID:");
        JLabel l3 = new JLabel("Address:");
        JLabel l4 = new JLabel("Mail ID:");
        JLabel l5 = new JLabel("Mobile No:");
        JLabel l6 = new JLabel("Basic Pay:");
        JLabel l7 = new JLabel("Designation:");

        JTextField tfName = new JTextField();
        JTextField tfId = new JTextField();
        JTextField tfAddr = new JTextField();
        JTextField tfMail = new JTextField();
        JTextField tfMob = new JTextField();
        JTextField tfBasic = new JTextField();
        JTextField tfDesig = new JTextField();   // simple text field

        JTextArea taResult = new JTextArea();
        taResult.setEditable(false);

        JButton btnGen = new JButton("Generate Pay Slip");

        // ---- setBounds ----
        l1.setBounds(30, 30, 150, 25);
        tfName.setBounds(180, 30, 180, 25);

        l2.setBounds(30, 70, 150, 25);
        tfId.setBounds(180, 70, 180, 25);

        l3.setBounds(30, 110, 150, 25);
        tfAddr.setBounds(180, 110, 180, 25);

        l4.setBounds(30, 150, 150, 25);
        tfMail.setBounds(180, 150, 180, 25);

        l5.setBounds(30, 190, 150, 25);
        tfMob.setBounds(180, 190, 180, 25);

        l6.setBounds(30, 230, 150, 25);
        tfBasic.setBounds(180, 230, 180, 25);

        l7.setBounds(30, 270, 150, 25);
        tfDesig.setBounds(180, 270, 180, 25);

        btnGen.setBounds(110, 310, 200, 30);
        taResult.setBounds(30, 350, 330, 70);

        // ---- add ----
        add(l1); add(tfName);
        add(l2); add(tfId);
        add(l3); add(tfAddr);
        add(l4); add(tfMail);
        add(l5); add(tfMob);
        add(l6); add(tfBasic);
        add(l7); add(tfDesig);
        add(btnGen);
        add(taResult);

        // ---- logic ----
        btnGen.addActionListener(e -> {
            try {
                double bp = Double.parseDouble(tfBasic.getText());
                String desig = tfDesig.getText().toLowerCase();

                double DA;
                if (desig.equals("assistant professor"))
                    DA = 0.6 * bp;
                else if (desig.equals("associate professor"))
                    DA = 0.7 * bp;
                else
                    DA = 0.97 * bp;

                double HRA = 0.1 * bp;
                double PF = 0.12 * bp;

                double gross = bp + DA + HRA;
                double net = gross - PF;

                taResult.setText(
                        "Designation: " + desig + "\n" +
                        "Gross Salary: " + gross + "\n" +
                        "Net Salary: " + net
                );
            } catch (Exception ex) {
                taResult.setText("Invalid Input!");
            }
        });

        setVisible(true);
    }
}


// ===================== SHAPE FRAME =====================


class ShapeFrame extends JFrame {

    ShapeFrame() {
        setTitle("Shape Area");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Value 1:");
        JLabel l2 = new JLabel("Value 2:");

        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();

        JButton rect = new JButton("Rectangle");
        JButton tri = new JButton("Triangle");
        JButton circle = new JButton("Circle");

        JTextArea result = new JTextArea();
        result.setEditable(false);

        l1.setBounds(30, 30, 100, 25);
        tf1.setBounds(140, 30, 150, 25);

        l2.setBounds(30, 70, 100, 25);
        tf2.setBounds(140, 70, 150, 25);

        rect.setBounds(30, 110, 120, 30);
        tri.setBounds(170, 110, 120, 30);
        circle.setBounds(100, 150, 120, 30);

        result.setBounds(30, 200, 260, 50);

        add(l1); add(tf1);
        add(l2); add(tf2);
        add(rect); add(tri); add(circle);
        add(result);

        rect.addActionListener(e ->
            result.setText("Rectangle Area = " +
                Integer.parseInt(tf1.getText()) * Integer.parseInt(tf2.getText()))
        );

        tri.addActionListener(e ->
            result.setText("Triangle Area = " +
                (0.5 * Integer.parseInt(tf1.getText()) * Integer.parseInt(tf2.getText())))
        );

        circle.addActionListener(e ->
            result.setText("Circle Area = " +
                (3.14 * Integer.parseInt(tf1.getText()) * Integer.parseInt(tf1.getText())))
        );

        setVisible(true);
    }
}


// ===================== FINALLY FRAME =====================

class FinallyFrame extends JFrame {

    FinallyFrame() {
        setTitle("Finally Demonstration");
        setSize(400, 320);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        JButton btnNoExc = new JButton("No Exception");
        JButton btnExc = new JButton("With Exception");
        JButton btnReturn = new JButton("Return Statement");

        // ---- setBounds ----
        btnNoExc.setBounds(30, 30, 140, 30);
        btnExc.setBounds(200, 30, 140, 30);
        btnReturn.setBounds(110, 70, 160, 30);

        ta.setBounds(30, 120, 400, 500);

        // ---- add ----
        add(btnNoExc);
        add(btnExc);
        add(btnReturn);
        add(ta);

        // ---- No Exception ----
        btnNoExc.addActionListener(e -> {
            try {
                ta.append("No Exception :Try Block\n");
            } catch (Exception ex) {
                ta.append("No Exception : Catch Block\n");
            } finally {
                ta.append("No Exception : Finally Block\n");
            }
            ta.append("No Exception : End Block\n\n");
        });

        // ---- With Exception ----
        btnExc.addActionListener(e -> {
            try {
                ta.append("Exception :Try Block\n");
                int a = 10 / 0;
            } catch (Exception ex) {
                ta.append("Exception : Catch Block\n");
            } finally {
                ta.append("Exception : Finally Block\n");
            }
            ta.append("Exception : End Block\n\n");
        });

        // ---- Return Statement ----
        btnReturn.addActionListener(e -> {
            try {
                ta.append("with return :Try Block\n");
                return;
            } catch (Exception ex) {
                ta.append("with return : Catch Block\n");
            } finally {
                ta.append("with return : Finally Block\n");
            }
            ta.append("with return : End Block\n\n");

        });
        setVisible(true);
    }

}


// ===================== JOB APPLICATION FRAME =====================

class JobFrame extends JFrame {

    JobFrame() {
        setTitle("Job Application");
        setSize(350, 250);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel("Age:");

        JTextField tfName = new JTextField();
        JTextField tfAge = new JTextField();

        JButton submit = new JButton("Submit");
        JTextArea result = new JTextArea();

        l1.setBounds(30, 30, 100, 25);
        tfName.setBounds(140, 30, 150, 25);

        l2.setBounds(30, 70, 100, 25);
        tfAge.setBounds(140, 70, 150, 25);

        submit.setBounds(110, 110, 120, 30);
        result.setBounds(30, 150, 260, 50);

        add(l1); add(tfName);
        add(l2); add(tfAge);
        add(submit);
        add(result);

        submit.addActionListener(e -> {
            int age = Integer.parseInt(tfAge.getText());
            if (age < 18)
                result.setText("Too young to apply");
            else if (age > 40)
                result.setText("Too old to apply");
            else
                result.setText("Application Accepted");
        });

        setVisible(true);
    }
}


// ===================== MOUSE EVENTS FRAME =====================
class MouseFrame extends JFrame {
        JLabel lbl;

        MouseFrame() {
            setTitle("Mouse Events");
            setSize(400, 300);
            setLayout(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            lbl = new JLabel();
            lbl.setBounds(50, 50, 300, 30);
            add(lbl);

            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) { lbl.setText("Clicked at (" + e.getX() + "," + e.getY() + ")"); }
                public void mouseEntered(java.awt.event.MouseEvent e) { lbl.setText("Entered at (" + e.getX() + "," + e.getY() + ")"); }
                public void mouseExited(java.awt.event.MouseEvent e) { lbl.setText("Exited at (" + e.getX() + "," + e.getY() + ")"); }
                public void mousePressed(java.awt.event.MouseEvent e) { lbl.setText("Pressed at (" + e.getX() + "," + e.getY() + ")"); }
                public void mouseReleased(java.awt.event.MouseEvent e) { lbl.setText("Released at (" + e.getX() + "," + e.getY() + ")"); }
            });

            setVisible(true);
        }
    }

// ===================== MULTI-THREAD FRAME =====================

class ThreadFrame extends JFrame {

    ThreadFrame() {
        setTitle("Multi Thread with Random");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Number of random values:");
        JTextField tfCount = new JTextField();
        JButton btnStart = new JButton("Start");
        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        // ---- setBounds ----
        l1.setBounds(30, 20, 200, 25);
        tfCount.setBounds(230, 20, 100, 25);
        btnStart.setBounds(140, 60, 100, 30);
        ta.setBounds(30, 110, 400, 500);

        // ---- add ----
        add(l1);
        add(tfCount);
        add(btnStart);
        add(ta);

        // ---- thread logic ----
        btnStart.addActionListener(e -> {
            ta.setText("");
            int count = Integer.parseInt(tfCount.getText());

            Thread t = new Thread(() -> {
                Random r = new Random();

                for (int i = 1; i <= count; i++) {
                    int num = r.nextInt(100);

                    ta.append("Generated Number: " + num + "\n");

                    if (num % 2 == 0)
                        ta.append("Square: " + (num * num) + "\n");
                    else
                        ta.append("Cube: " + (num * num * num) + "\n");

                    ta.append("------------------\n");

                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                    }
                }
            });

            t.start();
        });

        setVisible(true);
    }
}

// ===================== PRODUCER-CONSUMER FRAME =====================


class ProducerConsumerFrame extends JFrame {

    JTextArea ta;

    ProducerConsumerFrame() {
        setTitle("Simple Producer Consumer");
        setSize(400, 320);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("No. of Items:");
        JLabel l2 = new JLabel("Producer Delay (ms):");
        JLabel l3 = new JLabel("Consumer Delay (ms):");

        JTextField tfItems = new JTextField();
        JTextField tfPDelay = new JTextField();
        JTextField tfCDelay = new JTextField();

        JButton btnStart = new JButton("Start");
        ta = new JTextArea();
        ta.setEditable(false);

        // ---- setBounds ----
        l1.setBounds(30, 20, 150, 25);
        tfItems.setBounds(200, 20, 120, 25);

        l2.setBounds(30, 55, 150, 25);
        tfPDelay.setBounds(200, 55, 120, 25);

        l3.setBounds(30, 90, 150, 25);
        tfCDelay.setBounds(200, 90, 120, 25);

        btnStart.setBounds(140, 130, 100, 30);
        ta.setBounds(30, 180, 400, 500);

        // ---- add ----
        add(l1); add(tfItems);
        add(l2); add(tfPDelay);
        add(l3); add(tfCDelay);
        add(btnStart);
        add(ta);

        // ---- action ----
        btnStart.addActionListener(e -> {
            ta.setText("");

            int items = Integer.parseInt(tfItems.getText());
            int pDelay = Integer.parseInt(tfPDelay.getText());
            int cDelay = Integer.parseInt(tfCDelay.getText());

            new Producer(items, pDelay).start();
            new Consumer(items, cDelay).start();
        });

        setVisible(true);
    }

    // -------- Producer Thread --------
    class Producer extends Thread {
        int items, delay;

        Producer(int items, int delay) {
            this.items = items;
            this.delay = delay;
        }

        public void run() {
            for (int i = 1; i <= items; i++) {
                ta.append("Produced item: " + i + "\n");
                try {
                    Thread.sleep(delay);
                } catch (Exception e) {}
            }
        }
    }

    // -------- Consumer Thread --------
    class Consumer extends Thread {
        int items, delay;

        Consumer(int items, int delay) {
            this.items = items;
            this.delay = delay;
        }

        public void run() {
            for (int i = 1; i <= items; i++) {
                ta.append("Consumed item: " + i + "\n");
                try {
                    Thread.sleep(delay);
                } catch (Exception e) {}
            }
        }
    }
}

// ===================== FILE INFORMATION FRAME =====================



class FileInfoFrame extends JFrame {

    FileInfoFrame() {
        setTitle("File Information");
        setSize(420, 350);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Enter File Name / Path:");
        JTextField tfFile = new JTextField();
        JButton btnCheck = new JButton("Check File");
        JTextArea taResult = new JTextArea();
        taResult.setEditable(false);

        // ---- setBounds ----
        l1.setBounds(30, 30, 200, 25);
        tfFile.setBounds(30, 60, 340, 25);
        btnCheck.setBounds(130, 100, 140, 30);
        taResult.setBounds(30, 150, 340, 140);

        // ---- add ----
        add(l1);
        add(tfFile);
        add(btnCheck);
        add(taResult);

        // ---- logic ----
        btnCheck.addActionListener(e -> {
            File f = new File(tfFile.getText());
            taResult.setText("");

            taResult.append("File Exists: " + f.exists() + "\n");
            taResult.append("Readable: " + f.canRead() + "\n");
            taResult.append("Writable: " + f.canWrite() + "\n");

            if (f.exists()) {
                taResult.append("File Type: " + (f.isFile() ? "File" : "Directory") + "\n");
                taResult.append("File Length: " + f.length() + " bytes\n");
            }
        });

        setVisible(true);
    }
}



class StringMethodsFrame extends JFrame {

    // ---------- String Compare ----------
    JTextField tfStr1, tfStr2;
    JTextArea taResult;

    // ---------- StringBuffer ----------
    JTextField tfSB, tfInsertPos, tfInsertStr, tfDelStart, tfDelEnd, tfAppendStr;

    StringMethodsFrame() {

        setTitle("String & StringBuffer Methods");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        taResult = new JTextArea();
        taResult.setEditable(false);
        taResult.setBounds(30, 360, 520, 90);
        add(taResult);

        // ================= STRING COMPARE PANEL =================
        JPanel p1 = new JPanel(null);
        p1.setBorder(BorderFactory.createTitledBorder("String Compare Methods"));
        p1.setBounds(20, 20, 550, 150);

        JLabel l1 = new JLabel("String 1:");
        JLabel l2 = new JLabel("String 2:");
        tfStr1 = new JTextField();
        tfStr2 = new JTextField();

        JButton bEq = new JButton("equals()");
        JButton bEqIg = new JButton("equalsIgnoreCase()");
        JButton bSW = new JButton("startsWith()");
        JButton bEW = new JButton("endsWith()");
        JButton bCT = new JButton("compareTo()");

        l1.setBounds(20, 30, 80, 25);
        tfStr1.setBounds(100, 30, 180, 25);

        l2.setBounds(20, 65, 80, 25);
        tfStr2.setBounds(100, 65, 180, 25);

        bEq.setBounds(300, 25, 220, 25);
        bEqIg.setBounds(300, 55, 220, 25);
        bSW.setBounds(20, 105, 160, 25);
        bEW.setBounds(190, 105, 160, 25);
        bCT.setBounds(360, 105, 160, 25);

        p1.add(l1); p1.add(tfStr1);
        p1.add(l2); p1.add(tfStr2);
        p1.add(bEq); p1.add(bEqIg);
        p1.add(bSW); p1.add(bEW); p1.add(bCT);

        add(p1);

        // ---------- String Compare Logic ----------
        bEq.addActionListener(e ->
                taResult.setText("equals(): " + tfStr1.getText().equals(tfStr2.getText())));

        bEqIg.addActionListener(e ->
                taResult.setText("equalsIgnoreCase(): " +
                        tfStr1.getText().equalsIgnoreCase(tfStr2.getText())));

        bSW.addActionListener(e ->
                taResult.setText("startsWith(): " +
                        tfStr1.getText().startsWith(tfStr2.getText())));

        bEW.addActionListener(e ->
                taResult.setText("endsWith(): " +
                        tfStr1.getText().endsWith(tfStr2.getText())));

        bCT.addActionListener(e -> {
            int r = tfStr1.getText().compareTo(tfStr2.getText());
            if (r == 0)
                taResult.setText("compareTo(): Strings are equal");
            else if (r < 0)
                taResult.setText("compareTo(): String 1 is less than String 2");
            else
                taResult.setText("compareTo(): String 1 is greater than String 2");
        });

        // ================= STRINGBUFFER PANEL =================
        JPanel p2 = new JPanel(null);
        p2.setBorder(BorderFactory.createTitledBorder("StringBuffer Methods"));
        p2.setBounds(20, 190, 550, 160);

        JLabel lSB = new JLabel("Initial String:");
        tfSB = new JTextField();

        JLabel lInsPos = new JLabel("Insert Pos:");
        tfInsertPos = new JTextField();
        JLabel lInsStr = new JLabel("Insert String:");
        tfInsertStr = new JTextField();

        JLabel lDelS = new JLabel("Delete Start:");
        tfDelStart = new JTextField();
        JLabel lDelE = new JLabel("Delete End:");
        tfDelEnd = new JTextField();

        JLabel lApp = new JLabel("Append String:");
        tfAppendStr = new JTextField();

        JButton bInsert = new JButton("Insert");
        JButton bDelete = new JButton("Delete");
        JButton bAppend = new JButton("Append");
        JButton bReverse = new JButton("Reverse");
        JButton bCap = new JButton("Capacity");

        lSB.setBounds(20, 30, 100, 25);
        tfSB.setBounds(120, 30, 180, 25);

        lInsPos.setBounds(20, 65, 80, 25);
        tfInsertPos.setBounds(100, 65, 50, 25);
        lInsStr.setBounds(160, 65, 90, 25);
        tfInsertStr.setBounds(260, 65, 140, 25);

        lDelS.setBounds(20, 95, 90, 25);
        tfDelStart.setBounds(110, 95, 50, 25);
        lDelE.setBounds(170, 95, 80, 25);
        tfDelEnd.setBounds(260, 95, 50, 25);

        lApp.setBounds(320, 30, 100, 25);
        tfAppendStr.setBounds(420, 30, 100, 25);

        bInsert.setBounds(420, 65, 100, 25);
        bDelete.setBounds(420, 95, 100, 25);
        bAppend.setBounds(320, 65, 90, 25);
        bReverse.setBounds(320, 95, 90, 25);
        bCap.setBounds(320, 125, 200, 25);

        p2.add(lSB); p2.add(tfSB);
        p2.add(lInsPos); p2.add(tfInsertPos);
        p2.add(lInsStr); p2.add(tfInsertStr);
        p2.add(lDelS); p2.add(tfDelStart);
        p2.add(lDelE); p2.add(tfDelEnd);
        p2.add(lApp); p2.add(tfAppendStr);
        p2.add(bInsert); p2.add(bDelete);
        p2.add(bAppend); p2.add(bReverse); p2.add(bCap);

        add(p2);

        // ---------- StringBuffer Logic ----------
        bInsert.addActionListener(e -> {
            StringBuffer sb = new StringBuffer(tfSB.getText());
            sb.insert(Integer.parseInt(tfInsertPos.getText()), tfInsertStr.getText());
            taResult.setText("After insert: " + sb);
        });

        bDelete.addActionListener(e -> {
    try {
        StringBuffer sb = new StringBuffer(tfSB.getText());

        int start = Integer.parseInt(tfDelStart.getText());
        int end   = Integer.parseInt(tfDelEnd.getText());

       
        sb.delete(start, end);

        taResult.setText("After delete: " + sb.toString());
    } catch (Exception ex) {
        taResult.setText("Invalid start or end position");
    }
});


        bAppend.addActionListener(e -> {
            StringBuffer sb = new StringBuffer(tfSB.getText());
            sb.append(tfAppendStr.getText());
            taResult.setText("After append: " + sb);
        });

        bReverse.addActionListener(e -> {
            StringBuffer sb = new StringBuffer(tfSB.getText());
            taResult.setText("After reverse: " + sb.reverse());
        });

        bCap.addActionListener(e -> {
            StringBuffer sb = new StringBuffer(tfSB.getText());
            taResult.setText("Capacity: " + sb.capacity());
        });

        setVisible(true);
    }
}




// ===================== MAIN FRAME =====================


public class Jframe extends JFrame {

    public Jframe() {
        setTitle("All Programs - JFrame Only");
        setSize(400, 560); // slightly increased height
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 1, 10, 10)); // one extra row

        add(createButtonPanel("Electricity Bill", () -> new ElectricityBillFrame()));
        add(createButtonPanel("Employee", () -> new EmployeeFrame()));
        add(createButtonPanel("Shape", () -> new ShapeFrame()));
        add(createButtonPanel("Finally", () -> new FinallyFrame()));
        add(createButtonPanel("Job Application", () -> new JobFrame()));
        add(createButtonPanel("Mouse Events", () -> new MouseFrame()));
        add(createButtonPanel("Multi Thread", () -> new ThreadFrame()));
        add(createButtonPanel("Producer Consumer", () -> new ProducerConsumerFrame()));
        add(createButtonPanel("String Methods", () -> new StringMethodsFrame())); // ✅ NEW

        setVisible(true);
    }

    // ---- helper method ----
    private JPanel createButtonPanel(String text, Runnable action) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton b = new JButton(text);

        b.setPreferredSize(new Dimension(200, 30)); // controlled width
        b.setFont(new Font("Arial", Font.PLAIN, 12));

        b.addActionListener(e -> action.run());
        p.add(b);
        return p;
    }

    public static void main(String[] args) {
        new Jframe();
    }
}





